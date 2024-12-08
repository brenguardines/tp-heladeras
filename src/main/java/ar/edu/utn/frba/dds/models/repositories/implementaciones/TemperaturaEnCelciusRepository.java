package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.heladera.utilidades.TemperaturaEnCelcius;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TemperaturaEnCelciusRepository implements IRepository<TemperaturaEnCelcius>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<TemperaturaEnCelcius> buscarTodos() {
    return entityManager()
        .createQuery("from " + TemperaturaEnCelcius.class.getName())
        .getResultList();
  }

  @Override
  public Optional<TemperaturaEnCelcius> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(TemperaturaEnCelcius.class, id));
  }

  @Override
  public void guardar(TemperaturaEnCelcius temperaturaEnCelcius) {
    temperaturaEnCelcius.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(temperaturaEnCelcius);
  }

  @Override
  public void actualizar(TemperaturaEnCelcius temperaturaEnCelcius) {
    temperaturaEnCelcius.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(temperaturaEnCelcius);
  }

  @Override
  public void eliminar(TemperaturaEnCelcius temperaturaEnCelcius) {
    temperaturaEnCelcius.setFechaBaja(LocalDateTime.now());
    temperaturaEnCelcius.setEstaActivo(false);
    entityManager().merge(temperaturaEnCelcius);
  }

  @Override
  public void eliminarFisico(TemperaturaEnCelcius temperaturaEnCelcius) {
    entityManager().remove(temperaturaEnCelcius);
  }
}
