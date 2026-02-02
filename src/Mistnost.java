import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mistnost {

    private final String id;
    private final String nazev;
    private final String popis;
    private Map<String, Mistnost> sousedniMistnosti = new HashMap<>();
    private final Map<String, Predmet> predmety = new HashMap<>();
    private final Map<String, Postava> postavy = new HashMap<>();

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

    public void pridejSouseda(Mistnost mistnost) {
        sousedniMistnosti.put(mistnost.getNazev().toLowerCase(), mistnost);
    }

    public Mistnost dejSouseda(String nazevMistnosti) {
        return sousedniMistnosti.get(nazevMistnosti.toLowerCase());
    }

    public Map<String, Mistnost> getSousedniMistnosti() {
        return Collections.unmodifiableMap(sousedniMistnosti);
    }

    public void pridejPredmet(Predmet predmet) {
        predmety.put(predmet.getNazev().toLowerCase(), predmet);
    }

    public Predmet odeberPredmet(String nazev) {
        return predmety.remove(nazev.toLowerCase());
    }

    public Predmet najdiPredmet(String nazev) {
        return predmety.get(nazev.toLowerCase());
    }

    public Collection<Predmet> getPredmety() {
        return predmety.values();
    }

    public void pridejPostavu(Postava postava) {
        postavy.put(postava.getJmeno().toLowerCase(), postava);
    }

    public Postava najdiPostavu(String jmeno) {
        return postavy.get(jmeno.toLowerCase());
    }

    public Collection<Postava> getPostavy() {
        return postavy.values();
    }
}
