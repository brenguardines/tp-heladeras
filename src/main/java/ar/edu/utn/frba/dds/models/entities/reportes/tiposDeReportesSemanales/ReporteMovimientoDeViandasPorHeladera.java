package ar.edu.utn.frba.dds.models.entities.reportes.tiposDeReportesSemanales;

import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.reportes.IReporte;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;

import java.time.LocalDateTime;

public class ReporteMovimientoDeViandasPorHeladera implements IReporte {
    private  String reporte;
    private long cantidadDeDias = 7;
    HeladeraRepository heladeras = HeladeraRepository.getInstance();

    public String hacerReporte(){
        this.reporte = "REPORTE DE MOVIMIENTOS POR HELADERAS:\n ---------------------------------------------------------------- \n";
        this.heladeras.buscarMovimientosEntreFechas(LocalDateTime.now(), LocalDateTime.now().minusDays(cantidadDeDias))
                      .forEach(heladera -> this.imprimirMovimiento(heladera));

        return this.reporte;
    }

    protected void imprimirMovimiento(Heladera heladera) {
        modificarReporte("\nEn la heladera: " + heladera.getNombre() + "\n");
        modificarReporte("\n\t - Se ingresarron: "
                + heladera.cantidadDeIngresos(heladera.getMovimientoDeViandasEntreFechas(LocalDateTime.now(), LocalDateTime.now().minusDays(cantidadDeDias))) + ".\n");
        modificarReporte("\n\t - Se retiraron: "
                + heladera.cantidadDeRetiros(heladera.getMovimientoDeViandasEntreFechas(LocalDateTime.now(), LocalDateTime.now().minusDays(cantidadDeDias))) + ".\n");
    }

    public void modificarReporte(String modificacion) {
        this.reporte += modificacion;
    }

}
