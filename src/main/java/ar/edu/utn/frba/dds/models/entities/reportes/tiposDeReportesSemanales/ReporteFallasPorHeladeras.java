package ar.edu.utn.frba.dds.models.entities.reportes.tiposDeReportesSemanales;

import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.reportes.IReporte;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ReporteFallasPorHeladeras implements IReporte {
    private  String reporte;
    private long cantidadDeDias = 7;
    HeladeraRepository heladeras = HeladeraRepository.getInstance();


    public String hacerReporte(){
        this.reporte = "REPORTE DE FALLAS POR HELADERAS:\n ---------------------------------------------------------------- \n";
        this.heladeras.buscarFallasEntreFechas(LocalDateTime.now(), LocalDateTime.now().minusDays(cantidadDeDias))
                      .forEach(heladera -> this.imprimirFalla(heladera));

        return this.reporte;
    }

    protected void imprimirFalla(Heladera heladera) {
        modificarReporte("\nEn la heladera: " + heladera.getNombre() + "\n");
        heladera.getFallasEntreFechas(LocalDateTime.now(), LocalDateTime.now().minusDays(cantidadDeDias))
                .forEach( falla ->
                        this.modificarReporte("\n\t - En el dia " + falla.getFechaHora() + " ocurrio la sigueinte falla: '" + falla.getDescripcion() + "'.")
                );
    }

    public void modificarReporte(String modificacion) {
        this.reporte += modificacion;
    }
}
