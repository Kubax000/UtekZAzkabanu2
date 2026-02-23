import java.util.HashMap;
import java.util.Map;

/**
 * Trida slouzi jako registr vsech dostupnych prikazu ve hre
 * Umi zpracovat text zasany uzivatelem a rozdelit ho na prikaz a parametr
 */
public class Prikazy {

    private final Map<String, Prikaz> registry = new HashMap<>();

    /**
     * Zaregistruje prikaz do mapy, aby ho hra umela rozpoznat
     * @param prikaz Instance prikazu, jako napr. PrikazJdi
     */
    public void zaregistruj(Prikaz prikaz) {
        registry.put(prikaz.getNazev().toLowerCase(), prikaz);
    }

    /**
     * Najde prislusny objekt prikazu podle zadani uzivatele
     * @param vstup Cely text napsany do konzole
     * @return Objekt prikazu, nebo null, pokud prikaz neexistuje nebo byl zadan spatne
     */
    public Prikaz najdiPrikaz(String vstup) {
        if (vstup == null) {
            return null;
        }
        vstup = vstup.trim().toLowerCase();
        if (vstup.isEmpty()) {
            return null;
        }
        String[] casti = vstup.split("\\s+", 2);
        return registry.get(casti[0].toLowerCase());
    }

    /**
     * Oddeli z uzivatelskeho vstupu samotny parametr
     * @param vstup Cely zadany text
     * @return Text parametru, nebo prazdny retezec, pokud uzivatel zadny parametr nezadal
     */
    public String parametr(String vstup) {
        if (vstup == null) {
            return "";
        }
        vstup = vstup.trim().toLowerCase();
        String[] casti = vstup.split("\\s+", 2);
        if (casti.length < 2) {
            return "";
        }
        return casti[1].trim();
    }

    /**
     * Vypise do konzole seznam vsech prikazu a jejich popis
     */
    public void vypisPomoc(){
        System.out.println("Dostupne prikazy:");
        for (Prikaz p : registry.values()) {
            System.out.println("- " + p.getNazev() + " : " + p.getPopis());
        }
    }

}
