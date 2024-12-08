package ar.edu.utn.frba.dds.models.entities.envioDeMensajes.email;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Mensaje;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.EstrategiaEnvioMensaje;
import ar.edu.utn.frba.dds.models.entities.tecnico.Tecnico;

import javax.mail.MessagingException;
import java.util.List;

public class EnvioEmail implements EstrategiaEnvioMensaje {
    AdapterConcretoEmail adapter = new AdapterConcretoEmail();

    @Override
    public void enviarMensaje(Mensaje mensaje, PersonaHumana destinatario) throws MessagingException {
        this.adapter.enviarMensaje(mensaje,destinatario);
    }

    public void enviarMensajeTecnico(Mensaje mensaje, Tecnico destinatario) throws MessagingException {
        this.adapter.enviarMensajeTecnico(mensaje, destinatario);
    }
    public void enviarMensajes(Mensaje mensaje, List<PersonaHumana> destinatarios) throws MessagingException {
        this.adapter.enviarMensajes(mensaje, destinatarios);
    }
}
