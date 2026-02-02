public class PrikazPoloz implements Prikaz {
    @Override
    public void vykonej(Hra hra, String parametr) {
        if (parametr.isEmpty()) {
            System.out.println("Pouziti: poloz <predmet>");
            return;
        }

        Predmet p = hra.getHrac().getInventar().odeberPredmet(parametr);
        if (p == null) {
            System.out.println("Ten predmet v inventari nemas.");
            return;
        }

        hra.getHrac().getAktualniMistnost().pridejPredmet(p);
        System.out.println("Polozil jsi: " + p.getNazev());
    }

    @Override
    public String getNazev() {
        return "poloz";
    }

    @Override
    public String getPopis() {
        return "Polozi predmet: poloz <nazev>";
    }
}
