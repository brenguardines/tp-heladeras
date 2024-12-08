package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.oferta.Canje;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CanjeRepository implements IRepository<Canje>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<Canje> buscarTodos() {
    return entityManager()
        .createQuery("from " + Canje.class.getName())
        .getResultList();
  }

  @Override
  public Optional<Canje> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(Canje.class, id));
  }

  @Override
  public void guardar(Canje canje) {
    withTransaction(()->{
      entityManager().persist(canje);
    });
  }

  @Override
  public void actualizar(Canje canje) {
    withTransaction(()->{
      entityManager().merge(canje);
    });
  }

  @Override
  public void eliminar(Canje canje) {
    canje.setFechaBaja(LocalDateTime.now());
    canje.setEstaActivo(false);
    entityManager().merge(canje);
  }

  @Override
  public void eliminarFisico(Canje canje) {
    entityManager().remove(canje);
  }
}
