package ar.edu.utn.frba.dds.models.entities.formulario;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;

import javax.persistence.*;
import java.util.List;

@Table(name = "respuesta")
@Entity
public class Respuesta extends Persistente {
    @OneToOne
    @JoinColumn(name = "pregunta_id", referencedColumnName = "id")
    private Pregunta pregunta;

    @OneToMany
    @JoinColumn(name = "respuesta_id")
    private List<Opcion> opciones;

}
