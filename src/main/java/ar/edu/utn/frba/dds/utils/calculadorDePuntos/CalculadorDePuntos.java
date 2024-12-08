package ar.edu.utn.frba.dds.utils.calculadorDePuntos;


import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.utils.calculadorDePuntos.criteriosDePuntos.*;

import java.util.List;

public class CalculadorDePuntos {
    private List<CriterioDePuntacion> criteriosDePuntuacion;

    public CalculadorDePuntos() {
        this.criteriosDePuntuacion = List.of(
                new PuntosPorHeladeras(),
                new PuntosPorPesosDonados(),
                new PuntosPorTarjetasRepartidas(),
                new PuntosPorViandasDistribuidas(),
                new PuntosPorViandasDonadas()
                );
    }

    public Double calcularPuntos(PersonaHumana persona) {
        return this.criteriosDePuntuacion.stream()
                                         .mapToDouble( criterio -> criterio.calcularPuntos(persona) )
                                         .sum();
    }
}