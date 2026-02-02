import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Prikazy {

    private final Map<String, Prikaz> registry = new HashMap<>();

    public Prikazy(){}

    public void zaregistruj(Prikaz prikaz){
        registry.put(prikaz.getNazev().toLowerCase(), prikaz);
    }

    public Prikaz najdiPrikaz(String vstup) {
        if (vstup == null) {
            return null;
        }
        vstup = vstup.trim().toLowerCase();
        if (vstup.isEmpty()) {
            return null;
        }

        String[] casti = vstup.split("\\s+", 2);
        String nazev = casti[0].toLowerCase();
        return registry.get(nazev);
    }

    public String parametr(String vstup){
        if(vstup == null){
            return "";
        }
        vstup = vstup.trim().toLowerCase();
        String[] casti = vstup.split("\\s+", 2);
        if(casti.length < 2){
            return "";
        }
        return casti[1].trim();
    }

    public void vypisPomoc(){
        System.out.println("Dostupne prikazy:");
        for (Prikaz p : registry.values()) {
            System.out.println("- " + p.getNazev() + " : " + p.getPopis());
        }
        System.out.println("Pohyb: pouzivej prikaz 'jdi <nazev mistnosti>'");
    }

}
