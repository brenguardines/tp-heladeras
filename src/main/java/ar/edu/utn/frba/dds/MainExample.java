package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.server.Server;
import ar.edu.utn.frba.dds.utils.APIColocacionDePuntosAdapter.ClienteRetrofit;
import ar.edu.utn.frba.dds.utils.integracionLugaresRecomendados.LugarRecomendable;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

public class MainExample implements WithSimplePersistenceUnit {
    public static void main(String[] args) throws Exception {
        /*
        ClienteRetrofit clienteRetrofit = ClienteRetrofit.getInstancia();

        double latitud = -34.59824563867314;
        double longitud = -58.420012658665414;
        Integer radio = 250;

        try {
            List<LugarRecomendable> lugares = clienteRetrofit.obtenerLugaresRecomendablesParaDonar(
                latitud, longitud, radio, LocalTime.of(17, 30), "lunes"
            );

            if (!lugares.isEmpty()) {
                lugares.forEach(lugar -> {
                    System.out.println("Nombre: " + lugar.getNombre());
                    System.out.println("Coordenadas: " + lugar.getCoordenada());
                    System.out.println("Activo: " + lugar.getEstaActivo());
                    System.out.println();
                });
            } else {
                System.out.println("No se encontraron lugares recomendables.");
            }
        } catch (IOException e) {
            System.err.println("Error al obtener lugares recomendables: " + e.getMessage());
            e.printStackTrace();
        }*/

        MainExample instance = new MainExample();
        instance.inicializar();
        Server.init();

    }

    public void inicializar() {
        withTransaction(() -> {});
    }
}
