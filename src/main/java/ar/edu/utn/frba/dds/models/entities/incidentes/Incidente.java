package ar.edu.utn.frba.dds.models.entities.incidentes;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.heladera.EstadoHeladera;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
@Getter
@Setter
public class Incidente extends Persistente { // TODO Hay que chequear, lo puse para que no me de error la tabla en FallaTecnicaFactory
  //private List<Incidente> incidentes;
  //private List<VisitaTecnico> visitas;

  @Column(name = "descripcion", columnDefinition = "TEXT")
  private String descripcion;

  @Column(name = "fechaHoraDelIncidente", columnDefinition = "TIMESTAMP")
  private LocalDateTime fechaHora;

  @ManyToOne
  @JoinColumn(name = "heladera_id")
  private Heladera heladera;
  //private Alerta alerta; // si el incidiente fue provocado por una alerta, si fue por el reporte de una falla técnica, este atributo es NULL
  //private FallaTecnicaFactory fallaTecnica;

  public Incidente(String descripcion, Heladera heladera) {
    this.descripcion = descripcion;
    this.heladera = heladera;
    this.heladera.setEstado(EstadoHeladera.NoActiva);
    //incidentes.add(this);
  }

  public Incidente() {
  }

  public String mensajeDeAlerta() {
    return "Ocurrio un Incidente: \n Descripcion:" + this.descripcion
            + "\n Heladera: " + this.heladera.getNombre()
            + "\n Direccion:" + this.heladera.getDireccion()
            + "\n Fecha: " + this.fechaHora + ".";
  }

  public void solucionar() {
    this.heladera.setEstado(EstadoHeladera.Activa);
  }
}