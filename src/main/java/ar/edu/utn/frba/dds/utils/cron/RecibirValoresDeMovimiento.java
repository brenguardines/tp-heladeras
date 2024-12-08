package ar.edu.utn.frba.dds.utils.cron;

import ar.edu.utn.frba.dds.models.entities.receptores.movimiento.ReceptorMovimiento;
import ar.edu.utn.frba.dds.utils.clienteBroker.Broker;
import org.eclipse.paho.client.mqttv3.MqttException;

// Debería de ejecutarse ttodo el tiempo

public class RecibirValoresDeMovimiento {
    public static void main(String[] args) throws MqttException {
        ReceptorMovimiento receptor = new ReceptorMovimiento();
        Broker broker = new Broker("tcp://test.mosquitto.org:1883");
        broker.connect();
        broker.subscribe("dds/tpAnual/movimientosHeladeras", receptor);
    }
}
