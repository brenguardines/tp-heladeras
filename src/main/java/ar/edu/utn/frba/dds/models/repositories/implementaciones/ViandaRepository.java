package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.vianda.Vianda;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ViandaRepository implements IRepository<Vianda>, WithSimplePersistenceUnit {

    @Override
    @SuppressWarnings("unchecked")
    public List<Vianda> buscarTodos() {
        return entityManager()
                .createQuery("from " + Vianda.class.getName())
                .getResultList();
    }

    @Override
    public Optional<Vianda> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(Vianda.class, id));
    }

    @Override
    public void guardar(Vianda vianda) {
        vianda.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().persist(vianda);
    }

    @Override
    public void actualizar(Vianda vianda) {
        vianda.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(vianda);
    }

    @Override
    public void eliminar(Vianda vianda) {
        //BAJA LÓGICA
        vianda.setFechaBaja(LocalDateTime.now());
        vianda.setEstaActivo(false);
        entityManager().merge(vianda);
    }

    @Override
    public void eliminarFisico(Vianda vianda) {
        entityManager().remove(vianda);
    }
}

