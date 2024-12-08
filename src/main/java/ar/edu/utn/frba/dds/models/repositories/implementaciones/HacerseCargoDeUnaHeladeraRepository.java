package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.contribuciones.HacerseCargoDeUnaHeladera;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class HacerseCargoDeUnaHeladeraRepository implements IRepository<HacerseCargoDeUnaHeladera>, WithSimplePersistenceUnit {

    @Override
    @SuppressWarnings("unchecked")
    public List<HacerseCargoDeUnaHeladera> buscarTodos() {
        return entityManager()
                .createQuery("from " + HacerseCargoDeUnaHeladera.class.getName())
                .getResultList();
    }

    @Override
    public Optional<HacerseCargoDeUnaHeladera> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(HacerseCargoDeUnaHeladera.class, id));
    }

    @Override
    public void guardar(HacerseCargoDeUnaHeladera hacerseCargoDeUnaHeladera) {
        withTransaction(() -> {
            entityManager().persist(hacerseCargoDeUnaHeladera);
        });
    }

    @Override
    public void actualizar(HacerseCargoDeUnaHeladera hacerseCargoDeUnaHeladera) {
        hacerseCargoDeUnaHeladera.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(hacerseCargoDeUnaHeladera);
    }

    @Override
    public void eliminar(HacerseCargoDeUnaHeladera hacerseCargoDeUnaHeladera) {
        //BAJA LÓGICA
        hacerseCargoDeUnaHeladera.setFechaBaja(LocalDateTime.now());
        hacerseCargoDeUnaHeladera.setEstaActivo(false);
        entityManager().merge(hacerseCargoDeUnaHeladera);
    }

    @Override
    public void eliminarFisico(HacerseCargoDeUnaHeladera hacerseCargoDeUnaHeladera) {
        entityManager().remove(hacerseCargoDeUnaHeladera);
    }
}

