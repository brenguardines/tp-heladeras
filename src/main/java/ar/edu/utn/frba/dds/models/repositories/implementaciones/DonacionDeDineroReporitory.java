package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeDinero;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class DonacionDeDineroReporitory implements IRepository<DonacionDeDinero>, WithSimplePersistenceUnit {

    @Override
    @SuppressWarnings("unchecked")
    public List<DonacionDeDinero> buscarTodos() {
        return entityManager()
                .createQuery("from " + DonacionDeDinero.class.getName())
                .getResultList();
    }

    @Override
    public Optional<DonacionDeDinero> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(DonacionDeDinero.class, id));
    }

    @Override
    public void guardar(DonacionDeDinero donacionDeDinero) {
        withTransaction(() -> {
            entityManager().persist(donacionDeDinero);
            entityManager().merge(donacionDeDinero);
        });
    }

    @Override
    public void actualizar(DonacionDeDinero donacionDeDinero) {
        donacionDeDinero.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(donacionDeDinero);
    }

    @Override
    public void eliminar(DonacionDeDinero donacionDeDinero) {
        //BAJA LÓGICA
        donacionDeDinero.setFechaBaja(LocalDateTime.now());
        donacionDeDinero.setEstaActivo(false);
        entityManager().merge(donacionDeDinero);
    }

    @Override
    public void eliminarFisico(DonacionDeDinero donacionDeDinero) {
        entityManager().remove(donacionDeDinero);
    }
}

