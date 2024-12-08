package ar.edu.utn.frba.dds.models.entities.direccion;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Setter
@Embeddable
public class Calle {
    private String calle;

    public Calle(String calle){
        this.calle = calle;
    }

    public Calle() {

    }
}
