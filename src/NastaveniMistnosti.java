import java.util.List;
import java.util.Map;

public class NastaveniMistnosti {
    private String id;
    private String nazev;
    private String popis;
    private Map<String, String> vychody;
    private List<NastaveniPredmetu> predmety;
    private List<NastaveniPostavy> postavy;

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

    public List<NastaveniPredmetu> getPredmety() {
        return predmety;
    }
    public void setPredmety(List<NastaveniPredmetu> predmety) {
        this.predmety = predmety;
    }

    public List<NastaveniPostavy> getPostavy() {
        return postavy;
    }
    public void setPostavy(List<NastaveniPostavy> postavy) {
        this.postavy = postavy;
    }
}
