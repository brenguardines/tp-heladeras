package ar.edu.utn.frba.dds.utils.cron;

import ar.edu.utn.frba.dds.models.entities.receptores.temperatura.ReceptorTemperatura;
import ar.edu.utn.frba.dds.utils.clienteBroker.Broker;
import org.eclipse.paho.client.mqttv3.MqttException;

public class RecibirTemperaturas {
    public static void main(String[] args) throws MqttException {

        // CADA 5 MINUTOS

        ReceptorTemperatura receptor = new ReceptorTemperatura();
        Broker broker = new Broker("tcp://test.mosquitto.org:1883");
        broker.connect();
        broker.subscribe("dds/tpAnual/temperaturasHeladeras", receptor);
    }
}
