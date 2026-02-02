public class PrikazPouzij implements Prikaz {
    @Override
    public void vykonej(Hra hra, String parametr) {
        if (parametr.isEmpty()) {
            System.out.println("Pouziti: pouzij <predmet>");
            return;
        }

        Predmet p = hra.getHrac().getInventar().najdiPredmet(parametr);
        if (p == null) {
            System.out.println("Ten predmet v inventari nemas.");
            return;
        }

        p.pouzij(hra);
    }

    @Override
    public String getNazev() {
        return "pouzij";
    }

    @Override
    public String getPopis() {
        return "Pouzije predmet z inventare";
    }
}
