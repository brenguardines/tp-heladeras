package ar.edu.utn.frba.dds.models.entities.envioDeMensajes.email;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Mensaje;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.tecnico.Tecnico;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class AdapterConcretoEmail implements AdapterEmail {
    String host = "smtp.gmail.com";
    String port = "587";
    String mailFrom = "grupo14ddsmino@gmail.com";
    String password = "rqod mowv mrle uxrn"; // no es la contraseña real. Es una contra solo para uso de una aplicación de terceros (java)

    @Override
    public void enviarMensaje(Mensaje mensaje, PersonaHumana destinatario) throws MessagingException {
        String emailDestinatario = destinatario.getMediosDeContactos().stream().filter(c->c.getTipoDeMedioDeContacto().name().
                equals("CORREO")).toList().get(0).getContacto();
        this.sendEmail(
                host,
                port,
                mailFrom,
                password,
                emailDestinatario,
                mensaje.getAsunto(),
                mensaje.getMensaje()
        );
    }

    public void enviarMensajeTecnico(Mensaje mensaje, Tecnico destinatario) throws MessagingException {
        String emailDestinatario = destinatario.getMedioDeContacto().stream().filter(c->c.getTipoDeMedioDeContacto().name().
                equals("CORREO")).toList().get(0).getContacto();
        this.sendEmail(
                host,
                port,
                mailFrom,
                password,
                emailDestinatario,
                mensaje.getAsunto(),
                mensaje.getMensaje()
        );
    }

    @Override
    public void enviarMensajes(Mensaje mensaje, List<PersonaHumana> destinatarios) throws MessagingException {
        String email;
        for (PersonaHumana destinatario : destinatarios){
            email = destinatario.getMediosDeContactos().stream().filter(c->c.getTipoDeMedioDeContacto().name().
                    equals("CORREO")).toList().get(0).getContacto();
            this.sendEmail(
                    host,
                    port,
                    mailFrom,
                    password,
                    email,
                    mensaje.getAsunto(),
                    mensaje.getMensaje()
            );
        }
    }

    public void sendEmail(String host, String port, final String user, final String password,
                          String toAddress, String subject, String message) throws AddressException, MessagingException {
        // Configuración del servidor de correo
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host); // servidor smtp. En este caso vamos a usar "Gmail SMTP"
        properties.put("mail.smtp.port", port); // puerto del servidor. 587
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Las

        // Autenticación
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };

        // Crear sesión
        Session session = Session.getInstance(properties, auth);

        // Crear mensaje de correo
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(user));
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new java.util.Date());
        msg.setText(message);

        // Enviar el mensaje
        Transport.send(msg);
    }
}
