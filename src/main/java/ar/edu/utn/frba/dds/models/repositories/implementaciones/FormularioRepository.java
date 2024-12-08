package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.formulario.Formulario;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class FormularioRepository implements IRepository<Formulario>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<Formulario> buscarTodos() {
    return entityManager()
        .createQuery("from " + Formulario.class.getName())
        .getResultList();
  }

  @Override
  public Optional<Formulario> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(Formulario.class, id));
  }

  @Override
  public void guardar(Formulario formulario) {
    formulario.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(formulario);
  }

  @Override
  public void actualizar(Formulario formulario) {
    formulario.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(formulario);
  }

  @Override
  public void eliminar(Formulario formulario) {
    formulario.setFechaBaja(LocalDateTime.now());
    formulario.setEstaActivo(false);
    entityManager().merge(formulario);
  }

  @Override
  public void eliminarFisico(Formulario formulario) {
    entityManager().remove(formulario);
  }
}
