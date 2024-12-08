package ar.edu.utn.frba.dds.models.entities.rubro;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Rubro {
    @Column(name = "nombreRubroBeneficio", columnDefinition = "VARCHAR(55)")
    private  String nombre;
    @Column(name = "desripcionRubroDescripcion", columnDefinition = "TEXT")
    private String descripcion;

    public Rubro(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public static Rubro of(String nombre, String descripcion) {
        return new Rubro(nombre, descripcion);
    }

    public Rubro() {

    }
}
