package ar.edu.utn.frba.dds.models.entities.beneficio;

import ar.edu.utn.frba.dds.models.entities.rubro.Rubro;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Embeddable
public class Beneficio {
    @Column(name = "nombreBeneficio", columnDefinition = "VARCHAR(55)")
    private String nombre;
    @Column(name = "descripcionBeneficio", columnDefinition = "TEXT")
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private TipoDeBeneficio tipoDeBeneficio;
    @Embedded
    private Rubro rubro;
}
