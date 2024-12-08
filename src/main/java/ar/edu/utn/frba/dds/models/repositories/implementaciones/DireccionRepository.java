package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.direccion.Direccion;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class DireccionRepository implements IRepository<Direccion>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<Direccion> buscarTodos() {
    return entityManager()
        .createQuery("from " + Direccion.class.getName())
        .getResultList();
  }

  @Override
  public Optional<Direccion> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(Direccion.class, id));
  }

  @Override
  public void guardar(Direccion direccion) {
    direccion.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(direccion);
  }

  public List<Direccion> buscarElementosPorStringCalleNumeroCP(String calle, String altura, String codigoPostal) {
    return entityManager()
            .createQuery("from " + Direccion.class.getName() + "where calle = :calle and altura = :altura and codigoPostal = :codigoPostal")
            .setParameter("calle", calle)
            .setParameter("altura", altura)
            .setParameter("codigoPostal", codigoPostal)
            .getResultList();
  }

  @Override
  public void actualizar(Direccion direccion) {
    direccion.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(direccion);
  }

  @Override
  public void eliminar(Direccion direccion) {
    direccion.setFechaBaja(LocalDateTime.now());
    direccion.setEstaActivo(false);
    entityManager().merge(direccion);
  }

  @Override
  public void eliminarFisico(Direccion direccion) {
    entityManager().remove(direccion);
  }
}
