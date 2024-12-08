package ar.edu.utn.frba.dds.whatsappTest;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Mensaje;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.TipoDeMedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.whatsapp.WhatsAppAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.mail.MessagingException;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class WhatsAppAdapterTest {
  /*
  @Mock
  private WhatsAppAdapter whatsappAdapter;

  @InjectMocks
  private PersonaHumana destinatario;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);

    MedioDeContacto medioDeContactoWhatsApp = new MedioDeContacto(TipoDeMedioDeContacto.WHATSAPP, "mockPhoneNumber");
    destinatario.aniadirMedioDeContacto(medioDeContactoWhatsApp);
  }

  @Test
  public void testEnviarMensaje() throws MessagingException {
    Mensaje mensaje = new Mensaje();
    mensaje.setAsunto("Asunto del mensaje de prueba");
    mensaje.setMensaje("Este es un mensaje de prueba desde el bot de WhatsApp");

    doNothing().when(whatsappAdapter).enviarMensaje(mensaje, destinatario);

    whatsappAdapter.enviarMensaje(mensaje, destinatario);

    verify(whatsappAdapter).enviarMensaje(mensaje, destinatario);
    System.out.println("El método enviarMensaje fue enviado correctamente.");
  }

   */
}
