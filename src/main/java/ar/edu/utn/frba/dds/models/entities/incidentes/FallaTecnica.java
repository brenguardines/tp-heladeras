package ar.edu.utn.frba.dds.models.entities.incidentes;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.tecnico.Tecnico;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@DiscriminatorValue("fallaTecnica")
public class FallaTecnica extends Incidente {
  @Setter
  @Getter
  @OneToOne
  @JoinColumn(name = "personaHumana_id", referencedColumnName = "id")
  private PersonaHumana personaHumana;

  @Setter
  @Getter
  @Column(name = "foto", columnDefinition = "VARCHAR(255)")
  private String foto;

  public FallaTecnica(String descripcion, Heladera heladera, PersonaHumana personaHumana, String foto) {
    super(descripcion, heladera);
    this.personaHumana = personaHumana;
    this.foto = foto;
    this.notificarTecnico(this);
  }

  public FallaTecnica() { }

  private void notificarTecnico(Incidente incidente) {
    Tecnico tecnico = encontrarTecnicoMasCercano(incidente.getHeladera());
    System.out.println("Notificando al técnico: " + tecnico.getNombreYApellido() + " - Detalles: " + incidente.getDescripcion());
  }

  private Tecnico encontrarTecnicoMasCercano(Heladera heladera) {
    return new Tecnico();
  }

  public boolean fechaEntre(LocalDateTime inicio, LocalDateTime fin) {
    return getFechaHora().isAfter(inicio) && getFechaHora().isBefore(fin);
  }

}
