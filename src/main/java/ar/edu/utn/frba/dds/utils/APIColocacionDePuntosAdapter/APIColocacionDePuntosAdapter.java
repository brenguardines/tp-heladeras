package ar.edu.utn.frba.dds.utils.APIColocacionDePuntosAdapter;

import ar.edu.utn.frba.dds.models.entities.direccion.Coordenada;
import ar.edu.utn.frba.dds.models.entities.direccion.UbicacionConRadio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  APIColocacionDePuntosAdapter {
    private ClienteRetrofit clienteRetrofit = ClienteRetrofit.getInstancia();
    private UbicacionConRadio ubicacionConRadio;

    public APIColocacionDePuntosAdapter(UbicacionConRadio ubicacionConRadio) {
        this.ubicacionConRadio = ubicacionConRadio;
    }

    public List<Coordenada> obtenerPuntosRecomendados() {
        List<Coordenada> coordenadas = new ArrayList<>();

        try {
            RespuestaPuntos respuestaPuntos = clienteRetrofit.obtenerPuntosRecomendados(
                    Double.parseDouble(ubicacionConRadio.latitud()),
                    Double.parseDouble(ubicacionConRadio.longitud()),
                    ubicacionConRadio.getRadio()
            );

            if (respuestaPuntos != null && respuestaPuntos.puntos != null) {
                for (RespuestaPuntos.Punto punto : respuestaPuntos.puntos) {
                    Coordenada nuevaCoordenada = new Coordenada(String.valueOf(punto.longitud), String.valueOf(punto.latitud));
                    coordenadas.add(nuevaCoordenada);
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontraron puntos recomendados.");
        }

        return coordenadas;
    }

    public Boolean puntoPereneceAlRadio(Coordenada coordenada) {
        try {
            RespuestaPuntos puntosRecomendados = clienteRetrofit.obtenerPuntosRecomendados(
                    Double.parseDouble(coordenada.getLatitud()),
                    Double.parseDouble(coordenada.getLongitud()),
                    ubicacionConRadio.getRadio()
            );

            if ( puntosRecomendados.getPuntos().stream().anyMatch(punto -> punto.equals(coordenada)) ) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println("No se encontraron puntos recomendados.");
        }
        return false;
    }
}
