import java.util.LinkedHashMap;
import java.util.Map;

public class Inventar {

    private final int kapacita;
    private final Map<String, Predmet>veci = new LinkedHashMap<>();

    public  Inventar(int kapacita){
        this.kapacita = kapacita;
    }

    public boolean pridejPredmet(Predmet predmet){
        if (predmet == null){
            return false;
        }
        if (veci.size() >= kapacita){
            return false;
        }
        veci.put(predmet.getNazev().toLowerCase().trim(), predmet);
        return true;
    }

    public Predmet odeberPredmet(String nazev){
        return veci.remove(nazev.toLowerCase().trim());
    }

    public boolean obsahujePredmet(String nazev){
        return veci.containsKey(nazev.toLowerCase().trim());
    }

    public Predmet najdiPredmet(String nazev){
        return veci.get(nazev.toLowerCase().trim());
    }

    public void vypisInventar(){
        if (veci.isEmpty()) {
            System.out.println("Inventar je prazdny.");
            return;
        }
        System.out.println("Inventar:");
        for (Predmet p : veci.values()) {
            System.out.println("- " + p.getNazev());
        }
    }

}
