package atletismo.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {


    List<Atleta> findByNacionalidad(String nacionalidad);

    List<Atleta> findByFechaNacimientoBefore(LocalDate fechaNacimiento);

    Atleta findByNombreIs(String nombre);


}
