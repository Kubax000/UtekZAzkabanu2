/**
 * Implementace prikazu pouzij.
 * @author Jakub Eliasek
 */
public class PrikazPouzij implements Prikaz {
    @Override
    public void vykonej(Hra hra, String parametr) {
            if (parametr == null || parametr.trim().isEmpty()) {
                System.out.println("Pouziti: pouzij <predmet>");
                return;
            }

            String hledany = parametr.trim().toLowerCase();
            Predmet p = hra.getHrac().getInventar().najdiPredmet(hledany);
            if (p == null) {
                System.out.println("Ten predmet v inventari nemas.");
                return;
            }

            Mistnost m = hra.getHrac().getAktualniMistnost();
            String idMistnosti = m.getId().trim().toLowerCase();
            StavHry stav = hra.getStav();

            if (hledany.equals("rezavy klic")) {
                if (idMistnosti.equals("sklad_predmetu")) {
                    System.out.println("Tento zamek uz je odemceny, jsi uvnitr.");
                } else {
                    System.out.println("Tady neni co otevrit rezavym klicem.");
                }
                return;
            }

            if (hledany.equals("stary svitek")) {
                System.out.println("Ctete svitek...");
                System.out.println("'Hlavni brana Azkabanu je chranena peceti strazcu.");
                System.out.println("Pecet lze ziskat az kdyz je neutralizovana magicka bariera");
                System.out.println("a otevrena skryta cela v hloubi veznice.'");
                return;
            }

        if (hledany.equals("magicky krystal")) {
            if (idMistnosti.equals("magicky_uzel")) {
                if (!stav.isSpravcePomohl()) {
                    System.out.println("Nevis jak krystal pouzit. Mozna by ti nekdo mohl poradit...");
                    return;
                }
                if (!stav.isBarieraDeaktivovana()) {
                    System.out.println("Krystal zacal zarit a magicka bariera se rozpustila!");
                    System.out.println("Cesta k peceti je volna.");
                    stav.deaktivujBarieru();
                    hra.getHrac().getInventar().odeberPredmet("magicky krystal");
                } else {
                    System.out.println("Bariera je jiz deaktivovana.");
                }
            } else {
                System.out.println("Krystal slabe zari, ale tady neni zadny magicky uzel.");
            }
            return;
        }

            if (hledany.equals("pacidlo")) {
                if (idMistnosti.equals("magicky_uzel")) {
                    if (!stav.isPacidloPouzito()) {
                        System.out.println("Pouzil jsi pacidlo na zarezavele dvere...");
                        System.out.println("S hlasitym skripenim se otevrela skryta cela!");
                        stav.pouzijPacidlo();
                        hra.getHrac().getInventar().odeberPredmet("pacidlo");
                    } else {
                        System.out.println("Dvere jsou jiz otevrene.");
                    }
                } else {
                    System.out.println("Tady neni co pacidlem otevrit.");
                }
                return;
            }

            // Hlavní pečeť – výhra
            if (hledany.equals("hlavni pecet")) {
                if (idMistnosti.equals("hlavni_brana")) {
                    System.out.println("Prikladate pecet k brane...");
                    System.out.println("Brana se pomalu otvira. Svoboda!");
                    hra.nastavVyhru();
                } else {
                    System.out.println("Pecet patri k hlavni brane, ne sem.");
                }
                return;
            }

            p.pouzij(hra);
        }

     @Override public String getNazev() {
        return "pouzij";
    }

     @Override public String getPopis() {
        return "Pouzije predmet z inventare";
    }
}


