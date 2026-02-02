public class PrikazProzkoumej implements Prikaz {
    @Override
    public void vykonej(Hra hra, String parametr) {
        hra.vypisMisto();
    }

    @Override
    public String getNazev() {
        return "prozkoumej";
    }

    @Override
    public String getPopis() {
        return "Vypise informace o aktualni mistnosti";
    }
}
