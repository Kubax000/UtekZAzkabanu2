public class PrikazInventar implements Prikaz {

    @Override
    public void vykonej(Hra hra, String parametr) {
        hra.getHrac().getInventar().vypisInventar();
    }

    @Override
    public String getNazev() {
        return "inventar";
    }

    @Override
    public String getPopis() {
        return "Vypise inventar";
    }
}
