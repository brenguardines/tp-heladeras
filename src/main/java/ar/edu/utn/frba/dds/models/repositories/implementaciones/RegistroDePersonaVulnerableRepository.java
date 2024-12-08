package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.contribuciones.RegistroDePersonasEnSituacionVulnerable;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class RegistroDePersonaVulnerableRepository implements IRepository<RegistroDePersonasEnSituacionVulnerable>, WithSimplePersistenceUnit {

    @Override
    @SuppressWarnings("unchecked")
    public List<RegistroDePersonasEnSituacionVulnerable> buscarTodos() {
        return entityManager()
                .createQuery("from " + RegistroDePersonasEnSituacionVulnerable.class.getName())
                .getResultList();
    }

    @Override
    public Optional<RegistroDePersonasEnSituacionVulnerable> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(RegistroDePersonasEnSituacionVulnerable.class, id));
    }

    @Override
    public void guardar(RegistroDePersonasEnSituacionVulnerable registroDePersonasEnSituacionVulnerable) {
        withTransaction(() -> {
            entityManager().persist(registroDePersonasEnSituacionVulnerable);
        });
    }

    @Override
    public void actualizar(RegistroDePersonasEnSituacionVulnerable registroDePersonasEnSituacionVulnerable) {
        registroDePersonasEnSituacionVulnerable.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(registroDePersonasEnSituacionVulnerable);
    }

    @Override
    public void eliminar(RegistroDePersonasEnSituacionVulnerable registroDePersonasEnSituacionVulnerable) {
        //BAJA LÓGICA
        registroDePersonasEnSituacionVulnerable.setFechaBaja(LocalDateTime.now());
        registroDePersonasEnSituacionVulnerable.setEstaActivo(false);
        entityManager().merge(registroDePersonasEnSituacionVulnerable);
    }

    @Override
    public void eliminarFisico(RegistroDePersonasEnSituacionVulnerable registroDePersonasEnSituacionVulnerable) {
        entityManager().remove(registroDePersonasEnSituacionVulnerable);
    }
}