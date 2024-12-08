package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeOferta;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeOferta;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class DonacionDeOfertaReporitory implements IRepository<DonacionDeOferta>, WithSimplePersistenceUnit {

    @Override
    @SuppressWarnings("unchecked")
    public List<DonacionDeOferta> buscarTodos() {
        return entityManager()
                .createQuery("from " + DonacionDeOferta.class.getName())
                .getResultList();
    }

    @Override
    public Optional<DonacionDeOferta> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(DonacionDeOferta.class, id));
    }

    @Override
    public void guardar(DonacionDeOferta donacionDeOferta) {
        try {
            donacionDeOferta.setFechaUltimaModificacion(LocalDateTime.now());
            EntityManager em = entityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(donacionDeOferta);
            transaction.commit();
            System.out.println("Donación guardada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar la donación: " + e.getMessage());
            e.printStackTrace();
            throw e; // Propaga el error si es necesario
        }
    }


    @Override
    public void actualizar(DonacionDeOferta donacionDeOferta) {
        donacionDeOferta.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(donacionDeOferta);
    }

    @Override
    public void eliminar(DonacionDeOferta donacionDeOferta) {
        //BAJA LÓGICA
        donacionDeOferta.setFechaBaja(LocalDateTime.now());
        donacionDeOferta.setEstaActivo(false);
        entityManager().merge(donacionDeOferta);
    }

    @Override
    public void eliminarFisico(DonacionDeOferta donacionDeOferta) {
        entityManager().remove(donacionDeOferta);
    }
}

