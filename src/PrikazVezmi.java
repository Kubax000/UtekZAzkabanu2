public class PrikazVezmi implements Prikaz {
    @Override
    public void vykonej(Hra hra, String parametr) {
        if (parametr.isEmpty()) {
            System.out.println("Pouziti: vezmi <predmet>");
            return;
        }

        Mistnost m = hra.getHrac().getAktualniMistnost();
        Predmet p = m.najdiPredmet(parametr);

        if (p == null) {
            System.out.println("Takovy predmet tu neni.");
            return;
        }

        if (!p.isPrenosny()) {
            System.out.println("Tohle nejde sebrat.");
            return;
        }

        boolean ok = hra.getHrac().getInventar().pridejPredmet(p);
        if (!ok) {
            System.out.println("Inventar je plny.");
            return;
        }

        m.odeberPredmet(parametr);
        System.out.println("Sebral si: " + p.getNazev());
    }

    @Override
    public String getNazev() {
        return "vezmi";
    }

    @Override
    public String getPopis() {
        return "Sebere predmet: vezmi <nazev>";
    }
}
