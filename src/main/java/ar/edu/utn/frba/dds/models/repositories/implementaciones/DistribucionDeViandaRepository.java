package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.contribuciones.DistribucionDeViandas;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class DistribucionDeViandaRepository implements IRepository<DistribucionDeViandas>, WithSimplePersistenceUnit {

    @Override
    @SuppressWarnings("unchecked")
    public List<DistribucionDeViandas> buscarTodos() {
        return entityManager()
                .createQuery("from " + DistribucionDeViandas.class.getName())
                .getResultList();
    }

    @Override
    public Optional<DistribucionDeViandas> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(DistribucionDeViandas.class, id));
    }

    @Override
    public void guardar(DistribucionDeViandas distribucionDeViandas) {
        distribucionDeViandas.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().persist(distribucionDeViandas);
    }

    @Override
    public void actualizar(DistribucionDeViandas distribucionDeViandas) {
        distribucionDeViandas.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(distribucionDeViandas);
    }

    @Override
    public void eliminar(DistribucionDeViandas distribucionDeViandas) {
        //BAJA LÓGICA
        distribucionDeViandas.setFechaBaja(LocalDateTime.now());
        distribucionDeViandas.setEstaActivo(false);
        entityManager().merge(distribucionDeViandas);
    }

    @Override
    public void eliminarFisico(DistribucionDeViandas distribucionDeViandas) {
        entityManager().remove(distribucionDeViandas);
    }

}
