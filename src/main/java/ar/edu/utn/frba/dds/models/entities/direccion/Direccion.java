package ar.edu.utn.frba.dds.models.entities.direccion;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="direccion")
@AllArgsConstructor
@Builder
public class Direccion extends Persistente {

    @Setter
    @Column(name="calle")
    @Embedded
    private Calle calle;

    @Column(name = "altura")
    @Setter
    private String altura;

    @Column(name = "codigoPostal")
    @Getter
    private String codigoPostal;

    public static Direccion of(Calle calle, String altura, String codigoPostal) {
       return Direccion.builder()
               .calle(calle)
               .altura(altura)
               .codigoPostal(codigoPostal)
               .build();

    }

    public Direccion() {

    }

    public String direccionCompleta() {
        return calle + " " + altura;
    }

}
