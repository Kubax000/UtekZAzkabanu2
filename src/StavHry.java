/**
 * Trida, ktera udrzuje info o tom, jestli je hra dohrana
 */
public class StavHry {
    private boolean vyhra = false;

    /**
     * @return true pokud je hra vyhrana, jinak false
     */
    public boolean jeVyhra(){
        return vyhra;
    }

    public void nastavVyhru(){
        vyhra = true;
    }



}
