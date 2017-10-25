package atletismo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AtletaService {

    @Autowired
    private AtletaRepository atletaRepository;

    @Autowired
    private MedallasRepository medallasRepository;

    public void testAtleta(){

  Atleta angelo = new Atleta(
               "Angelo", "Danan","FIlipino", LocalDate.of(1987,1,22));
      atletaRepository.saveAndFlush(angelo);



    }

}
