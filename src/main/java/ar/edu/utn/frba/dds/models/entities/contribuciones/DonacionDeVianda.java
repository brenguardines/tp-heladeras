package ar.edu.utn.frba.dds.models.entities.contribuciones;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.vianda.Vianda;
import ar.edu.utn.frba.dds.utils.calculadorDePuntos.acciones.SolicitudDeApertura;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "donacionDeVianda")
public class DonacionDeVianda extends Persistente {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name= "personaHumana_id")
    private PersonaHumana colaborador;

    @Column(name = "fechaDeColaboracion", columnDefinition = "DATE")
    private LocalDate fechaDeColaboracion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="vianda_id", referencedColumnName = "id")
    private Vianda vianda;

    public DonacionDeVianda(){}

    public DonacionDeVianda (PersonaHumana colaborador, Vianda vianda) {
        this.colaborador = colaborador;
        this.vianda = vianda;
    }

    public boolean fechaEntre(LocalDateTime inicio, LocalDateTime fin) {
        return this.fechaDeColaboracion.isAfter(inicio.toLocalDate()) && this.fechaDeColaboracion.isBefore(fin.toLocalDate());
    }

    public static DonacionDeVianda of(PersonaHumana colaborador, Vianda vianda, LocalDate  fecha) {
        DonacionDeVianda donacion = new DonacionDeVianda();
        donacion.colaborador = colaborador;
        donacion.vianda = vianda;
        donacion.fechaDeColaboracion = fecha;
        return donacion;
    }
}
