package ar.edu.utn.frba.dds.utils.calculadorDePuntos.criteriosDePuntos;

import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;

public interface CriterioDePuntacion {
    public Double multiplicador = null;

    Double calcularPuntos(PersonaHumana persona);
}
