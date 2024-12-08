package ar.edu.utn.frba.dds.utils.calculadorDePuntos.criteriosDePuntos;

import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.contribuciones.RegistroDePersonasEnSituacionVulnerable;

public class PuntosPorTarjetasRepartidas implements CriterioDePuntacion{
    private Double multiplicador = 2.0;

    @Override
    public Double calcularPuntos(PersonaHumana persona) {

        return this.cantidadDeTarjetasRepartidas(persona) * multiplicador;
    }

    public Integer cantidadDeTarjetasRepartidas(PersonaHumana persona) {
        return persona.getRegistrosDePersonasEnSituacionVulnerables().size();
    }
}