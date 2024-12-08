package ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Setter
@Getter
@Embeddable
public class NombreYApellido {
    @Column(name = "nombre", columnDefinition = "VARCHAR(55)")
    private String nombre;
    @Column(name = "apellido", columnDefinition = "VARCHAR(55)")
    private String apellido;

    public static NombreYApellido of(String nombre, String apellido) {
        NombreYApellido nombreYApellido = new NombreYApellido();
        nombreYApellido.setApellido(apellido);
        nombreYApellido.setNombre(nombre);
        return nombreYApellido;
    }
}
