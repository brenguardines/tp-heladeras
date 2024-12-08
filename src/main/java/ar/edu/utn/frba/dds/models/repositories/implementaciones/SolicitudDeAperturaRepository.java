package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.repositories.IRepository;
import ar.edu.utn.frba.dds.utils.calculadorDePuntos.acciones.SolicitudDeApertura;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class SolicitudDeAperturaRepository implements IRepository<SolicitudDeApertura>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<SolicitudDeApertura> buscarTodos() {
    return entityManager()
        .createQuery("from " + SolicitudDeApertura.class.getName())
        .getResultList();
  }

  @Override
  public Optional<SolicitudDeApertura> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(SolicitudDeApertura.class, id));
  }

  @Override
  public void guardar(SolicitudDeApertura solicitudDeApertura) {
    solicitudDeApertura.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(solicitudDeApertura);
  }

  @Override
  public void actualizar(SolicitudDeApertura solicitudDeApertura) {
    solicitudDeApertura.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(solicitudDeApertura);
  }

  @Override
  public void eliminar(SolicitudDeApertura solicitudDeApertura) {
    solicitudDeApertura.setFechaBaja(LocalDateTime.now());
    solicitudDeApertura.setEstaActivo(false);
    entityManager().merge(solicitudDeApertura);
  }

  @Override
  public void eliminarFisico(SolicitudDeApertura solicitudDeApertura) {
    entityManager().remove(solicitudDeApertura);
  }
}
