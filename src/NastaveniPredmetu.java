public class NastaveniPredmetu {
    private String nazev;
    private String popis;
    private boolean prenosny;

    public NastaveniPredmetu() {}

    public String getNazev() {
        return nazev;
    }
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public boolean isPrenosny() {
        return prenosny;
    }

    public void setPrenosny(boolean prenosny) {
        this.prenosny = prenosny;
    }
}
