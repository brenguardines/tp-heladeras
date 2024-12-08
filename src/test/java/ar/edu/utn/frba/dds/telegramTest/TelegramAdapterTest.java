package ar.edu.utn.frba.dds.telegramTest;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Mensaje;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.TipoDeMedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.telegram.TelegramAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.mail.MessagingException;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class TelegramAdapterTest {
  /*

  @Mock
  private TelegramAdapter telegramAdapter;

  @InjectMocks
  private PersonaHumana destinatario;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    MedioDeContacto medioDeContactoTelegram = new MedioDeContacto(TipoDeMedioDeContacto.TELEGRAM, "mockChatId");
    destinatario.aniadirMedioDeContacto(medioDeContactoTelegram);
  }

  @Test
  public void testEnviarMensaje() throws MessagingException {
    Mensaje mensaje = new Mensaje("Hola", "destinatario@correo.com");
    mensaje.setMensaje("Este es un mensaje de prueba desde el bot de Telegram");

    doNothing().when(telegramAdapter).enviarMensaje(mensaje, destinatario);

    telegramAdapter.enviarMensaje(mensaje, destinatario);

    verify(telegramAdapter).enviarMensaje(mensaje, destinatario);
    System.out.println("El método enviarMensaje fue enviado correctamente.");
  }

    /*
    //Para probarlo sin mockearlo
  public static void main(String[] args) {

    TelegramAdapter telegramAdapter = new TelegramAdapter("comunicacion-telegram-dds", "7465604497:AAF_Biy-lrSICAuUpM6evs2Ih9X92YgHkyg");

    PersonaHumana destinatario = new PersonaHumana();
    MedioDeContacto medioDeContactoTelegram = new MedioDeContacto(TipoDeMedioDeContacto.TELEGRAM, "numChatId");
    destinatario.aniadirMedioDeContacto(medioDeContactoTelegram);

    Mensaje mensaje = new Mensaje();
    mensaje.setMensaje("Este es un mensaje de prueba desde el bot de Telegram");

    try {
      telegramAdapter.enviarMensaje(mensaje, destinatario);
      System.out.println("Mensaje enviado exitosamente.");
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
   */
}
