/**
 * Implementace prikazu jdi.
 * @author Jakub Eliasek
 */
public class PrikazJdi implements Prikaz {

    /**
     * Presune hrace do zadane mistnosti pokud existuje a neni zablokovana.
     * Nekterě mistnosti vyzaduji splneni podminek
     * @param hra aktualni hra
     * @param parametr zbytek vstupu
     */
    @Override
    public void vykonej(Hra hra, String parametr) {
        if (parametr.isEmpty()) {
            System.out.println("Pouziti: jdi <nazev mistnosti>");
            return;
        }

        String cil = parametr.trim().toLowerCase();
        Inventar inv = hra.getHrac().getInventar();
        StavHry stav = hra.getStav();

        if (cil.equals("sklad predmetu") && inv.najdiPredmet("rezavy klic") == null) {
            System.out.println("Dvere jsou zamcene. Potrebujes rezavy klic.");
            return;
        }

        if (cil.equals("skryta cela") && !stav.isPacidloPouzito()) {
            System.out.println("Dvere jsou zablokovane. Potrebujes pacidlo.");
            return;
        }

        if (cil.equals("hlavni brana")) {
            if (!stav.isBarieraDeaktivovana() && !stav.isPacidloPouzito()) {
                System.out.println("Cesta je blokovana barierou a dvere jsou zablokovane.");
                System.out.println("Potrebujes magicky krystal a pacidlo.");
                return;
            }
            if (!stav.isBarieraDeaktivovana()) {
                System.out.println("Cesta je blokovana magickou barierou. Pouzij magicky krystal.");
                return;
            }
            if (!stav.isPacidloPouzito()) {
                System.out.println("Dvere k brane jsou zablokovane. Potrebujes pacidlo.");
                return;
            }
        }

        Mistnost pred = hra.getHrac().getAktualniMistnost();
        hra.getHrac().pohniSe(parametr);
        if (pred == hra.getHrac().getAktualniMistnost()) {
            System.out.println("Tam se odsud jit neda.");
        } else {
            hra.vypisMisto();
        }
    }

    @Override
    public String getNazev () {
        return "jdi";
    }

    @Override
    public String getPopis () {
        return "Pohyb do mistnosti: jdi<nazev>";
    }
}
