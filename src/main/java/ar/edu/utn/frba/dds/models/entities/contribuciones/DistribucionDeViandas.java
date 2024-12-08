package ar.edu.utn.frba.dds.models.entities.contribuciones;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "distribucionDeViandas")
@AllArgsConstructor
@Builder
public class DistribucionDeViandas extends Persistente {
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaHumana_id")
    private PersonaHumana colaborador;

    @Column(name = "fecha", columnDefinition = "DATE")
    private LocalDate fechaDeColaboracion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "heladeraOrigen_id", referencedColumnName = "id")
    private Heladera heladeraDeOrigen;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "heladeraDestino_id", referencedColumnName = "id")
    private Heladera heladeraDeDestino;

    @Column(name = "cantidadDeViandas", columnDefinition = "Integer")
    private Integer cantidadDeViandasAMover;

    @Enumerated(EnumType.STRING)
    @Column(name = "motivoDistribucion")
    private MotivoDeLaDistribucion motivoDeLaDistribucion;

    public DistribucionDeViandas() {
    }

    public DistribucionDeViandas of(PersonaHumana colaborador) {
        DistribucionDeViandas donacion=new DistribucionDeViandas();
        donacion.setColaborador(colaborador);
        return donacion;
    }

    public boolean fechaEntre(LocalDateTime inicio, LocalDateTime fin) {
        return this.fechaDeColaboracion.isAfter(inicio.toLocalDate()) && this.fechaDeColaboracion.isBefore(fin.toLocalDate());
    }

    public static DistribucionDeViandas of(PersonaHumana personaHumana, Integer cantidad, LocalDate fecha){
        DistribucionDeViandas donacion = new DistribucionDeViandas();
        donacion.setColaborador(personaHumana);
        donacion.setCantidadDeViandasAMover(cantidad);
        donacion.setFechaDeColaboracion(fecha);
        return donacion;
    }
}