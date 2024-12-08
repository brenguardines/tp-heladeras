package ar.edu.utn.frba.dds.models.entities.direccion;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Setter
@Getter
@Embeddable
@Builder
public class Coordenada {
    @Column(name = "longuitudCoordenada", columnDefinition = "VARCHAR(30)")
    private String longitud;

    @Column(name = "latitudCoordenada", columnDefinition = "VARCHAR(30)")
    private String latitud;

    public Coordenada(String longitud, String latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Coordenada() {

    }

    @Override
    public String toString() {
        return "Coordenada { " +
            "latitud = " + latitud +
            ", longitud = " + longitud +
            '}';
    }
}
