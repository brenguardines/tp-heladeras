package ar.edu.utn.frba.dds.models.entities.envioDeMensajes.whatsapp;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Mensaje;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.TipoDeMedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.EstrategiaEnvioMensaje;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.mail.MessagingException;

public class WhatsAppAdapter implements EstrategiaEnvioMensaje {
  private String accountSid;
  private String authToken;
  private String fromPhoneNumber;

  public WhatsAppAdapter(String accountSid, String authToken, String fromPhoneNumber) {
    this.accountSid = accountSid;
    this.authToken = authToken;
    this.fromPhoneNumber = fromPhoneNumber;
    Twilio.init(accountSid, authToken);
  }

  @Override
  public void enviarMensaje(Mensaje mensaje, PersonaHumana destinatario) throws MessagingException {
    String toPhoneNumber = destinatario.obtenerMedioDeContactoPorTipo(TipoDeMedioDeContacto.WHATSAPP).getContacto();
    try {
      String fullMessage = mensaje.getAsunto() + "\n" + mensaje.getMensaje();
      Message twilioMessage = Message.creator(
              new PhoneNumber("whatsapp:" + toPhoneNumber),
              new PhoneNumber("whatsapp:" + fromPhoneNumber),
              fullMessage)
          .create();
      System.out.println("Mensaje enviado: " + twilioMessage.getSid());
    } catch (Exception e) {
      throw new MessagingException("Error al enviar mensaje por WhatsApp", e);
    }
  }
}
