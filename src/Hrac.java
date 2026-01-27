public class Hrac {

    private Mistnost aktualniMistnost;

    public Hrac(Mistnost startovniMistnost){
        this.aktualniMistnost = startovniMistnost;
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
        return null;
    }

}
