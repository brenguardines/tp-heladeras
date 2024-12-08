package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.formulario.FormularioRespondido;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class FormularioRespondidoRepository implements IRepository<FormularioRespondido>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<FormularioRespondido> buscarTodos() {
    return entityManager()
        .createQuery("from " + FormularioRespondido.class.getName())
        .getResultList();
  }

  @Override
  public Optional<FormularioRespondido> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(FormularioRespondido.class, id));
  }

  @Override
  public void guardar(FormularioRespondido formularioRespondido) {
    formularioRespondido.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(formularioRespondido);
  }

  @Override
  public void actualizar(FormularioRespondido formularioRespondido) {
    formularioRespondido.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(formularioRespondido);
  }

  @Override
  public void eliminar(FormularioRespondido formularioRespondido) {
    formularioRespondido.setFechaBaja(LocalDateTime.now());
    formularioRespondido.setEstaActivo(false);
    entityManager().merge(formularioRespondido);
  }

  @Override
  public void eliminarFisico(FormularioRespondido formularioRespondido) {
    entityManager().remove(formularioRespondido);
  }
}
