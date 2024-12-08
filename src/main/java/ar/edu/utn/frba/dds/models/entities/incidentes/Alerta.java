package ar.edu.utn.frba.dds.models.entities.incidentes;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Mensaje;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.email.AdapterConcretoEmail;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.email.EnvioEmail;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.tecnico.Tecnico;
import lombok.Getter;
import lombok.Setter;

import javax.mail.MessagingException;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@DiscriminatorValue("Alerta")
public class Alerta extends Incidente{

  @Enumerated(EnumType.STRING)
  private TipoAlerta tipoDeAlerta;

  public Alerta(String descripcion, Heladera heladera) {
    super(descripcion, heladera);
  }

  public Alerta() {
  }

  public static void notificarTecnico(Incidente incidente) throws MessagingException {
    Tecnico tecnico = encontrarTecnicoMasCercano(incidente.getHeladera());

    EnvioEmail email = new EnvioEmail();
    Mensaje mensaje = new Mensaje("Alerta de Incidente", incidente.mensajeDeAlerta());

    email.enviarMensajeTecnico(mensaje, tecnico);
    System.out.println("Notificando al técnico: " + tecnico.getNombreYApellido() + " - Detalles: " + incidente.mensajeDeAlerta());
  }

  private static Tecnico encontrarTecnicoMasCercano(Heladera heladera) {
    return new Tecnico();
  }
}

