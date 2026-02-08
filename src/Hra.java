import java.nio.file.Path;
import java.util.Scanner;

public class Hra {

    private Vezeni vezeni;
    private Hrac hrac;
    private boolean bezi;
    private final StavHry stav = new StavHry();
    private final Scanner scanner = new Scanner(System.in);
    private final Prikazy prikazy = new Prikazy();

    /**
     * Spusti herni smycku, nacte vstup od uzivatele a spousti jednotlive prikazy
     * @throws Exception pokud nastane chyba pri inicializaci
     */
    public void spustHru() throws Exception {
        vypisUvod();
        inicializujHru();
        vypisMisto();

        bezi = true;
        while (bezi) {
            System.out.print("\n> ");
            String vstup = scanner.nextLine();
            spustPrikazZeVstupu(vstup);
            if(stav.jeVyhra()){
                System.out.println(" Vyhral jsi. Utekl jsi z Azkabanu. ");
                bezi = false;
            }
        }
    }

    private void inicializujHru() throws Exception {
        NacitacVezeni nacitac = new NacitacVezeni();
        vezeni = nacitac.nactiZJson(Path.of("resourse/mistnost.json"));
        hrac = new Hrac(vezeni.getStartovniMistnost());

        prikazy.zaregistruj(new PrikazJdi());
        prikazy.zaregistruj(new PrikazProzkoumej());
        prikazy.zaregistruj(new PrikazInventar());
        prikazy.zaregistruj(new PrikazVezmi());
        prikazy.zaregistruj(new PrikazPoloz());
        prikazy.zaregistruj(new PrikazPouzij());
        prikazy.zaregistruj(new PrikazMluv());
        prikazy.zaregistruj(new PrikazPomoc());
        prikazy.zaregistruj(new PrikazKonec());
    }

    public void spustPrikazZeVstupu(String vstup) {
        Prikaz p = prikazy.najdiPrikaz(vstup);
        if(p == null){
            System.out.println("Neznamy prikaz. Napis pomoc.");;
        }

        String parametr = prikazy.parametr(vstup);
        p.vykonej(this, parametr);
    }

    public void vypisMisto() {
        Mistnost m = hrac.getAktualniMistnost();

        System.out.println("\n== " + m.getNazev() + " ==");
        System.out.println(m.getPopis());

        System.out.println("\nMuzes jit do:");
        m.getSousedniMistnosti().keySet().forEach(n -> System.out.println("- " + n));

        if (!m.getPredmety().isEmpty()) {
            System.out.println("\nPredmety:");
            m.getPredmety().forEach(p -> System.out.println("- " + p.getNazev()));
        }

        if (!m.getPostavy().isEmpty()) {
            System.out.println("\nPostavy:");
            m.getPostavy().forEach(p -> System.out.println("- " + p.getJmeno()));
        }
    }

    private void vypisUvod() {
        System.out.println("==================================");
        System.out.println(" UTEK Z AZKABANU - textova hra");
        System.out.println("==================================");
        System.out.println("Cil: najdi 'Rezavy klic' a u hlavni brany pouzij: pouzij rezavy klic");
        System.out.println();
        System.out.println("Ovlada se to prikazy. Priklady:");
        System.out.println("  prozkoumej");
        System.out.println("  jdi chodba cel");
        System.out.println("  vezmi rezavy klic");
        System.out.println("  poloz chleba");
        System.out.println("  inventar");
        System.out.println("  mluv straz");
        System.out.println("  pomoc");
        System.out.println("  konec");
        System.out.println();
        System.out.println("Tip: Prikazy nejsou citlive na velikost pismen (muze byt i 'JDI ...').");
        System.out.println("==================================");
    }

    public Vezeni getVezeni() {
        return vezeni;
    }

    public Hrac getHrac() {
        return hrac;
    }

    public Prikazy getPrikazy() {
        return prikazy;
    }

    public void ukonci() {
        bezi = false;
        System.out.println("Hra ukoncena.");
    }

    public void nastavVyhru(){
        stav.nastavVyhru();
    }
}
