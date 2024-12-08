package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.personaEnSituacionVulnerable.PersonaEnSituacionVulnerable;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PersonaVulnerableRepository implements IRepository<PersonaEnSituacionVulnerable>, WithSimplePersistenceUnit {

    @Override
    @SuppressWarnings("unchecked")
    public List<PersonaEnSituacionVulnerable> buscarTodos() {
        return entityManager()
                .createQuery("from " + PersonaEnSituacionVulnerable.class.getName())
                .getResultList();
    }

    @Override
    public Optional<PersonaEnSituacionVulnerable> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(PersonaEnSituacionVulnerable.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<PersonaEnSituacionVulnerable> buscarElementosPorString(String nombre) {
        return entityManager()
                .createQuery("from " + PersonaEnSituacionVulnerable.class.getName() + "where nombre = :nombre")
                .setParameter("nombre", nombre)
                .getResultList();
    }

    @Override
    public void guardar(PersonaEnSituacionVulnerable personaEnSituacionVulnerableulnerable) {
        personaEnSituacionVulnerableulnerable.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().persist(personaEnSituacionVulnerableulnerable);
    }

    @Override
    public void actualizar(PersonaEnSituacionVulnerable personaEnSituacionVulnerableulnerable) {
        personaEnSituacionVulnerableulnerable.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(personaEnSituacionVulnerableulnerable);
    }

    @Override
    public void eliminar(PersonaEnSituacionVulnerable personaEnSituacionVulnerableulnerable) {
        //BAJA LÓGICA
        personaEnSituacionVulnerableulnerable.setFechaBaja(LocalDateTime.now());
        personaEnSituacionVulnerableulnerable.setEstaActivo(false);
        entityManager().merge(personaEnSituacionVulnerableulnerable);
    }

    @Override
    public void eliminarFisico(PersonaEnSituacionVulnerable personaEnSituacionVulnerableulnerable) {
        entityManager().remove(personaEnSituacionVulnerableulnerable);
    }

}

