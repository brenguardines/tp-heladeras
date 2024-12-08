package ar.edu.utn.frba.dds.recibirTemperaturas;

import ar.edu.utn.frba.dds.models.entities.receptores.temperatura.MensajeTemperatura;
import ar.edu.utn.frba.dds.models.entities.receptores.temperatura.ReceptorTemperatura;
import ar.edu.utn.frba.dds.utils.clienteBroker.Broker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.jupiter.api.Test;

public class RecibirTemperaturasTest {
    /*
    @Test
    public void recibirTemperatura() throws MqttException, InterruptedException {
        ReceptorTemperatura receptor = new ReceptorTemperatura();
        Broker broker = new Broker("tcp://test.mosquitto.org:1883");
        broker.connect();
        broker.subscribe("dds/tpAnual/temperaturasHeladeras", receptor);
        Thread.sleep(180000);
    }

     */
}
