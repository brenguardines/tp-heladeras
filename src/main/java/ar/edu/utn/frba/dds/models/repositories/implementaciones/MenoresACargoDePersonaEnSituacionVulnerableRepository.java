package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.personaEnSituacionVulnerable.MenoresACargoDePersonaEnSituacionVulnerable;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MenoresACargoDePersonaEnSituacionVulnerableRepository implements IRepository<MenoresACargoDePersonaEnSituacionVulnerable>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<MenoresACargoDePersonaEnSituacionVulnerable> buscarTodos() {
    return entityManager()
        .createQuery("from " + MenoresACargoDePersonaEnSituacionVulnerable.class.getName())
        .getResultList();
  }

  @Override
  public Optional<MenoresACargoDePersonaEnSituacionVulnerable> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(MenoresACargoDePersonaEnSituacionVulnerable.class, id));
  }

  @Override
  public void guardar(MenoresACargoDePersonaEnSituacionVulnerable MenoresACargoDePersonaEnSituacionVulnerable) {
      MenoresACargoDePersonaEnSituacionVulnerable.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(MenoresACargoDePersonaEnSituacionVulnerable);
  }

  @Override
  public void actualizar(MenoresACargoDePersonaEnSituacionVulnerable MenoresACargoDePersonaEnSituacionVulnerable) {
      MenoresACargoDePersonaEnSituacionVulnerable.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(MenoresACargoDePersonaEnSituacionVulnerable);
  }

  @Override
  public void eliminar(MenoresACargoDePersonaEnSituacionVulnerable MenoresACargoDePersonaEnSituacionVulnerable) {
      MenoresACargoDePersonaEnSituacionVulnerable.setFechaBaja(LocalDateTime.now());
      MenoresACargoDePersonaEnSituacionVulnerable.setEstaActivo(false);
    entityManager().merge(MenoresACargoDePersonaEnSituacionVulnerable);
  }

  @Override
  public void eliminarFisico(MenoresACargoDePersonaEnSituacionVulnerable MenoresACargoDePersonaEnSituacionVulnerable) {
    entityManager().remove(MenoresACargoDePersonaEnSituacionVulnerable);
  }
}

