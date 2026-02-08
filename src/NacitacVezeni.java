import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;
import java.util.Map;

public class NacitacVezeni {
    public Vezeni nactiZJson(Path cesta) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        NastaveniVezeni cfg = mapper.readValue(cesta.toFile(), NastaveniVezeni.class);

        Vezeni vezeni = new Vezeni();

        for (NastaveniMistnosti nm : cfg.getMistnosti()) {
            Mistnost m = new Mistnost(nm.getId(), nm.getNazev(), nm.getPopis());
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

        vezeni.setStartovniMistnost(vezeni.najdiMistnost(cfg.getStart()));

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
