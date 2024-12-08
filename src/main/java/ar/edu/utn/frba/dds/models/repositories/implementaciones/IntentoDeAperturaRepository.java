package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.receptores.intentosApertura.IntentoApertura;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class IntentoDeAperturaRepository implements IRepository<IntentoApertura>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<IntentoApertura> buscarTodos() {
    return entityManager()
        .createQuery("from " + IntentoApertura.class.getName())
        .getResultList();
  }

  @Override
  public Optional<IntentoApertura> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(IntentoApertura.class, id));
  }

  @Override
  public void guardar(IntentoApertura intentoApertura) {
    intentoApertura.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(intentoApertura);
  }

  @Override
  public void actualizar(IntentoApertura intentoApertura) {
    intentoApertura.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(intentoApertura);
  }

  @Override
  public void eliminar(IntentoApertura intentoApertura) {
    intentoApertura.setFechaBaja(LocalDateTime.now());
    intentoApertura.setEstaActivo(false);
    entityManager().merge(intentoApertura);
  }

  @Override
  public void eliminarFisico(IntentoApertura intentoApertura) {
    entityManager().remove(intentoApertura);
  }
}
