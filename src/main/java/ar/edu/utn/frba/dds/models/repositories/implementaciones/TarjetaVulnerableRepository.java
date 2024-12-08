package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.tarjeta.TarjetaVulnerable;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TarjetaVulnerableRepository implements IRepository<TarjetaVulnerable>, WithSimplePersistenceUnit {
  @Override
  @SuppressWarnings("unchecked")
  public List<TarjetaVulnerable> buscarTodos() {
    return entityManager()
        .createQuery("from " + TarjetaVulnerable.class.getName())
        .getResultList();
  }

  @Override
  public Optional<TarjetaVulnerable> buscarPorId(Long id) {
    return Optional.ofNullable(entityManager().find(TarjetaVulnerable.class, id));
  }

  public List<TarjetaVulnerable> buscarElementosPorStringCodigo(String codigo) {
    return entityManager()
            .createQuery("from " + TarjetaVulnerable.class.getName() + "where codigo = :codigo")
            .setParameter("codigo", codigo)
            .getResultList();
  }

  @Override
  public void guardar(TarjetaVulnerable tarjetaVulnerable) {
    tarjetaVulnerable.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().persist(tarjetaVulnerable);
  }

  @Override
  public void actualizar(TarjetaVulnerable tarjetaVulnerable) {
    tarjetaVulnerable.setFechaUltimaModificacion(LocalDateTime.now());
    entityManager().merge(tarjetaVulnerable);
  }

  @Override
  public void eliminar(TarjetaVulnerable tarjetaVulnerable) {
    tarjetaVulnerable.setFechaBaja(LocalDateTime.now());
    tarjetaVulnerable.setEstaActivo(false);
    entityManager().merge(tarjetaVulnerable);
  }

  @Override
  public void eliminarFisico(TarjetaVulnerable tarjetaVulnerable) {
    entityManager().remove(tarjetaVulnerable);
  }


}
