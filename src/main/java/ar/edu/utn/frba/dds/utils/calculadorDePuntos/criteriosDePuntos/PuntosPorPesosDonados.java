package ar.edu.utn.frba.dds.utils.calculadorDePuntos.criteriosDePuntos;

import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeDinero;

public class PuntosPorPesosDonados implements CriterioDePuntacion{
    private Double multiplicador = 0.5;

    @Override
    public Double calcularPuntos(PersonaHumana persona) {
        return this.cantidadDePesosDonados(persona) * multiplicador;
    }

    public Double cantidadDePesosDonados(PersonaHumana persona) {
        return persona.getDonacionesDeDinero().stream()
                .mapToDouble(DonacionDeDinero::getMonto)
                .sum();
    }
}