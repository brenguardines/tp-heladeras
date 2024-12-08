package ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias;

import ar.edu.utn.frba.dds.models.usuario.Usuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class Persistente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estaActivo", columnDefinition = "TINYINT(1)")
    private Boolean estaActivo = Boolean.TRUE;

    @Column(name = "fechaAlta", columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaDeAlta = LocalDateTime.now();

    @Column(name = "fechaBaja", columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaBaja;

    @Column(name = "fechaUltimaModificacion", columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaUltimaModificacion = LocalDateTime.now();

    @Column(name = "creadoPor")
    private Long creadoPor; // es el id del usuario

    @Column(name = "eliminarPor")
    private Long eliminarPor; // es el id del usuario

    @Column(name = "editadoPor")
    private Long editadoPor; // es el id del usuario
}
