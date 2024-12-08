package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.tarjeta.TarjetaColaborador;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TarjetaColaboradorRepository implements IRepository<TarjetaColaborador>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<TarjetaColaborador> buscarTodos() {
    return entityManager()
        .createQuery("from " + TarjetaColaborador.class.getName())
        .getResultList();
  }

  @Override
  public Optional<TarjetaColaborador> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(TarjetaColaborador.class, id));
  }

  @Override
  public void guardar(TarjetaColaborador tarjetaColaborador) {
    tarjetaColaborador.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(tarjetaColaborador);
  }

  @Override
  public void actualizar(TarjetaColaborador tarjetaColaborador) {
    tarjetaColaborador.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(tarjetaColaborador);
  }

  @Override
  public void eliminar(TarjetaColaborador tarjetaColaborador) {
    tarjetaColaborador.setFechaBaja(LocalDateTime.now());
    tarjetaColaborador.setEstaActivo(false);
    entityManager().merge(tarjetaColaborador);
  }

  @Override
  public void eliminarFisico(TarjetaColaborador tarjetaColaborador) {
    entityManager().remove(tarjetaColaborador);
  }
}
