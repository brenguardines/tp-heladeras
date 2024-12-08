package ar.edu.utn.frba.dds.models.entities.reportes;

import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;

import java.time.LocalDateTime;

public interface IReporte {
    //String reporte = "";
    //long cantidadDeDias = 7;

    public String hacerReporte();

    public void modificarReporte(String modificacion);
}
