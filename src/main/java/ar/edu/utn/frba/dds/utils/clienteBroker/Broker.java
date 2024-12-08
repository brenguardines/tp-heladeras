package ar.edu.utn.frba.dds.utils.clienteBroker;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import java.util.UUID;
public class Broker {
    private MemoryPersistence persistence = new MemoryPersistence();
    private MqttClient client;
    private String broker;
    private String clientId;
    private UUID uuid = UUID.randomUUID(); // va a ayudar a crear ID's únicos para no tener problemas

    public Broker(String broker) {
        this.broker = broker;
        this.clientId = uuid.toString();
    }
    public void connect() throws MqttException {
        client = new MqttClient(broker, clientId, persistence);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        try {
            System.out.println("Conectando al broker: " + broker);
            client.connect(connOpts);
            System.out.println("Conectado");
        }catch (MqttException me){
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
    public void subscribe(String topic, IMqttMessageListener receptor) throws MqttException {
        client.subscribe(topic, receptor);
        System.out.println("Suscrito al tópico " + topic);
    }
    public void publish(String topic, String content, int qos) throws MqttException {
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        try {
            client.publish(topic, message);
            System.out.println("Mensaje publicado en tópico " + topic + ": " + content);
        }catch (MqttException me){
            System.out.println("reason " + me.getReasonCode());
        }

    }
    public void disconnect() throws MqttException {
        client.disconnect();
        System.out.println("Desconectado del broker");
    }
    public boolean isConnected() {
        return client != null && client.isConnected();
    }
}
