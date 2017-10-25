package atletismo.demo;

import javax.persistence.*;

@Entity
public class Medallas {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private Tipomedalla tipomedalla;
    private String especialidad;
    private String competicion;

    @ManyToOne
    private Atleta atleta;

    public Medallas(){

    }

    public Medallas(Tipomedalla tipomedalla, String especialidad, String competicion) {
        this.tipomedalla = tipomedalla;
        this.especialidad = especialidad;
        this.competicion = competicion;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipomedalla getTipomedalla() {
        return tipomedalla;
    }

    public void setTipomedalla(Tipomedalla tipomedalla) {
        this.tipomedalla = tipomedalla;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medallas medallas = (Medallas) o;

        if (!id.equals(medallas.id)) return false;
        if (tipomedalla != medallas.tipomedalla) return false;
        if (!especialidad.equals(medallas.especialidad)) return false;
        if (!competicion.equals(medallas.competicion)) return false;
        return atleta.equals(medallas.atleta);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + tipomedalla.hashCode();
        result = 31 * result + especialidad.hashCode();
        result = 31 * result + competicion.hashCode();
        result = 31 * result + atleta.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Medallas{" +
                "id=" + id +
                ", tipomedalla=" + tipomedalla +
                ", especialidad='" + especialidad + '\'' +
                ", competicion='" + competicion + '\'' +
                ", atleta=" + atleta +
                '}';
    }
}
