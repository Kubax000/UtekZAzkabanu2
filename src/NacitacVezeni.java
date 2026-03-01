import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;
import java.util.Map;

/**
 * trida ktera se stara o nacteni mapy a objektu z JSON souboru
 */
public class NacitacVezeni {
    /**
     * Nacte a sestavi celou herni mapu
     * @param cesta Cesta k JSON souboru na disku
     * @return Kompletne sestaveny objekt vezeni
     * @throws Exception Pokud se soubor nenacte
     * @author Jakub Eliasek
     */
    public Vezeni nactiZJson(Path cesta) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        NastaveniVezeni cfg = mapper.readValue(cesta.toFile(), NastaveniVezeni.class);

        Vezeni vezeni = new Vezeni();

        for (NastaveniMistnosti nm : cfg.getMistnosti()) {
            Mistnost m = new Mistnost(nm.getId(), nm.getNazev(), nm.getPopis(), nm.getNapoveda());
            vezeni.pridejMistnost(m);
        }


        for (NastaveniMistnosti nm : cfg.getMistnosti()) {
            Mistnost zdroj = vezeni.najdiMistnost(nm.getId());

            if (nm.getVychody() == null) continue;

            for (Map.Entry<String, String> e : nm.getVychody().entrySet()) {
                String cilId = e.getValue();
                Mistnost cil = vezeni.najdiMistnost(cilId);
                zdroj.pridejSouseda(cil);
            }
        }

        for (NastaveniMistnosti nm : cfg.getMistnosti()) {
            Mistnost m = vezeni.najdiMistnost(nm.getId());

            if (nm.getPredmety() != null) {
                for (NastaveniPredmetu np : nm.getPredmety()) {
                    m.pridejPredmet(new Predmet(np.getNazev(), np.getPopis(), np.isPrenosny()));
                }
            }

            if (nm.getPostavy() != null) {
                for (NastaveniPostavy npo : nm.getPostavy()) {
                    m.pridejPostavu(new Postava(npo.getJmeno(), npo.getPopis(), npo.getDialog()));
                }
            }
        }

        vezeni.setStartovniMistnost(vezeni.najdiMistnost(cfg.getStart()));
        return vezeni;
    }
}
