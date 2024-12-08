package ar.edu.utn.frba.dds.models.entities.contribuciones;


import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.oferta.Oferta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donacionOferta")
@Getter
@Setter
public class DonacionDeOferta extends Persistente {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaJuridica_id")
    private PersonaJuridica colaborador;

    @Column(name = "fechaDeColaboracion", columnDefinition = "DATE")
    private LocalDate fechaDeColaboracion;

    @OneToOne
    @JoinColumn(name = "oferta_id", referencedColumnName = "id")
    private Oferta oferta;

    public DonacionDeOferta(PersonaJuridica colaborador, Oferta oferta) {
        this.colaborador = colaborador;
        this.oferta = oferta;
    }

    public DonacionDeOferta() {

    }
}