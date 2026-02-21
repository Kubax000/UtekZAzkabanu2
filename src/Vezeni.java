import java.util.HashMap;
import java.util.Map;

public class Vezeni {

    private Map<String, Mistnost> mistnosti = new HashMap<>();
    private Mistnost startovniMistnost;

    /**
     * Ulozi mistnost do mapy vezeni
     * @param mistnost Mistnost ktera se ma pridat
     */
    public void pridejMistnost(Mistnost mistnost) {
        mistnosti.put(mistnost.getId(), mistnost);
    }

    /**
     * Vyhleda mistnost podle id
     * @param id Identifikator mistnosti
     * @return Nalezena mistnost nebo null, pokud neexistuje
     */
    public Mistnost najdiMistnost(String id) {
        return mistnosti.get(id);
    }

    public Mistnost getStartovniMistnost() {
        return startovniMistnost;
    }

    public void setStartovniMistnost(Mistnost startovniMistnost) {
        this.startovniMistnost = startovniMistnost;
    }
}
