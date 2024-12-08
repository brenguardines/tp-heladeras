package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class HeladeraRepository implements IRepository<Heladera>, WithSimplePersistenceUnit {

    private static HeladeraRepository instancia;

    public static HeladeraRepository getInstance() {
        if (instancia == null) {
            instancia = new HeladeraRepository();
        }
        return instancia;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Heladera> buscarTodos() {
        return entityManager() // Usar el EntityManager para tpanualdds
                .createQuery("from " + Heladera.class.getName(), Heladera.class) // Especifica el tipo
                .getResultList();
    }

    @Override
    public Optional<Heladera> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(Heladera.class, id));
    }


    @SuppressWarnings("unchecked")
    public List<Heladera> buscarElementosPorString(String nombre) {
        return entityManager()
                .createQuery("from " + Heladera.class.getName() + " where nombre = :name", Heladera.class) // Especifica el tipo
                .setParameter("name", nombre)
                .getResultList();
    }

    public List<Heladera> buscarHeladerasActivas() {
        return entityManager() // Usar el EntityManager para tpanualdds
                .createQuery("from " + Heladera.class.getName(), Heladera.class) // Especifica el tipo
                .getResultList()
                .stream().filter(heladera -> heladera.getEstaActivo())
                .toList();
    }

    @Override
    public void guardar(Heladera heladera) {
        heladera.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().persist(heladera);
    }

    @Override
    public void actualizar(Heladera heladera) {
        heladera.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(heladera);
    }

    @Override
    public void eliminar(Heladera heladera) {
        // BAJA LÓGICA
        heladera.setFechaBaja(LocalDateTime.now());
        heladera.setEstaActivo(false);
        entityManager().merge(heladera);
    }

    @Override
    public void eliminarFisico(Heladera heladera) {
        entityManager().remove(entityManager().contains(heladera) ? heladera : entityManager().find(Heladera.class, heladera.getId()));
    }

    // TODO: Ver si se implementan en otro repository

    public List<Heladera> buscarFallasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        return null; // Implementación pendiente
    }

    public List<Heladera> buscarMovimientosEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        return null; // Implementación pendiente
    }

}
