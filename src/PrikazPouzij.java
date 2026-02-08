public class PrikazPouzij implements Prikaz {
    @Override
    public void vykonej(Hra hra, String parametr) {
        if (parametr == null || parametr.trim().isEmpty()) {
            System.out.println("Pouziti: pouzij <predmet>");
            return;
        }

        String hledany = parametr.trim().toLowerCase();

        Predmet p = hra.getHrac().getInventar().najdiPredmet(hledany);
        if (p == null) {
            System.out.println("Ten predmet v inventari nemas.");
            return;
        }

        Mistnost m = hra.getHrac().getAktualniMistnost();
        String idMistnosti = (m.getId() == null) ? "" : m.getId().trim().toLowerCase();
        String nazevMistnosti = (m.getNazev() == null) ? "" : m.getNazev().trim().toLowerCase();

        if (hledany.equals("rezavy klic")
                && (idMistnosti.equals("hlavni_brana") || nazevMistnosti.equals("hlavni brana azkabanu"))) {
            System.out.println("Odemkl jsi branu klicem!");
            hra.nastavVyhru();
            return;
        }

        p.pouzij(hra);
    }

    @Override public String getNazev() { return "pouzij"; }
    @Override public String getPopis() { return "Pouzije predmet z inventare"; }
}

