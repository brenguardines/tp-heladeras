package ar.edu.utn.frba.dds.models.entities.vianda;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "vianda")
public class Vianda extends Persistente {
    @Embedded
    @Column(name = "comida")
    private Comida comida;
    @Column(name = "fechaDeCaducidad", columnDefinition = "DATE")
    private LocalDateTime fechaDeCaducidad;

    @Column(name ="fechaDeDonacion", columnDefinition = "DATE")
    private LocalDateTime fechaDeDonacion;

    @ManyToOne
    @JoinColumn(name = "heladera_id")
    private Heladera heladeraEnLaQueSeEncuentra;

    @Column(name = "calorias", columnDefinition = "INT")
    private Integer calorias;

    @Column(name = "peso", columnDefinition = "INT")
    private Integer peso;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;
}
