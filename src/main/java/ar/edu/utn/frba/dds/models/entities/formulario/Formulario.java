package ar.edu.utn.frba.dds.models.entities.formulario;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="formulario")
public class Formulario extends Persistente {

    @OneToMany
    @JoinColumn(name = "formulario_id")
    private List<Pregunta> preguntas;

}