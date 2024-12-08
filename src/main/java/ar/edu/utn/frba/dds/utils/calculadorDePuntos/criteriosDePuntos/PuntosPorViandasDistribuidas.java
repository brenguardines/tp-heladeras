package ar.edu.utn.frba.dds.utils.calculadorDePuntos.criteriosDePuntos;

import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DistribucionDeViandas;

public class PuntosPorViandasDistribuidas implements CriterioDePuntacion{
    private Double multiplicador = 1.0;

    @Override
    public Double calcularPuntos(PersonaHumana persona) {
        return this.cantidadDeViandasDistribuidas(persona) * multiplicador;
    }

    public Integer cantidadDeViandasDistribuidas(PersonaHumana persona) {
        return persona.getDonacionesDeViandas().size();
    }
}