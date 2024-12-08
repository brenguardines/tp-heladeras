package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.heladera.utilidades.MovimientoDeViandas;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MovimientoDeViandaRepository implements IRepository<MovimientoDeViandas>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<MovimientoDeViandas> buscarTodos() {
    return entityManager()
        .createQuery("from " + MovimientoDeViandas.class.getName())
        .getResultList();
  }

  @Override
  public Optional<MovimientoDeViandas> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(MovimientoDeViandas.class, id));
  }

  @Override
  public void guardar(MovimientoDeViandas movimientoDeViandas) {
    movimientoDeViandas.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(movimientoDeViandas);
  }

  @Override
  public void actualizar(MovimientoDeViandas movimientoDeViandas) {
    movimientoDeViandas.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(movimientoDeViandas);
  }

  @Override
  public void eliminar(MovimientoDeViandas movimientoDeViandas) {
    movimientoDeViandas.setFechaBaja(LocalDateTime.now());
    movimientoDeViandas.setEstaActivo(false);
    entityManager().merge(movimientoDeViandas);
  }

  @Override
  public void eliminarFisico(MovimientoDeViandas movimientoDeViandas) {
    entityManager().remove(movimientoDeViandas);
  }
}
