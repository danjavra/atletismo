package atletismo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedallasService {

    @Autowired
    private MedallasRepository medallasRepository;
    @Autowired
    private AtletaRepository atletaRepository;

    public void testMedalla(){

        Medallas medallas = new Medallas(Tipomedalla.ORO,"salto","olympiadas");
        medallas.setAtleta(atletaRepository.findByNombreIs("Angelo"));
        medallasRepository.save(medallas);

    }


}
