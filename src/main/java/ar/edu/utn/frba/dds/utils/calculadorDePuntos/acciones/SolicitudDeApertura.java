package ar.edu.utn.frba.dds.utils.calculadorDePuntos.acciones;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.tarjeta.TarjetaColaborador;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "solicitudDeApertura")
public class SolicitudDeApertura extends Persistente {

    @Column(name="descripcion")
    private String descripcion;

    @Column(name = "tiempoParaEjecucion")
    private Integer tiempoParaEjecucion; // A revisar porque asi podria ser para cada solicitud distinto tiempo

    @Column(name = "horaDeRegistro", columnDefinition = "DATETIME")
    private LocalDateTime horaDeRegistro;

    @ManyToOne
    @JoinColumn(name = "tarjetaColaborador_id")
    private TarjetaColaborador tarjeta;

    @ManyToOne
    @JoinColumn(name = "heladera_id")
    private Heladera heladera;

    public SolicitudDeApertura(String descripcion, TarjetaColaborador tarjeta, Heladera heladera) {
        this.descripcion = descripcion;
        this.tarjeta = tarjeta;
        this.horaDeRegistro = LocalDateTime.now();
        this.heladera = heladera;
    }

    public SolicitudDeApertura() {
    }
}
