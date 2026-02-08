public interface Prikaz {

    /**
     * Provede prikaz
     * @param hra aktualni hra, aby  prikaz mohl pracovat s hracem, vezenim, atd.
     * @param parametr zbytek vstupu, napr. nazev mistnosti/predmetu
     */
    void vykonej(Hra hra, String parametr);

    String getNazev();

    String getPopis();

}
