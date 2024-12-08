package ar.edu.utn.frba.dds.models.entities.reportes.tiposDeReportesSemanales;

import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.reportes.IReporte;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.PersonaHumanaRepository;

import java.time.LocalDateTime;

public class ReporteViandasPorColaborador implements IReporte {

    private  String reporte;
    private long cantidadDeDias = 7;

    PersonaHumanaRepository personas = ServiceLocator.instanceOf(PersonaHumanaRepository.class);

    public String hacerReporte() {
        this.reporte = "REPORTE DE VIANDAS POR PERSONA:\n ---------------------------------------------------------------- \n";
        this.personas.buscarDonacionYDistribucionDeViandasEntreFechas(LocalDateTime.now(), LocalDateTime.now().minusDays(cantidadDeDias))
                        .forEach(persona -> this.imprimirCantidades(persona));

        return this.reporte;
    }

    protected void imprimirCantidades(PersonaHumana persona) {
        this.modificarReporte("\nEn la persona: " + persona.getNombreYApellidoSeparado() + "\n");
        modificarReporte("\n \t - Cantidades de viandas donadas: " + persona.
                getDonacionesDeViandasEntreFechas(LocalDateTime.now(), LocalDateTime.now().minusDays(cantidadDeDias)).size());
        modificarReporte("\n \t - Cantidades de viandas entregadas: " +
                persona.getDistribucionesDeViandasEntreFechas(LocalDateTime.now(), LocalDateTime.now().minusDays(cantidadDeDias)).size());
    }

    public void modificarReporte(String modificacion) {
        this.reporte += modificacion;
    }
}
