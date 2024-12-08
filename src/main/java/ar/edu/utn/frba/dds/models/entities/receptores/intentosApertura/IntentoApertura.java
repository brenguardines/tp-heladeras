package ar.edu.utn.frba.dds.models.entities.receptores.intentosApertura;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "IntentoApertura")
@Getter
public class IntentoApertura extends Persistente { // TODO FALTA TERMINAR
    @Column(name = "idHeladera", columnDefinition = "LONG")
    Long idHeladera;

    @Column(name = "fechaHoraAlta", columnDefinition = "TIMESTAMP")
    LocalDateTime fechaHoraAlta;

    @Column(name = "fechaHoraEjecucion", columnDefinition = "TIMESTAMP")
    LocalDateTime fechaHoraEjecucion;

    @Enumerated(EnumType.STRING)
    MotivoPermiso motivo;

    @Column(name = "idTarjeta",columnDefinition = "INTEGER(11)")
    Integer idTarjeta;

    @Column(name = "cantidad", columnDefinition = "INTEGER")
    Integer cantidad;

    @Column(name = "estado", columnDefinition = "TINYINT(1)")
    Boolean estado;
}
