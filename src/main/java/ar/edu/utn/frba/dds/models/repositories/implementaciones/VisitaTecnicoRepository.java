package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.incidentes.VisitaTecnico;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class VisitaTecnicoRepository implements IRepository<VisitaTecnico>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<VisitaTecnico> buscarTodos() {
    return entityManager()
        .createQuery("from " + VisitaTecnico.class.getName())
        .getResultList();
  }

  @Override
  public Optional<VisitaTecnico> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(VisitaTecnico.class, id));
  }

  @Override
  public void guardar(VisitaTecnico visitaTecnico) {
    visitaTecnico.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(visitaTecnico);
  }

  @Override
  public void actualizar(VisitaTecnico visitaTecnico) {
    visitaTecnico.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(visitaTecnico);
  }

  @Override
  public void eliminar(VisitaTecnico visitaTecnico) {
    visitaTecnico.setFechaBaja(LocalDateTime.now());
    visitaTecnico.setEstaActivo(false);
    entityManager().merge(visitaTecnico);
  }

  @Override
  public void eliminarFisico(VisitaTecnico visitaTecnico) {
    entityManager().remove(visitaTecnico);
  }
}
