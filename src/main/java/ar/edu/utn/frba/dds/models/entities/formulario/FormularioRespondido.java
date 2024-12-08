package ar.edu.utn.frba.dds.models.entities.formulario;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="formularioRespondido")
public class FormularioRespondido extends Persistente {

    @OneToOne
    @JoinColumn(name = "formulario_id", referencedColumnName = "id")
    private Formulario formulario;

    @OneToMany
    @JoinColumn(name = "formularioRespondido_id")
    private List<Respuesta> respuestasFormulario;
}
