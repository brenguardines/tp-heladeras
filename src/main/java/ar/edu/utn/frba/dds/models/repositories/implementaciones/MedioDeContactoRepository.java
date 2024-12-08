package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MedioDeContactoRepository implements IRepository<MedioDeContacto>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<MedioDeContacto> buscarTodos() {
    return entityManager()
        .createQuery("from " + MedioDeContacto.class.getName())
        .getResultList();
  }

  @Override
  public Optional<MedioDeContacto> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(MedioDeContacto.class, id));
  }

  @Override
  public void guardar(MedioDeContacto medioDeContacto) {
    medioDeContacto.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(medioDeContacto);
  }

  @Override
  public void actualizar(MedioDeContacto medioDeContacto) {
    medioDeContacto.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(medioDeContacto);
  }

  @Override
  public void eliminar(MedioDeContacto medioDeContacto) {
    medioDeContacto.setFechaBaja(LocalDateTime.now());
    medioDeContacto.setEstaActivo(false);
    entityManager().merge(medioDeContacto);
  }

  @Override
  public void eliminarFisico(MedioDeContacto medioDeContacto) {
    entityManager().remove(medioDeContacto);
  }
}
