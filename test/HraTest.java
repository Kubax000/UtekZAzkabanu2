import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testy pro overeni hlavni logiky hry
 * @author Jakub Eliasek
 */
public class HraTest {
    /**
     * Testuje spravne propojeni mistnosti mezi sebou
     */
    @Test
    void testMistnostSousedi() {
        Mistnost a = new Mistnost("a", "A", "popis a", "napoveda a");
        Mistnost b = new Mistnost("b", "B", "popis b", "napoveda b");
        a.pridejSouseda(b);

        assertNotNull(a.dejSouseda("B"));
        assertNull(a.dejSouseda("Neexistuje"));
    }

    /**
     * Testuje to, aby se hrac mohl pohnout jen do vedlejsi ( sousedni ) mistnosti
     */
    @Test
    void testHracPohybJenNaSouseda() {
        Mistnost cela = new Mistnost("cela", "Cela", "x", "napoveda");
        Mistnost chodba = new Mistnost("chodba", "Chodba", "x", "napoveda");
        cela.pridejSouseda(chodba);

        Hrac h = new Hrac(cela);

        h.pohniSe("Chodba");
        assertEquals("chodba", h.getAktualniMistnost().getId());

        h.pohniSe("Neexistuje");
        assertEquals("chodba", h.getAktualniMistnost().getId());
    }

    /**
     * Overuje omezenou kapacitu inventare
     */
    @Test
    void testInventarKapacita() {
        Inventar inv = new Inventar(1);

        assertTrue(inv.pridejPredmet(new Predmet("A", "x", true)));
        assertFalse(inv.pridejPredmet(new Predmet("B", "x", true)));
    }

    /**
     * Testuje, jestli je mozne v mistnosti vzit/polozit predmet
     */
    @Test
    void testPredmetVMistnostiPridatOdebrat() {
        Mistnost m = new Mistnost("m", "M", "x", "napoveda");

        m.pridejPredmet(new Predmet("Klic", "x", true));
        assertNotNull(m.najdiPredmet("Klic"));

        Predmet odebrany = m.odeberPredmet("Klic");
        assertNotNull(odebrany);
        assertNull(m.najdiPredmet("Klic"));
    }

    /**
     * Overuje jestli spravne jsou oddelene vstupy a zkousi take prazdne vstupy
     */
    @Test
    void testPrikazyParametr() {
        Prikazy p = new Prikazy();

        assertEquals("chodba cel", p.parametr("jdi chodba cel"));
        assertEquals("", p.parametr("inventar"));
        assertEquals("", p.parametr("   "));
    }

    /**
     * Testuje nacteni herniho sveta z JSON
     * @throws Exception Pokud je chyba pri praci se souborem
     */
    @Test
    void testNacitacVezeniNacteniJson() throws Exception {
        String json = """
            {
              "start": "a",
              "mistnosti": [
                { "id": "a", "nazev": "A", "popis": "x", "napoveda": "rada a", "vychody": { "B": "b" }, "predmety": [], "postavy": [] },
                { "id": "b", "nazev": "B", "popis": "x", "napoveda": "rada b", "vychody": {}, "predmety": [], "postavy": [] }
              ]
            }
            """;

        Path tmp = Files.createTempFile("vezeni", ".json");
        Files.writeString(tmp, json);

        NacitacVezeni n = new NacitacVezeni();
        Vezeni v = n.nactiZJson(tmp);

        assertNotNull(v);
        assertNotNull(v.getStartovniMistnost());
        assertEquals("a", v.getStartovniMistnost().getId());
    }

    /**
     * Testuje vyhru hry.
     */
    @Test
    void testVyhraPouzitimKliceNaBrane() {
        FakeHra hra = new FakeHra();
        PrikazPouzij prikaz = new PrikazPouzij();

        prikaz.vykonej(hra, "Rezavy klic");

        assertTrue(hra.vyhraNastavena);
    }

    /**
     * Pomocna trida pro testovani
     */
    static class FakeHra extends Hra {
        boolean vyhraNastavena = false;
        private final Vezeni v;
        private final Hrac h;

        FakeHra() {
            v = new Vezeni();
            Mistnost brana = new Mistnost("hlavni_brana", "Hlavni brana Azkabanu", "popis", "pouzij klic");
            v.pridejMistnost(brana);
            v.setStartovniMistnost(brana);

            h = new Hrac(brana);
            h.getInventar().pridejPredmet(new Predmet("Rezavy klic", "x", true));
        }

        @Override
        public Vezeni getVezeni() { return v; }

        @Override
        public Hrac getHrac() { return h; }

        @Override
        public void nastavVyhru() { vyhraNastavena = true; }
    }
}