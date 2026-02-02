public class PrikazKonec implements Prikaz {
    @Override
    public void vykonej(Hra hra, String parametr) {
        hra.ukonci();
    }

    @Override
    public String getNazev() {
        return "konec";
    }

    @Override
    public String getPopis() {
        return "Ukonci hru";
    }
}
