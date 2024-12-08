package ar.edu.utn.frba.dds.utils.APIColocacionDePuntosAdapter;

import lombok.Getter;

import java.util.List;

@Getter
public class RespuestaPuntos {
  public List<Punto> puntos;

  public static class Punto {
    public double latitud;
    public double longitud;
  }
}
