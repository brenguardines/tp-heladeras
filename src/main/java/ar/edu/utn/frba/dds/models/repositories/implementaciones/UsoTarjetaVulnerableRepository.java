package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.tarjeta.usos.UsoTarjetaVulnerable;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UsoTarjetaVulnerableRepository implements IRepository<UsoTarjetaVulnerable>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<UsoTarjetaVulnerable> buscarTodos() {
    return entityManager()
        .createQuery("from " + UsoTarjetaVulnerable.class.getName())
        .getResultList();
  }

  @Override
  public Optional<UsoTarjetaVulnerable> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(UsoTarjetaVulnerable.class, id));
  }

  @Override
  public void guardar(UsoTarjetaVulnerable usoTarjetaVulnerable) {
    usoTarjetaVulnerable.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(usoTarjetaVulnerable);
  }

  @Override
  public void actualizar(UsoTarjetaVulnerable usoTarjetaVulnerable) {
    usoTarjetaVulnerable.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(usoTarjetaVulnerable);
  }

  @Override
  public void eliminar(UsoTarjetaVulnerable usoTarjetaVulnerable) {
    usoTarjetaVulnerable.setFechaBaja(LocalDateTime.now());
    usoTarjetaVulnerable.setEstaActivo(false);
    entityManager().merge(usoTarjetaVulnerable);
  }

  @Override
  public void eliminarFisico(UsoTarjetaVulnerable usoTarjetaVulnerable) {
    entityManager().remove(usoTarjetaVulnerable);
  }
}
