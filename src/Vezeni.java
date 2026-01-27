import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Vezeni {

    private Map<String, Mistnost> mistnosti = new HashMap<>();
    private Mistnost startovniMistnost;

    public Vezeni() {
    }

    public void pridejMistnost(Mistnost mistnost) {
        mistnosti.put(mistnost.getId(), mistnost);
    }

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
