/**
 * Implemetace prikazu napoveda. Vypise napovedu pro danou mistnost.
 * @author Jakub Eliasek
 */
public class PrikazNapoveda implements Prikaz {

    @Override
    public void vykonej(Hra hra, String parametr) {
        Mistnost m = hra.getHrac().getAktualniMistnost();
        String rada = m.getNapoveda();

        if (rada != null && !rada.isEmpty()) {
            System.out.println("Nápověda: " + rada);
        } else {
            System.out.println("Tady ti asi nic nepomůže. Zkus se jen rozhlédnout (příkaz 'prozkoumej').");
        }
    }

    @Override
    public String getNazev() {
        return "napoveda";
    }

    @Override
    public String getPopis() {
        return "Poskytne radu pro aktuální místnost.";
    }
}

