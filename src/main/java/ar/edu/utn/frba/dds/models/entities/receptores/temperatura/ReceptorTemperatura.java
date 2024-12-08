package ar.edu.utn.frba.dds.models.entities.receptores.temperatura;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.receptores.AsignadorDeObjetosJson;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;
import ar.edu.utn.frba.dds.utils.reportadorDeAlertas.ReportadorDeAlertas;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.time.LocalDateTime;

public class ReceptorTemperatura implements IMqttMessageListener {
    // no debería de instanciar el repositorio de heladeras, debería haber una sola instancia. Después implementar el patrón SINGLETON
    HeladeraRepository heladeraRepository = HeladeraRepository.getInstance();

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        MensajeTemperatura msjTemperatura = AsignadorDeObjetosJson.parsear(mqttMessage.toString(), MensajeTemperatura.class);

        // devuelve una instancia vacía de una heladera, cuando nos conectemos a la DB va a estar más piola
        Heladera heladera = heladeraRepository.buscarPorId((long) msjTemperatura.getId()).get();

        //Rompe en el if porque el modelo de la heladera está vacía. Cuando el buscarPorId devuelva la heladera
        // con todos los datos, va a funcionar.
        //Pero debería de hacer esto. Verificar que la temperatura esté en los límites sino, alarma, registrar y cambiar el estado

        // 28 =heladera.getModelo().getTemperaturaMaxima().getValor()
        // 0 = heladera.getModelo().getTemperaturaMinima().getValor()

        if ( msjTemperatura.getTemperatura() >= heladera.getModelo().getTemperaturaMaxima() ||
             msjTemperatura.getTemperatura() <= heladera.getModelo().getTemperaturaMinima() ){
            ReportadorDeAlertas.reportarAlerta("Temperatura", heladera);
        }else{
            heladera.actualizarTemperaturaActual(msjTemperatura.getTemperatura(), msjTemperatura.getFechaHora());
            System.out.println("Temperatura: " + msjTemperatura.getTemperatura()+" °C, Fecha y Hora: "+ msjTemperatura.getFechaHora());
        }
    }
}
