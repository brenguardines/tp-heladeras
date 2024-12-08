package ar.edu.utn.frba.dds.service;
/*
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.Subscription;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;
import com.mercadopago.resources.datastructures.preference.PaymentMethods;
import com.mercadopago.resources.datastructures.subscription.AutoRecurring;

public class MercadoPagoService {

    public MercadoPagoService() {
        try {
            // Configurar tu Access Token
            MercadoPago.SDK.setAccessToken("YOUR_ACCESS_TOKEN");
        } catch (MPException e) {
            e.printStackTrace();
        }
    }

    public String generarLinkDePago(Double monto, String frecuencia, String clienteId) {
        try {
            if (frecuencia.equalsIgnoreCase("recurrente")) {
                // Crear suscripción para pagos recurrentes
                Subscription subscription = new Subscription();

                // Crear configuración de pago recurrente
                AutoRecurring autoRecurring = new AutoRecurring()
                        .setFrequency(1) // Frecuencia de la recurrencia
                        .setFrequencyType(AutoRecurring.FrequencyType.months) // Tipo de frecuencia (mensual, semanal, etc.)
                        .setTransactionAmount(monto.floatValue())
                        .setCurrencyId("ARS"); // Moneda

                subscription.setAutoRecurring(autoRecurring);

                // Configurar el pagador con el ID del cliente de Mercado Pago
                Payer payer = new Payer();
                payer.setId(clienteId); // Usar el ID del cliente registrado
                subscription.setPayer(payer);

                // Guardar la suscripción
                subscription.save();

                // Retornar el enlace de pago de sandbox para pruebas
                return subscription.getSandboxInitPoint();

            } else {
                // Crear preferencia para pagos únicos
                Preference preference = new Preference();

                // Crear ítem de donación
                Item item = new Item()
                        .setTitle("Donación")
                        .setQuantity(1)
                        .setCurrencyId("ARS")  // Moneda
                        .setUnitPrice(monto.floatValue());

                // Agregar ítem a la preferencia
                preference.appendItem(item);

                // Configuración de la redirección automática
                preference.setAutoReturn(Preference.AutoReturn.approved); // Redirección automática a la página de éxito

                // URL de retorno (opcional)
                BackUrls backUrls = new BackUrls(
                        "/colaboracionExitosa",
                        "/cargando",
                        "/colaboracionFallida"
                );
                preference.setBackUrls(backUrls);

                // Información del donante
                Payer payer = new Payer();
                payer.setId(clienteId); // Usar el ID del cliente registrado
                preference.setPayer(payer);

                // Establecer métodos de pago
                PaymentMethods paymentMethods = new PaymentMethods();
                paymentMethods.setInstallments(1); // Puedes definir cuántas cuotas deseas

                // Guardar preferencia
                preference.setPaymentMethods(paymentMethods);
                preference.save();

                // Retornar el enlace de pago de sandbox para pruebas
                return preference.getSandboxInitPoint();
            }
        } catch (MPException e) {
            e.printStackTrace();
            return null;
        }
    }
}
*/