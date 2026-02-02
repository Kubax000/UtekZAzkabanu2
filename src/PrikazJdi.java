public class PrikazJdi implements Prikaz{
    @Override
    public void vykonej(Hra hra, String parametr) {
        if (parametr.isEmpty()) {
            System.out.println("Pouziti: jdi <nazev mistnosti>");
            return;
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
    public String getNazev() {
        return "jdi";
    }

    @Override
    public String getPopis() {
        return "Pohyb do mistnosti: jdi<nazev>";
    }
}
