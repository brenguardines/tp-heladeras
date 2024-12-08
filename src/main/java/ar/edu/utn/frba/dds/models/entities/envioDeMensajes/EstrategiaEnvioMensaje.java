package ar.edu.utn.frba.dds.models.entities.envioDeMensajes;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Mensaje;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;

import javax.mail.MessagingException;
import java.util.List;

public interface EstrategiaEnvioMensaje {
    void enviarMensaje(Mensaje mensaje, PersonaHumana destinatario) throws MessagingException;
}
