public class Postava {

    private final String jmeno;
    private final String popis;
    private final String dialog;

    public Postava(String jmeno,String popis,String dialog){
        this.jmeno=jmeno;
        this.popis=popis;
        this.dialog=dialog;
    }

    public String getJmeno(){
        return jmeno;
    }

    public String getPopis(){
        return popis;
    }

    public void mluv(Hra hra){
        System.out.println(jmeno + ":" + dialog);
    }

}
