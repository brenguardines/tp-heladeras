package ar.edu.utn.frba.dds.utils.integracionLugaresRecomendados;

import ar.edu.utn.frba.dds.models.entities.direccion.Coordenada;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@Setter
public class LugarRecomendable {
    @SerializedName("id")
    private Long id;

    @SerializedName("activo")
    private Boolean estaActivo;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("puntoGeografico")
    private Coordenada coordenada;

    @SerializedName("horaApertura")
    private List<Integer> horasApertura;

    @SerializedName("horaCierre")
    private List<Integer> horaCierre;

    @SerializedName("diasAbierto")
    private List<DayOfWeek> diasAbierto;
}
