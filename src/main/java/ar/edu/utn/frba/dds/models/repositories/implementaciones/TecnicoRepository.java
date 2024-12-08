package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.tecnico.Tecnico;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TecnicoRepository implements IRepository<Tecnico>, WithSimplePersistenceUnit {

    @Override
    @SuppressWarnings("unchecked")
    public List<Tecnico> buscarTodos() {
        return entityManager()
                .createQuery("from " + Tecnico.class.getName())
                .getResultList();
    }

    @Override
    public Optional<Tecnico> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(Tecnico.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<Tecnico> buscarElementosPorString(String cuil) {
        return entityManager()
                .createQuery("from " + Tecnico.class.getName() + " where cuil = :cuil")
                .setParameter("cuil", cuil)
                .getResultList();
    }

    public List<Tecnico> buscarElementosPorUsuario(Usuario user) {
        return entityManager()
                .createQuery("from " + Tecnico.class.getName() + " where usuario = :usuario")
                .setParameter("usuario", user)
                .getResultList();
    }

    @Override
    public void guardar(Tecnico tecnico) {
        tecnico.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().persist(tecnico);
    }

    @Override
    public void actualizar(Tecnico tecnico) {
        tecnico.setFechaUltimaModificacion(LocalDateTime.now());
        entityManager().merge(tecnico);
    }

    @Override
    public void eliminar(Tecnico tecnico) {
        //BAJA LÓGICA
        tecnico.setFechaBaja(LocalDateTime.now());
        tecnico.setEstaActivo(false);
        entityManager().merge(tecnico);
    }

    @Override
    public void eliminarFisico(Tecnico tecnico) {
        entityManager().remove(tecnico);
    }

}
