package ar.edu.utn.frba.dds.models.entities.contribuciones;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "hacerseCargoDeHeladera")
@Entity
@Setter
@Getter
public class HacerseCargoDeUnaHeladera extends Persistente {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaJuridica_id")
    private PersonaJuridica colaborador;

    @Column(name = "fechaDeColaboracion", columnDefinition = "DATE")
    private LocalDate fechaDeColaboracion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "heladera_id", referencedColumnName = "id")
    private Heladera heladera;

    public HacerseCargoDeUnaHeladera(PersonaJuridica colaborador, Heladera heladera) {
        this.colaborador = colaborador;
        this.fechaDeColaboracion = LocalDate.now();
        this.heladera = heladera;
    }

    public HacerseCargoDeUnaHeladera() {
    }
}