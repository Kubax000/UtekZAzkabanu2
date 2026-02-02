public class Hrac {

    private Mistnost aktualniMistnost;
    private final Inventar inventar;

    public Hrac(Mistnost startovniMistnost){
        this.aktualniMistnost = startovniMistnost;
        this.inventar = new Inventar(3);
    }

    public Mistnost getAktualniMistnost(){
        return aktualniMistnost;
    }

    public void pohniSe(String nazevMistnosti){
        Mistnost cil = aktualniMistnost.dejSouseda(nazevMistnosti);
        if (cil != null){
            aktualniMistnost = cil;
        }
    }

    public Inventar getInventar(){
        return inventar;
    }

}
