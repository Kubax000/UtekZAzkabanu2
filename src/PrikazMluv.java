/**
 * Implementace prikazu mluv.
 * @author Jakub Eliasek
 */
public class PrikazMluv implements Prikaz {
    @Override
    public void vykonej(Hra hra, String parametr) {
        if (parametr.isEmpty()) {
            System.out.println("Pouziti: mluv <postava>");
            return;
        }

        Mistnost m = hra.getHrac().getAktualniMistnost();
        Postava p = m.najdiPostavu(parametr);

        if (p == null) {
            System.out.println("Takova postava tu neni.");
            return;
        }

        if (parametr.trim().toLowerCase().equals("straz")) {
            System.out.println(p.getJmeno() + ": " + p.getPopis());
            System.out.println("Se strazi neni mozne vest normalni rozhovor.");
            return;
        }

        if (parametr.trim().toLowerCase().equals("spravce magie")) {
            p.mluv(hra);
            hra.getStav().nastavSpravcePomohl();
            return;
        }

        p.mluv(hra);
    }

    @Override
    public String getNazev() {
        return "mluv";
    }

    @Override
    public String getPopis() {
        return "Promluvi s postavou: mluv <jmeno>";
    }
}
