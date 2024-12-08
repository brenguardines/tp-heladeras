package ar.edu.utn.frba.dds.config;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;

public class MercadoPagoConfig {

    private static String accessToken = "TU_ACCESS_TOKEN";
    public static void initialize() {
        try {
            
            MercadoPago.SDK.setAccessToken(accessToken);  // Poner el token que corresponderia a nuetra cuenta
        } catch (MPException e) {
            e.printStackTrace();
        }
    }

    public static void setAccessToken(String accessToken) {
        MercadoPagoConfig.accessToken = accessToken;
    }
}
