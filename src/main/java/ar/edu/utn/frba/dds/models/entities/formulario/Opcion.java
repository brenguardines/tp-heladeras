package ar.edu.utn.frba.dds.models.entities.formulario;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "opcion")
public class Opcion extends Persistente {
    @Column(name = "valor")
    private String valor;

    @Column(name = "esCorrecta", columnDefinition = "TINYINT(1)")
    private Boolean esCorrecta;
}
