
public interface Prikaz {

    /**
     * Spolecne rozhrani pro vsechny herni prikazy, definuje, co musi kazdy prikaz umet
     * @param hra aktualni hra, aby  prikaz mohl pracovat s hracem, vezenim, atd.
     * @param parametr zbytek vstupu, napr. nazev mistnosti/predmetu
     * @author Jakub Eliasek
     */
    void vykonej(Hra hra, String parametr);

    String getNazev();

    String getPopis();

}
