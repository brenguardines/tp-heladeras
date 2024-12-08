package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.formulario.Opcion;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class OpcionRepository implements IRepository<Opcion>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<Opcion> buscarTodos() {
    return entityManager()
        .createQuery("from " + Opcion.class.getName())
        .getResultList();
  }

  @Override
  public Optional<Opcion> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(Opcion.class, id));
  }

  @Override
  public void guardar(Opcion opcion) {
    opcion.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(opcion);
  }

  @Override
  public void actualizar(Opcion opcion) {
    opcion.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(opcion);
  }

  @Override
  public void eliminar(Opcion opcion) {
    opcion.setFechaBaja(LocalDateTime.now());
    opcion.setEstaActivo(false);
    entityManager().merge(opcion);
  }

  @Override
  public void eliminarFisico(Opcion opcion) {
    entityManager().remove(opcion);
  }
}
