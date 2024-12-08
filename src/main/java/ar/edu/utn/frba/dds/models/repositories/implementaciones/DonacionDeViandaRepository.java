package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeVianda;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class DonacionDeViandaRepository implements IRepository<DonacionDeVianda>, WithSimplePersistenceUnit {

    @SuppressWarnings("unchecked")
    @Override
    public List<DonacionDeVianda> buscarTodos() {
        return entityManager()
                .createQuery("from " + DonacionDeVianda.class.getName())
                .getResultList();
    }

    @Override
    public Optional<DonacionDeVianda> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(DonacionDeVianda.class, id));
    }

    @Transactional
    public void guardar(DonacionDeVianda donacionDeVianda) {
        donacionDeVianda.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().persist(donacionDeVianda);
    }


    @Override
    public void actualizar(DonacionDeVianda donacionDeVianda) {
        donacionDeVianda.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(donacionDeVianda);
    }

    @Override
    public void eliminar(DonacionDeVianda donacionDeVianda) {
        //BAJA LÓGICA
        donacionDeVianda.setFechaBaja(LocalDateTime.now());
        donacionDeVianda.setEstaActivo(false);
        entityManager().merge(donacionDeVianda);
    }

    @Override
    public void eliminarFisico(DonacionDeVianda donacionDeVianda) {
        entityManager().remove(donacionDeVianda);
    }
}
