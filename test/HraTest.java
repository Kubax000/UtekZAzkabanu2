import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testy pro overeni hlavni logiky hry
 *  @author Jakub Eliasek
 */
public class HraTest {
    /**
     * Testuje spravne propojeni mistnosti mezi sebou
     */
    @Test
    void testMistnostSousedi() {
        Mistnost a = new Mistnost("a", "A", "x");
        Mistnost b = new Mistnost("b", "B", "x");
        a.pridejSouseda(b);

        assertNotNull(a.dejSouseda("B"));
        assertNull(a.dejSouseda("Neexistuje"));
    }

    /**
     * Testuje to, aby se hrac mohl pohnout jen do vedlejsi ( sousedni ) mistnosti
     */
    @Test
    void testHracPohybJenNaSouseda() {
        Mistnost cela = new Mistnost("cela", "Cela", "x");
        Mistnost chodba = new Mistnost("chodba", "Chodba", "x");
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
        Mistnost m = new Mistnost("m", "M", "x");

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
                { "id": "a", "nazev": "A", "popis": "x", "vychody": { "B": "b" }, "predmety": [], "postavy": [] },
                { "id": "b", "nazev": "B", "popis": "x", "vychody": {}, "predmety": [], "postavy": [] }
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
     * Testuje vyhru hry. Diky FakeHra testuje ze hrac ma spravny klic a odemika branu.
     */
    @Test
    void testVyhraPouzitimKliceNaBrane() {
        FakeHra hra = new FakeHra();
        PrikazPouzij prikaz = new PrikazPouzij();

        prikaz.vykonej(hra, "Rezavy klic");

        assertTrue(hra.vyhraNastavena);
    }

    /**
     * Pomocna trida, slouzi pro ucely testovani a pomaha nam simulovat vytezstvi ve hre
     */
    static class FakeHra extends Hra {
        boolean vyhraNastavena = false;

        private final Vezeni v;
        private final Hrac h;

        FakeHra() {
            v = new Vezeni();
            Mistnost brana = new Mistnost("hlavni_brana", "Hlavni brana Azkabanu", "x");
            v.pridejMistnost(brana);
            v.setStartovniMistnost(brana);

            h = new Hrac(brana);
            h.getInventar().pridejPredmet(new Predmet("Rezavy klic", "x", true));
        }

        @Override
        public Vezeni getVezeni() {
            return v;
        }

        @Override
        public Hrac getHrac() {
            return h;
        }

        @Override
        public void nastavVyhru() {
            vyhraNastavena = true;
        }
    }
}
