package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository implements IRepository<Usuario>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<Usuario> buscarTodos() {
    return entityManager()
        .createQuery("from " + Usuario.class.getName())
        .getResultList();
  }

  @Override
  public Optional<Usuario> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(Usuario.class, id));
  }

  @Override
  public void guardar(Usuario usuario) {
    withTransaction(()->{
      usuario.setFechaUltimaModificacion(LocalDateTime.now());
      usuario.setEstaActivo(true);
      usuario.setFechaDeAlta(LocalDateTime.now());
      entityManager().persist(usuario);
    });
  }

  @Override
  public void actualizar(Usuario usuario) {
    usuario.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(usuario);
  }

  @Override
  public void eliminar(Usuario usuario) {
    usuario.setFechaBaja(LocalDateTime.now());
    usuario.setEstaActivo(false);
    entityManager().merge(usuario);
  }

  @SuppressWarnings("unchecked")
  public List<Usuario> buscarPorString(String nombre) {
    return entityManager()
                .createQuery("from " + Usuario.class.getName() + " where nombreDeUsuario = :nick")
                .setParameter("nick", nombre)
                .getResultList();
  }

  @Override
  public void eliminarFisico(Usuario usuario) {
    entityManager().remove(usuario);
  }
}
