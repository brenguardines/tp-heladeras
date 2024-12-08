package ar.edu.utn.frba.dds.models.entities.formulario;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;

import javax.persistence.*;

@Entity
@Table(name = "pregunta")
public class Pregunta extends Persistente {

    @Column(name = "esObligatoria", columnDefinition = "TINYINT(1)")
    private Boolean esObligatoria;

    @Enumerated(EnumType.STRING)
    private TipoPregunta tipo;

    @Column(name = "preguntaConcreta")
    private String preguntaConcreta;
}