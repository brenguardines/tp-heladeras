package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PersonaJuridicaRepository implements IRepository<PersonaJuridica>, WithSimplePersistenceUnit {

    @Override
    @SuppressWarnings("unchecked")
    public List<PersonaJuridica> buscarTodos() {
        return entityManager()
                .createQuery("from " + PersonaJuridica.class.getName())
                .getResultList();
    }

    @Override
    public Optional<PersonaJuridica> buscarPorId(Long id) {
        PersonaJuridica resultado = entityManager().find(PersonaJuridica.class, id);
        System.out.println("Resultado de la búsqueda por ID: " + resultado);
        return Optional.ofNullable(resultado);
    }

    @SuppressWarnings("unchecked")
    public List<PersonaJuridica> buscarElementosPorStringRazonSocial(String razonSocial) {
        return entityManager()
                .createQuery("from " + PersonaJuridica.class.getName() + "where razonSocial = :razonSocial")
                .setParameter("razonSocial", razonSocial)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<PersonaJuridica> buscarElementosPorUsuario(Usuario user) {
        return entityManager()
                .createQuery("from " + PersonaJuridica.class.getName() + " where usuario = :usuario")
                .setParameter("usuario", user)
                .getResultList();
    }

    @Override
    public void guardar(PersonaJuridica personaJuridica) {
        withTransaction(() -> {
            entityManager().persist(personaJuridica);
        });

    }

    @Override
    public void actualizar(PersonaJuridica personaJuridica) {
        personaJuridica.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(personaJuridica);
    }

    @Override
    public void eliminar(PersonaJuridica personaJuridica) {
        //BAJA LÓGICA
        personaJuridica.setFechaBaja(LocalDateTime.now());
        personaJuridica.setEstaActivo(false);
        entityManager().merge(personaJuridica);
    }

    @Override
    public void eliminarFisico(PersonaJuridica personaJuridica) {
        entityManager().remove(personaJuridica);
    }

}
