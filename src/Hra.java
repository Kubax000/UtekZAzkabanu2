import java.nio.file.Path;
import java.util.Scanner;

public class Hra {

    private Vezeni vezeni;
    private Hrac hrac;
    private boolean bezi;
    private final Scanner scanner = new Scanner(System.in);
    private final Prikazy prikazy = new Prikazy();

    public  Hra() {}

    public void spustHru() throws Exception {
        inicializujHru();
        vypisMisto();

        bezi = true;
        while (bezi) {
            System.out.print("\n> ");
            String vstup = scanner.nextLine();
            spustPrikazZeVstupu(vstup);
        }
    }

    private void inicializujHru() throws Exception {
        NacitacVezeni nacitac = new NacitacVezeni();
        vezeni = nacitac.nactiZJson(Path.of("resourse/mistnost.json"));
        hrac = new Hrac(vezeni.getStartovniMistnost());
        registrujPrikazy();
    }

    private void registrujPrikazy(){
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
        if (vstup == null){
            return;
        }

        vstup = vstup.trim().toLowerCase();
        if (vstup.isEmpty()){
            return;
        }

        Prikaz prikaz = prikazy.najdiPrikaz(vstup);
        if (prikaz == null) {
            System.out.println("Neznamy prikaz. Napis 'pomoc'.");
            return;
        }

        String parametr = prikazy.parametr(vstup);
        prikaz.vykonej(this, parametr);
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


}
