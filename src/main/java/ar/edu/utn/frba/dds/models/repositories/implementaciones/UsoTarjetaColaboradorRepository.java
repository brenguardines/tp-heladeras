package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.tarjeta.usos.UsoTarjetaColaborador;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UsoTarjetaColaboradorRepository implements IRepository<UsoTarjetaColaborador>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<UsoTarjetaColaborador> buscarTodos() {
    return entityManager()
        .createQuery("from " + UsoTarjetaColaborador.class.getName())
        .getResultList();
  }

  @Override
  public Optional<UsoTarjetaColaborador> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(UsoTarjetaColaborador.class, id));
  }

  @Override
  public void guardar(UsoTarjetaColaborador usoTarjetaColaborador) {
    usoTarjetaColaborador.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(usoTarjetaColaborador);
  }

  @Override
  public void actualizar(UsoTarjetaColaborador usoTarjetaColaborador) {
    usoTarjetaColaborador.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(usoTarjetaColaborador);
  }

  @Override
  public void eliminar(UsoTarjetaColaborador usoTarjetaColaborador) {
    usoTarjetaColaborador.setFechaBaja(LocalDateTime.now());
    usoTarjetaColaborador.setEstaActivo(false);
    entityManager().merge(usoTarjetaColaborador);
  }

  @Override
  public void eliminarFisico(UsoTarjetaColaborador usoTarjetaColaborador) {
    entityManager().remove(usoTarjetaColaborador);
  }
}
