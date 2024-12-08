package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.formulario.Pregunta;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PreguntaRepository implements IRepository<Pregunta>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<Pregunta> buscarTodos() {
    return entityManager()
        .createQuery("from " + Pregunta.class.getName())
        .getResultList();
  }

  @Override
  public Optional<Pregunta> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(Pregunta.class, id));
  }

  @Override
  public void guardar(Pregunta pregunta) {
    pregunta.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(pregunta);
  }

  @Override
  public void actualizar(Pregunta pregunta) {
    pregunta.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(pregunta);
  }

  @Override
  public void eliminar(Pregunta pregunta) {
    pregunta.setFechaBaja(LocalDateTime.now());
    pregunta.setEstaActivo(false);
    entityManager().merge(pregunta);
  }

  @Override
  public void eliminarFisico(Pregunta pregunta) {
    entityManager().remove(pregunta);
  }
}
