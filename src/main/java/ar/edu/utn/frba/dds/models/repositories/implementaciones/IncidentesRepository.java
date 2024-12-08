package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.incidentes.Alerta;
import ar.edu.utn.frba.dds.models.entities.incidentes.Incidente;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class IncidentesRepository implements IRepository<Incidente>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<Incidente> buscarTodos() {
    return entityManager()
        .createQuery("from " + Incidente.class.getName())
        .getResultList();
  }

  @SuppressWarnings("")
  public List<Incidente> buscarPorTipo(String tipo){
    return entityManager()
            .createQuery("from " + Incidente.class.getName() + "where tipo = :tipo")
            .setParameter("tipo", tipo)
            .getResultList();
  }
  @Override
  public Optional<Incidente> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(Incidente.class, id));
  }

  @Override
  public void guardar(Incidente incidente) {
    incidente.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(incidente);
  }

  @Override
  public void actualizar(Incidente incidente) {
    incidente.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(incidente);
  }

  @Override
  public void eliminar(Incidente incidente) {
    incidente.setFechaBaja(LocalDateTime.now());
    incidente.setEstaActivo(false);
    entityManager().merge(incidente);
  }

  @Override
  public void eliminarFisico(Incidente incidente) {
    entityManager().remove(incidente);
  }
}
