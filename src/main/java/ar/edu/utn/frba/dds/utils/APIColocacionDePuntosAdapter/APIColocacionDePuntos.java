package ar.edu.utn.frba.dds.utils.APIColocacionDePuntosAdapter;

import ar.edu.utn.frba.dds.models.entities.direccion.Coordenada;


import java.io.IOException;

public class APIColocacionDePuntos {
  public static void main(String[] args) throws IOException {
    ClienteRetrofit clienteRetrofit = ClienteRetrofit.getInstancia();

    Coordenada coordenada = new Coordenada("-58.381592", "-34.603722");
    int radio = 1000;

    RespuestaPuntos puntosRecomendados = clienteRetrofit.obtenerPuntosRecomendados(
        Double.parseDouble(coordenada.getLatitud()),
        Double.parseDouble(coordenada.getLongitud()),
        radio
    );

    if (puntosRecomendados != null && puntosRecomendados.puntos != null) {
      puntosRecomendados.puntos.forEach(punto -> {
        System.out.println("Latitud: " + punto.latitud);
        System.out.println("Longitud: " + punto.longitud);
        System.out.println();
      });
    } else {
      System.out.println("No se encontraron puntos recomendados.");
    }
  }
}