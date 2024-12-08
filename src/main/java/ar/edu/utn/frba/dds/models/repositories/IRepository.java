package ar.edu.utn.frba.dds.models.repositories;

import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {

    List<T> buscarTodos();

    Optional<T> buscarPorId(Long id);

    // List<T> buscarElementosPorString(String elemento); // No lo puse porque no está en todos

    void guardar(T elemento);

    void actualizar(T elemento);

    void eliminar(T elemento);

    void eliminarFisico(T elemento);
}
