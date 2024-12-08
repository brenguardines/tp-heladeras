package ar.edu.utn.frba.dds.utils.calculadorDePuntos.criteriosDePuntos;

import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeVianda;

public class PuntosPorViandasDonadas implements CriterioDePuntacion{
    private Double multiplicador = 1.5;

    @Override
    public Double calcularPuntos(PersonaHumana persona) {
        return this.cantidadDeViandasDonadas(persona) * multiplicador;
    }

    public Integer cantidadDeViandasDonadas(PersonaHumana persona) {
        return persona.getDonacionesDeViandas().size();
    }
}