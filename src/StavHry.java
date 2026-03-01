/**
 * Trida, ktera udrzuje info o tom, jestli je hra dohrana
 * @author Jakub Eliasek
 */
public class StavHry {
    private boolean vyhra = false;
    private boolean barieraDeaktivovana = false;
    private boolean pacidloPouzito = false;
    private boolean spravcePomohl = false;

    public boolean jeVyhra() {
        return vyhra;
    }
    public void nastavVyhru() {
        vyhra = true;
    }

    /**
     * Hlida stav bariery
     * @return true, pokud je bariera deaktivovana
     */
    public boolean isBarieraDeaktivovana() {
        return barieraDeaktivovana;
    }

    /**
     * Deaktivuje barieru
     */
    public void deaktivujBarieru() {
        barieraDeaktivovana = true;
    }

    /**
     * Hlida pouziti pacidla
     * @return true pokud bylo pacidlo pouzito
     */
    public boolean isPacidloPouzito() {
        return pacidloPouzito;
    }

    /**
     * Oznaci pacidlo jako pouzite
     */
    public void pouzijPacidlo() {
        pacidloPouzito = true;
    }

    /**
     * hlida jestli hrac mluvil se spravcem
     * @return true pokud hrac mluvil se spravcem magie
     */
    public boolean isSpravcePomohl() {
        return spravcePomohl;
    }

    /**
     * Oznaci ze spravce magie hrace poucil
     */
    public void nastavSpravcePomohl() {
        spravcePomohl = true;
    }
}
