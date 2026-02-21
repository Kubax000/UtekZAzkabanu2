import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Trida ktera reprezentuje jdnu mistnost ve vezeni.
 * Kazda mistnost vi o svych sousedech, predmetach a postavach, ktere v ni jsou.
 */
public class Mistnost {

    private final String id;
    private final String nazev;
    private final String popis;
    private Map<String, Mistnost> sousedniMistnosti = new HashMap<>();
    private final Map<String, Predmet> predmety = new HashMap<>();
    private final Map<String, Postava> postavy = new HashMap<>();

    /**
     * Vytvori novou mistnost se zakladnimi udaji.
     * @param id Unikatni identifikator.
     * @param nazev Lepsi nazev pro hrace.
     * @param popis Text co hrac vidi
     */
    public Mistnost(String id, String nazev, String popis) {
        this.id = id;
        this.nazev = nazev;
        this.popis = popis;
    }

    public String getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    /**
     * propoji tuto mistnost s jinou.
     * @param mistnost Cilova mistnost kam se da odsud jit
     */
    public void pridejSouseda(Mistnost mistnost) {
        sousedniMistnosti.put(mistnost.getNazev().toLowerCase().trim(), mistnost);
    }

    /**
     * Vrati sousedni mistnost na zaklade jejiho nazvu
     * @param nazevMistnosti Nazev mistnosti kam chce hrac jit
     * @return Objekt sousedni mistnosti nebo null, pokud neexistuje
     */
    public Mistnost dejSouseda(String nazevMistnosti) {
        return sousedniMistnosti.get(nazevMistnosti.toLowerCase().trim());
    }

    /**
     * Vrati vsechny sousedni mistnosti do kterych se da odsud jit
     * @return Nemodifikovatelnou mapu sousednich mistnosti
     */
    public Map<String, Mistnost> getSousedniMistnosti() {
        return Collections.unmodifiableMap(sousedniMistnosti);
    }

    /**
     * Polozi predmet do mistnosti
     * @param predmet Objekt predmetu, ktery se ma v mistnosti objevit
     */
    public void pridejPredmet(Predmet predmet) {
        predmety.put(predmet.getNazev().toLowerCase().trim(), predmet);
    }

    /**
     * Odebere predmet z mistnosti
     * @param nazev Nazev predmetu k odebrani
     * @return Odebrany predmet nebo null, pokud v mistnsoti neni
     */
    public Predmet odeberPredmet(String nazev) {
        return predmety.remove(nazev.toLowerCase().trim());
    }

    /**
     * Najde predmet v mistnosti podle nazvu
     * @param nazev Nazev predmetu k nalezen
     * @return Predmet pokud je nalezen, jinak null
     */
    public Predmet najdiPredmet(String nazev) {
        return predmety.get(nazev.toLowerCase().trim());
    }

    /**
     * Vrati seznam vsech predmetu ktery v mistnosti aktualne jsou
     * @return Predemty ktere v mistnosti jsou
     */
    public Collection<Predmet> getPredmety() {
        return predmety.values();
    }

    public void pridejPostavu(Postava postava) {
        postavy.put(postava.getJmeno().toLowerCase().trim(), postava);
    }

    public Postava najdiPostavu(String jmeno) {
        return postavy.get(jmeno.toLowerCase().trim());
    }

    public Collection<Postava> getPostavy() {
        return postavy.values();
    }
}
