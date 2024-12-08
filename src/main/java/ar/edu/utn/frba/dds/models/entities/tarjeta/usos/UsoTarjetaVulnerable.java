package ar.edu.utn.frba.dds.models.entities.tarjeta.usos;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.vianda.Vianda;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usoTarjetaVulnerable")
@Getter
public class UsoTarjetaVulnerable extends Persistente {
    @Column(name = "fechaUso", columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;
    @OneToOne
    @JoinColumn(name = "heladera_id", referencedColumnName = "id")
    private Heladera heladera;

    @OneToOne
    @JoinColumn(name = "vianda_id", referencedColumnName = "id")
    private Vianda vianda;

    public UsoTarjetaVulnerable(Heladera heladera, Vianda vianda) {
        this.fecha = LocalDateTime.now();
        this.heladera = heladera;
        this.vianda = vianda;
    }

    public UsoTarjetaVulnerable() {

    }
}
