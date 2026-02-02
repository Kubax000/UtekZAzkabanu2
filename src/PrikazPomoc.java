public class PrikazPomoc implements Prikaz{
    @Override
    public void vykonej(Hra hra, String parametr) {
        hra.getPrikazy().vypisPomoc();
    }

    @Override
    public String getNazev() {
        return "pomoc";
    }

    @Override
    public String getPopis() {
        return "Vypise seznam prikazu";
    }
}
