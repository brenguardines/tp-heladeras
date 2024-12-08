package ar.edu.utn.frba.dds.models.entities.receptores.intentosApertura;

import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.receptores.AsignadorDeObjetosJson;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;
import ar.edu.utn.frba.dds.utils.clienteBroker.Broker;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class IntentoAperturaReceptor implements IMqttMessageListener {
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        IntentoApertura msjIntentoApertura = AsignadorDeObjetosJson.parsear(mqttMessage.toString(), IntentoApertura.class);
        System.out.println("idHeladera: " + msjIntentoApertura.getIdHeladera()+", Fecha y Hora del Alta: "+ msjIntentoApertura.getFechaHoraAlta()+
                            ", fecha y hora de la ejecución: "+ msjIntentoApertura.getFechaHoraEjecucion()+
                            ", motivo: "+ msjIntentoApertura.getMotivo()+
                            ", idTarjeta: "+ msjIntentoApertura.getIdTarjeta()+
                            ", cantidad: " + msjIntentoApertura.getCantidad()+
                            ", estado: " + msjIntentoApertura.getEstado());

        //registrar el intento de apertura
        HeladeraRepository repo= HeladeraRepository.getInstance();
        Heladera heladera = repo.buscarPorId((long) msjIntentoApertura.getIdHeladera()).get();
        heladera.agregarIntentoDeApertura(msjIntentoApertura);
    }

    public static void main(String[] args) throws MqttException {
        IntentoAperturaReceptor receptor = new IntentoAperturaReceptor();
        Broker broker = new Broker("tcp://test.mosquitto.org:1883");
        broker.connect();
        broker.subscribe("dds/tpAnual/intentosDeApertura", receptor);
    }
}
