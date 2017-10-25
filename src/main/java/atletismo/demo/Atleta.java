package atletismo.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Atleta {
   @Id
   @GeneratedValue
    private Long id;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    @JsonIgnore
    private LocalDate fechaNacimiento;
    @JsonIgnore
    @OneToMany(mappedBy = "atleta")
    private Set<Medallas> medallas = new HashSet<>();

    public Atleta(){

    }

    public Atleta(String nombre, String apellidos, String nacionalidad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Set<Medallas> getMedallas() {
        return medallas;
    }

    public void setMedallas(Set<Medallas> medallas) {
        this.medallas = medallas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atleta atleta = (Atleta) o;

        if (!id.equals(atleta.id)) return false;
        if (!nombre.equals(atleta.nombre)) return false;
        if (!apellidos.equals(atleta.apellidos)) return false;
        if (!nacionalidad.equals(atleta.nacionalidad)) return false;
        return fechaNacimiento.equals(atleta.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nombre.hashCode();
        result = 31 * result + apellidos.hashCode();
        result = 31 * result + nacionalidad.hashCode();
        result = 31 * result + fechaNacimiento.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
