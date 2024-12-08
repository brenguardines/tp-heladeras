package ar.edu.utn.frba.dds.utils.Factories;

import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.incidentes.Alerta;
import ar.edu.utn.frba.dds.models.entities.incidentes.Incidente;
import ar.edu.utn.frba.dds.models.entities.incidentes.TipoAlerta;
import org.checkerframework.checker.units.qual.A;

public class AlertaFactory {
    public static Alerta createIncidentePorAlerta(String nombreAlerta, Heladera heladera) {
        Alerta alerta = new Alerta("Incidente ocacionado por una Alerta de " + nombreAlerta, heladera);
        //Alerta alerta = new Alerta();
        alerta.setTipoDeAlerta(TipoAlerta.valueOf(nombreAlerta));
        //incidente.setAlerta(alerta);
        return alerta;
    }
}
