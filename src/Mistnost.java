import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mistnost {

    private final String id;
    private final String nazev;
    private final String popis;
    private Map<String, Mistnost> sousedniMistnosti = new HashMap<>();

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
        sousedniMistnosti.put(
                mistnost.getNazev().toLowerCase(),
                mistnost
        );
    }

    public Mistnost dejSouseda(String nazevMistnosti) {
        return sousedniMistnosti.get(nazevMistnosti.toLowerCase());
    }

    public Map<String, Mistnost> getSousedniMistnosti() {
        return Collections.unmodifiableMap(sousedniMistnosti);
    }
}
