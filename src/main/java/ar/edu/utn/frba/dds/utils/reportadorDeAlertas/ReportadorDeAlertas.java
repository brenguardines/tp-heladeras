package ar.edu.utn.frba.dds.utils.reportadorDeAlertas;

import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.incidentes.Alerta;
import ar.edu.utn.frba.dds.utils.Factories.AlertaFactory;

import javax.mail.MessagingException;

public class ReportadorDeAlertas {
    public static void reportarAlerta(String tipoAlerta, Heladera heladera)  throws MessagingException {
        Alerta incidente = AlertaFactory.createIncidentePorAlerta(tipoAlerta, heladera);
        heladera.agregarIncidente(incidente);
        Alerta.notificarTecnico(incidente);
    }
}
