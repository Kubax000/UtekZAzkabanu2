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
