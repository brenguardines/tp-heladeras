package ar.edu.utn.frba.dds.models.entities.direccion;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Setter
@Getter
@Embeddable
public class UbicacionConRadio {
    @Embedded
    private Coordenada coordenada;

    @Column(name = "radioCoberturaEnKm", columnDefinition = "INTEGER(2)")
    private Integer radio;

    public UbicacionConRadio(Coordenada coordenada, Integer radio) {
        this.coordenada = coordenada;
        this.radio = radio;
    }

    public UbicacionConRadio() {

    }

    public String longitud() {
        return  this.coordenada.getLongitud();
    }

    public String latitud() {
        return this.coordenada.getLatitud();
    }
}
