package ar.edu.utn.frba.dds.models.entities.heladera.utilidades;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "movimientoDeViandas")
@Getter
public class MovimientoDeViandas extends Persistente {
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha", columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;

    @Column(name = "cantidadDeViandasARetirar", columnDefinition = "INTEGER(3)")
    private Integer cantidadDeViandasARetirar;

    @Column(name = "cantidadDeViandasAIngresar", columnDefinition = "INTEGER(3)")
    private Integer cantidadDeViandasAIngresar;

    public MovimientoDeViandas(String descripcion, Integer cantidadDeViandasARetirar, Integer cantidadDeViandasAIngresar) {
        this.descripcion = descripcion;
        this.cantidadDeViandasARetirar = cantidadDeViandasARetirar;
        this.cantidadDeViandasAIngresar = cantidadDeViandasAIngresar;
        this.fecha = LocalDateTime.now();
    }

    public MovimientoDeViandas() {

    }

    public boolean fechaEntre(LocalDateTime inicio, LocalDateTime fin) {
        return this.fecha.isAfter(inicio) && this.fecha.isBefore(fin);
    }
}
