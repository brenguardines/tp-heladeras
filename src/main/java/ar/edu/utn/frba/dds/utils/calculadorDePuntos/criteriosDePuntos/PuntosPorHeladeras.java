package ar.edu.utn.frba.dds.utils.calculadorDePuntos.criteriosDePuntos;

import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.models.entities.heladera.EstadoHeladera;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;

import java.time.LocalDateTime;
import java.util.List;

public class PuntosPorHeladeras implements CriterioDePuntacion{
    private Double multiplicador = 5.0;
    HeladeraRepository heladeraRepository = ServiceLocator.instanceOf(HeladeraRepository.class);


    @Override
    public Double calcularPuntos(PersonaHumana persona) {
        return ( this.cantidadDeHeladerasActivas() * cantidadDeMesesActivas() ) * multiplicador;
    }
    public List<Heladera> listaDeHeladerasActivas() {
        return this.heladeraRepository.buscarTodos().stream()
                                          .filter( heladera -> heladera.getEstado().equals(EstadoHeladera.Activa) )
                                          .toList();
    }

    public List<LocalDateTime> obtenerListaDeFechasDePuestaEnFuncionamiento() {
        return this.heladeraRepository.buscarTodos().stream()
                                          .map(Heladera::getFechaDeAlta)
                                          .toList();
    }

    public Integer cantidadDeHeladerasActivas() {
        return this.listaDeHeladerasActivas().size();
    }

    public Integer cantidadDeMesesActivas() {
        int cantidadDeMesesDelAnio = 12;

        return obtenerListaDeFechasDePuestaEnFuncionamiento()
                .stream()
                .mapToInt( fecha -> ( LocalDateTime.now().getYear() - fecha.getYear() ) * cantidadDeMesesDelAnio
                                      + LocalDateTime.now().getMonthValue() - fecha.getMonthValue() )
                .sum();
    }

}