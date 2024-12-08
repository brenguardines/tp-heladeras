package ar.edu.utn.frba.dds.utils.APIColocacionDePuntosAdapter;

import ar.edu.utn.frba.dds.models.entities.direccion.Coordenada;
import ar.edu.utn.frba.dds.models.entities.direccion.UbicacionConRadio;
import ar.edu.utn.frba.dds.utils.integracionLugaresRecomendados.LugarParaDonarRequest;
import ar.edu.utn.frba.dds.utils.integracionLugaresRecomendados.LugarRecomendable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClienteRetrofit {
  private static ClienteRetrofit instancia = null;
  private static final String urlAPI = "http://localhost:7000/";

  private Retrofit retrofit;

  private ClienteRetrofit() {
    this.retrofit = new Retrofit.Builder()
        .baseUrl(urlAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public static ClienteRetrofit getInstancia() {
    if (instancia == null) {
      instancia = new ClienteRetrofit();
    }
    return instancia;
  }

  public RespuestaPuntos obtenerPuntosRecomendados(double latitud, double longitud, int radio) throws IOException {
    ServicioUbicacionHeladeras servicioUbicacionHeladeras = this.retrofit.create(ServicioUbicacionHeladeras.class);
    Coordenada coordenada = new Coordenada(String.valueOf(longitud), String.valueOf(latitud));
    UbicacionConRadio requestPuntos = new UbicacionConRadio(coordenada, radio);
    Call<RespuestaPuntos> call = servicioUbicacionHeladeras.obtenerUbicacionesRecomendadas(requestPuntos);
    Response<RespuestaPuntos> responsePuntos = call.execute();
    return responsePuntos.body();
  }

  public List<LugarRecomendable> obtenerLugaresRecomendablesParaDonar(
      double latitud, double longitud, Integer radio,
      LocalTime horarioBuscado, String diasBuscados) throws IOException {

    ServicioUbicacionHeladeras servicio = this.retrofit.create(ServicioUbicacionHeladeras.class);

    String horario = (horarioBuscado != null) ? horarioBuscado.format(DateTimeFormatter.ofPattern("HH.mm.ss")) : null;

    Call<List<LugarRecomendable>> call = servicio.obtenerLugaresRecomendablesParaDonar(
        latitud, longitud, radio, horario, diasBuscados
    );

    Response<List<LugarRecomendable>> response = call.execute();

    if (response.isSuccessful() && response.body() != null) {
      //System.out.println("Respuesta exitosa: " + response.body());
      return response.body();
    } else {
      //System.err.println("Error en la respuesta: " + response.code() + " - " + response.message());
      //System.err.println("Cuerpo de la respuesta: " + response.errorBody().string());
      return new ArrayList<>();
    }
  }


}
