package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.heladera.utilidades.ModeloHeladera;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ModeloHeladeraRepository implements IRepository<ModeloHeladera>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<ModeloHeladera> buscarTodos() {
    return entityManager()
        .createQuery("from " + ModeloHeladera.class.getName())
        .getResultList();
  }

  @Override
  public Optional<ModeloHeladera> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(ModeloHeladera.class, id));
  }

  @Override
  public void guardar(ModeloHeladera modeloHeladera) {
    modeloHeladera.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(modeloHeladera);
  }

  @Override
  public void actualizar(ModeloHeladera modeloHeladera) {
    modeloHeladera.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(modeloHeladera);
  }

  @Override
  public void eliminar(ModeloHeladera modeloHeladera) {
    modeloHeladera.setFechaBaja(LocalDateTime.now());
    modeloHeladera.setEstaActivo(false);
    entityManager().merge(modeloHeladera);
  }

  @Override
  public void eliminarFisico(ModeloHeladera modeloHeladera) {
    entityManager().remove(modeloHeladera);
  }

  @SuppressWarnings("unchecked")
  public List<ModeloHeladera> buscarPorNombreModelo(String nombreModelo){
    return entityManager()
            .createQuery("from " + ModeloHeladera.class.getName() + " where nombre = :name")
            .setParameter("name", nombreModelo)
            .getResultList();
  }
}
