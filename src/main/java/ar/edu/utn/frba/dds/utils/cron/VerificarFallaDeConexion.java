package ar.edu.utn.frba.dds.utils.cron;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.incidentes.Alerta;
import ar.edu.utn.frba.dds.models.entities.incidentes.Incidente;
import ar.edu.utn.frba.dds.models.entities.incidentes.TipoAlerta;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;
import ar.edu.utn.frba.dds.utils.reportadorDeAlertas.ReportadorDeAlertas;

import javax.mail.MessagingException;
import java.time.Duration;
import java.time.LocalDateTime;

// Este cronJob se ejecuta según el tiempo que se especifíque en el programador de tareas (WINDOWWS) o en el cronTab (MAC)

public class VerificarFallaDeConexion {
    static Integer intervaloLlegadaTemperaturaEnMinutos=5;

    public static void ultimaTemperaturaEstable(Heladera heladera) throws MessagingException {
        if(Duration.between(heladera.getHistorialDeTemperaturas().get(heladera.getHistorialDeTemperaturas().size()).getFecha(),
                LocalDateTime.now()).toMinutes() > intervaloLlegadaTemperaturaEnMinutos){
            ReportadorDeAlertas.reportarAlerta("FallaDeConexion", heladera);
        }
    }
    public static void analizarUltimasTemperaturas(HeladeraRepository heladeraRepository) {
        heladeraRepository.buscarTodos().forEach(heladera -> {
            try {
                VerificarFallaDeConexion.ultimaTemperaturaEstable(heladera);
            } catch (MessagingException e) {
                System.err.println("Error al verificar la temperatura: " + e.getMessage());
            }
        });
    }

    public static void main(String[] args) throws MessagingException {
        VerificarFallaDeConexion.analizarUltimasTemperaturas(HeladeraRepository.getInstance());
    }
}
