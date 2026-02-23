/**
 * Trida reprezentujici hrace, jeho polohu a inventar.
 * @author Jakub Eliasek
 */
public class Hrac {

    private Mistnost aktualniMistnost;
    private final Inventar inventar = new Inventar(3);

    /**
     * Konstruktor pro vytvoreni hrace na zacatku hry
     * @param startovniMistnost Mistnost, ve ktere hrac zacina.
     */
    public Hrac(Mistnost startovniMistnost){
        this.aktualniMistnost = startovniMistnost;
    }

    /**
     * Vrati mistnost, ve ktere je aktualne hrac.
     * @return Aktualni mistnost
     */
    public Mistnost getAktualniMistnost(){
        return aktualniMistnost;
    }

    /**
     * Zkusi presunout hrace do sousedni mistnosti podle nazvu,
     * pokud mistnost existuje hrac se tam presune
     * @param nazevMistnosti Nazev mistnosti kam chce hrac jit
     */
    public void pohniSe(String nazevMistnosti){
        Mistnost cil = aktualniMistnost.dejSouseda(nazevMistnosti);
        if (cil != null){
            aktualniMistnost = cil;
        }
    }

    /**
     * Vrati hracuv inventar
     * @return Inventar hrace
     */
    public Inventar getInventar(){
        return inventar;
    }

}
