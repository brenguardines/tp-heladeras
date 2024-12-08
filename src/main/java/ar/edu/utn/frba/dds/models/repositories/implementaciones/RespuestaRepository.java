package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.formulario.Respuesta;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class RespuestaRepository implements IRepository<Respuesta>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<Respuesta> buscarTodos() {
    return entityManager()
        .createQuery("from " + Respuesta.class.getName())
        .getResultList();
  }

  @Override
  public Optional<Respuesta> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(Respuesta.class, id));
  }

  @Override
  public void guardar(Respuesta respuesta) {
    respuesta.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(respuesta);
  }

  @Override
  public void actualizar(Respuesta respuesta) {
    respuesta.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(respuesta);
  }

  @Override
  public void eliminar(Respuesta respuesta) {
    respuesta.setFechaBaja(LocalDateTime.now());
    respuesta.setEstaActivo(false);
    entityManager().merge(respuesta);
  }

  @Override
  public void eliminarFisico(Respuesta respuesta) {
    entityManager().remove(respuesta);
  }
}
