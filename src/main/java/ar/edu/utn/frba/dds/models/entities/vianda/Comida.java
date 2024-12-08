package ar.edu.utn.frba.dds.models.entities.vianda;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Comida {
    private String nombre;
}
