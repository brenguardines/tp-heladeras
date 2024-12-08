package ar.edu.utn.frba.dds.utils.APIColocacionDePuntosAdapter;

import ar.edu.utn.frba.dds.models.entities.direccion.UbicacionConRadio;
import ar.edu.utn.frba.dds.utils.integracionLugaresRecomendados.LugarParaDonarRequest;
import ar.edu.utn.frba.dds.utils.integracionLugaresRecomendados.LugarRecomendable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface ServicioUbicacionHeladeras {
  @POST("/api/puntos-heladeras")
  Call<RespuestaPuntos> obtenerUbicacionesRecomendadas(@Body UbicacionConRadio solicitud);

  @GET("/api/recomendadorDePuntos")
  Call<List<LugarRecomendable>> obtenerLugaresRecomendablesParaDonar(
      @retrofit2.http.Query("latitud") double latitud,
      @retrofit2.http.Query("longitud") double longitud,
      @retrofit2.http.Query("radio") Integer radio,
      @retrofit2.http.Query("horarioBuscado") String horarioBuscado,
      @retrofit2.http.Query("diasBuscados") String diasBuscados
  );

}
