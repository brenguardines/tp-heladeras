package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.oferta.Oferta;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class OfertaRepository implements IRepository<Oferta>, WithSimplePersistenceUnit {

    @SuppressWarnings("unchecked")
    @Override
    public List<Oferta> buscarTodos() {
        return entityManager()
                .createQuery("from " + Oferta.class.getName())
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<Oferta> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(Oferta.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<Oferta> buscarElementosPorString(String nombre) {
        return entityManager()
                .createQuery("from " + Oferta.class.getName() + " where nombre = :name")
                .setParameter("name", nombre)
                .getResultList();
    }

    @Override
    public void guardar(Oferta oferta) {
        withTransaction(()->{
            entityManager().persist(oferta);
        });

    }

    @Override
    public void actualizar(Oferta oferta) {
        oferta.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(oferta);
    }

    @Override
    public void eliminar(Oferta oferta) {
        //BAJA LÓGICA
        oferta.setFechaBaja(LocalDateTime.now());
        oferta.setEstaActivo(false);
        entityManager().merge(oferta);
    }

    @Override
    public void eliminarFisico(Oferta oferta) {
        entityManager().remove(oferta);
    }

}
