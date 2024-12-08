package ar.edu.utn.frba.dds.models.entities.envioDeMensajes.telegram;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Mensaje;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.TipoDeMedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.EstrategiaEnvioMensaje;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.mail.MessagingException;

public class TelegramAdapter extends TelegramLongPollingBot implements EstrategiaEnvioMensaje {

  private String botUsername;
  private String botToken;

  public TelegramAdapter(String botUsername, String botToken) {
    this.botUsername = botUsername;
    this.botToken = botToken;
  }

  @Override
  public String getBotUsername() {
    return botUsername;
  }

  @Override
  public String getBotToken() {
    return botToken;
  }

  @Override
  public void enviarMensaje(Mensaje mensaje, PersonaHumana destinatario) throws MessagingException {
    MedioDeContacto medioDeContacto = destinatario.obtenerMedioDeContactoPorTipo(TipoDeMedioDeContacto.TELEGRAM);
    if (medioDeContacto == null) {
      throw new MessagingException("El destinatario no tiene un medio de contacto de tipo Telegram.");
    }

    String telegramUsername = medioDeContacto.getContacto();

    SendMessage sendMessage = new SendMessage();
    sendMessage.setChatId(telegramUsername);
    sendMessage.setText(mensaje.getMensaje());

    try {
      execute(sendMessage);
    } catch (TelegramApiException e) {
      throw new MessagingException("Error al enviar mensaje por Telegram", e);
    }
  }

  @Override
  public void onUpdateReceived(Update update) {
    //No se realiza implementacion ya que voy a enviar mensajes, pero si lo tengo que tener
  }

  public static void main(String[] args) throws TelegramApiException {
    TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
    try {
      botsApi.registerBot(new TelegramAdapter("comunicacion-telegram-dds", "7465604497:AAF_Biy-lrSICAuUpM6evs2Ih9X92YgHkyg"));
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }
}


