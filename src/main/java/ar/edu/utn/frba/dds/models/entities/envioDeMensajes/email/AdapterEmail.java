package ar.edu.utn.frba.dds.models.entities.envioDeMensajes.email;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Mensaje;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;

import javax.mail.MessagingException;
import java.util.List;

public interface AdapterEmail {
    void enviarMensaje(Mensaje mensaje, PersonaHumana destinatario) throws MessagingException;
    void enviarMensajes(Mensaje mensaje, List<PersonaHumana> destinatarios) throws MessagingException;
}
