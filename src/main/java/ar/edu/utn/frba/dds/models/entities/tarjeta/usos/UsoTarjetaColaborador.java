package ar.edu.utn.frba.dds.models.entities.tarjeta.usos;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.utils.calculadorDePuntos.acciones.SolicitudDeApertura;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usoTarjetaColaborador")
@Getter
public class UsoTarjetaColaborador extends Persistente {
    @Column(name = "fechaUso", columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;

    @OneToOne
    @JoinColumn(name = "heladera_id", referencedColumnName = "id")
    private Heladera heladera;

    @OneToOne
    @JoinColumn(name = "solicitudApertura_id", referencedColumnName = "id")
    private SolicitudDeApertura solicitud;

    public UsoTarjetaColaborador(Heladera heladera, SolicitudDeApertura solicitud) {
        this.heladera = heladera;
        this.solicitud = solicitud;
        this.fecha = LocalDateTime.now();
    }

    public UsoTarjetaColaborador() {

    }
}
