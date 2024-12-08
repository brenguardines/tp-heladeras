package ar.edu.utn.frba.dds.models.entities.receptores.movimiento;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.incidentes.Alerta;
import ar.edu.utn.frba.dds.models.entities.incidentes.Incidente;
import ar.edu.utn.frba.dds.models.entities.incidentes.TipoAlerta;
import ar.edu.utn.frba.dds.models.entities.receptores.AsignadorDeObjetosJson;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;
import ar.edu.utn.frba.dds.utils.reportadorDeAlertas.ReportadorDeAlertas;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class ReceptorMovimiento implements IMqttMessageListener {

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        MensajeMovimiento msjMovimiento = AsignadorDeObjetosJson.parsear(mqttMessage.toString(), MensajeMovimiento.class);
        HeladeraRepository repoHeladera = HeladeraRepository.getInstance();
        Heladera heladera = repoHeladera.buscarPorId((long) msjMovimiento.getIdHeladera()).get();

        System.out.println("idHeladera: "+msjMovimiento.getIdHeladera()+", fecha y hora: "+ msjMovimiento.getFechaHora() + ", valor: "+ msjMovimiento.getValor());
        ReportadorDeAlertas.reportarAlerta("Fraude", heladera);
    }
}
