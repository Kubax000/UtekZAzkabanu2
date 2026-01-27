import java.util.Map;

public class NastaveniMistnosti {
    private String id;
    private String nazev;
    private String popis;
    private Map<String, String> vychody;

    public NastaveniMistnosti() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }
    public void setPopis(String popis) {
        this.popis = popis;
    }

    public Map<String, String> getVychody() {
        return vychody;
    }

    public void setVychody(Map<String, String> vychody) {
        this.vychody = vychody;
    }
}
