package ar.edu.utn.frba.dds.models.entities.incidentes;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.tecnico.Tecnico;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "visitaTecnico")
public class VisitaTecnico extends Persistente {
  @Column(name = "comentario", columnDefinition = "TEXT")
  private String comentario;

  @Column(name = "foto", columnDefinition = "VARCHAR(255)")
  private String foto;

  @Column(name = "fechaVisita", columnDefinition = "DATE")
  private LocalDate fechaVisita;

  @Column(name = "solucionado", columnDefinition = "TINYINT(1)")
  private Boolean solucionado;

  @ManyToOne
  @JoinColumn(name = "tecnico_id",referencedColumnName="id")
  private Tecnico tecnico;

  @OneToOne
  @JoinColumn(name = "incidente_id")
  private Incidente incidente;


  public VisitaTecnico(String comentario, String foto, boolean solucionado, Incidente incidente) {
    this.incidente = incidente;
    this.comentario = comentario;
    this.foto = foto;
    this.solucionado = solucionado;

    if(solucionado){
      this.marcarComoResuelto();
    }
  }

  public VisitaTecnico() {

  }

  public void marcarComoResuelto() {
    this.solucionado = true;
    this.incidente.solucionar();
  }
}
