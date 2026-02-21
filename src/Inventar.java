import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Trida ktera reprezentuje hracuv inventar s omezenou kapacitou
 */
public class Inventar {

    private final int kapacita;
    private final Map<String, Predmet>veci = new LinkedHashMap<>();

    /**
     * Vytvori prazdny inventar s danou kapacitou
     * @param kapacita Maximalni pocet premetu, ktery se do inventare vejde
     */
    public  Inventar(int kapacita){
        this.kapacita = kapacita;
    }

    /**
     * Zkusi pridat predmet do inventare
     * @param predmet Predmet, ktery chce pridat
     * @return true - pokud byl predmet pridan, false - pokud je plny inventar
     */
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

    /**
     * Odebere predmet z inventare podle nazvu
     * @param nazev Nazev predmetu k odebrani
     * @return Vrati odebrany predmet, nebo null, pokud tam predmet nebyl
     */
    public Predmet odeberPredmet(String nazev){
        return veci.remove(nazev.toLowerCase().trim());
    }

    /**
     * Najde predmet v inventari
     * @param nazev Nazev hledaneho predmetu
     * @return Nalezeni predmet nebo null
     */
    public Predmet najdiPredmet(String nazev){
        return veci.get(nazev.toLowerCase().trim());
    }

    /**
     * Vypise vsechny premety, ktere u sebe momentalne hrac ma
     */
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
