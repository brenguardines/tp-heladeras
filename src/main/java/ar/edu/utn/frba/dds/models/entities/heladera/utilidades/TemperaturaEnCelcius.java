package ar.edu.utn.frba.dds.models.entities.heladera.utilidades;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.awt.event.PaintEvent;
import java.time.LocalDateTime;

@Entity
@Table(name = "temperaturaEnCelcius")
@Getter
public class TemperaturaEnCelcius extends Persistente {

    @Column(name = "valor", columnDefinition = "FLOAT")
    private Double valor;

    @Column(name = "fecha", columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;


    public TemperaturaEnCelcius(Double valor, LocalDateTime fecha) {
        this.valor = valor;
        this.fecha = fecha.now();
    }

    public TemperaturaEnCelcius() {

    }
}
