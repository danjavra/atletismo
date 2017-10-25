package atletismo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import static java.util.stream.Collectors.groupingBy;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/atleta")
public class ControllerAtletismo {

    @Autowired
    private AtletaRepository atletaRepository;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Atleta createAtleta(@RequestBody Atleta atleta) {return atletaRepository.save(atleta);}

    @PutMapping
    public Atleta updateAtleta(@RequestBody Atleta atleta) {return atletaRepository.save(atleta);}

    @GetMapping("/lista")
    public List<Atleta>findAll(){ return atletaRepository.findAll();}

    @GetMapping("/Nacionalidad/{nacionalidad}")
    public List<Atleta> findbyNacionalidad(@PathVariable String nacionalidad){ return atletaRepository.findByNacionalidad(nacionalidad);}

    @GetMapping("/fechaAnterior/{fechaNacimiento}")
    public List<Atleta>findbyFechaNacimientoBefore(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaNacimiento){
        return atletaRepository.findByFechaNacimientoBefore(fechaNacimiento);
    }

    @GetMapping("/GroupByNacionalidad")
    public Map<String, List<Atleta>> getAtletaGroupByNacionalidad(){
        return atletaRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(Atleta::getNacionalidad));
    }

    @GetMapping("/GroupByTipoMedalla")
    public Map<Tipomedalla, List<Atleta>> getAtletaGroupByTipomedalla (){
        return atletaRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(Atleta -> {
                  if(Atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipomedalla() == Tipomedalla.ORO)){
                     return Tipomedalla.ORO;
                  } else if (Atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipomedalla() == Tipomedalla.PLATA)) {
                      return Tipomedalla.PLATA;

                    }else if(Atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipomedalla() == Tipomedalla.BRONCE)){
                        return Tipomedalla.BRONCE;
                    } else{
                        return Tipomedalla.NONE;
                    }
                }));
    }

}
