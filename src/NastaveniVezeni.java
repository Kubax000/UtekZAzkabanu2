import java.util.List;

public class NastaveniVezeni {
    private String start;
    private List<NastaveniMistnosti> mistnosti;

    public NastaveniVezeni() {}

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public List<NastaveniMistnosti> getMistnosti() {
        return mistnosti;
    }
    public void setMistnosti(List<NastaveniMistnosti> mistnosti) {
        this.mistnosti = mistnosti;
    }
}
