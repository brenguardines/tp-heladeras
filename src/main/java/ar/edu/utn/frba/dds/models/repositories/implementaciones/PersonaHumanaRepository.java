package ar.edu.utn.frba.dds.models.repositories.implementaciones;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.documento.Documento;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.tarjeta.TarjetaColaborador;
import ar.edu.utn.frba.dds.models.repositories.IRepository;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PersonaHumanaRepository implements IRepository<PersonaHumana>, WithSimplePersistenceUnit {

    @Override
    @SuppressWarnings("unchecked")
    public List<PersonaHumana> buscarTodos() {
        return entityManager()
                .createQuery("from " + PersonaHumana.class.getName())
                .getResultList();
    }

    @Override
    public Optional<PersonaHumana> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(PersonaHumana.class, id));
    }

    @SuppressWarnings("unchecked")
    public List<PersonaHumana> buscarElementosPorStringDocumento(String documento) {
        return entityManager()
                .createQuery("from " + PersonaHumana.class.getName() + "where documento = :documento")
                .setParameter("documento", documento)
                .getResultList();
    }

    public List<PersonaHumana> buscarElementosPorUsuario(Usuario user) {
        return entityManager()
                .createQuery("from " + PersonaHumana.class.getName() + " where usuario = :usuario")
                .setParameter("usuario", user)
                .getResultList();
    }


    @Override
    public void guardar(PersonaHumana personaHumana) {
        personaHumana.setFechaDeAlta(LocalDateTime.now());
        personaHumana.setEstaActivo(true);
        withTransaction(() -> {
            personaHumana.setFechaUltimaModificacion(LocalDateTime.now());
            entityManager().merge(personaHumana);
        });

    }

    @Override
    public void actualizar(PersonaHumana personaHumana /*, PersonaHumana personaHumanaModificada*/) {
        withTransaction(() -> {
            personaHumana.setFechaUltimaModificacion(LocalDateTime.now());
            entityManager().merge(personaHumana);
        });
    }

    @Override
    public void eliminar(PersonaHumana personaHumana) {
        //BAJA LÓGICA
        withTransaction(() -> {
            personaHumana.setFechaBaja(LocalDateTime.now());
            personaHumana.setEstaActivo(false);
            entityManager().merge(personaHumana);
        });
    }

    @Override
    public void eliminarFisico(PersonaHumana personaHumana) {
        withTransaction(() -> {
            entityManager().remove(personaHumana);
        });
    }

    // TODO: Ver si se implementan en otro repository

    public List<PersonaHumana> buscarDonacionYDistribucionDeViandasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        return null; //this.personasHumanas.stream()
                                  // .filter(persona -> !persona.getDonacionesDeViandasEntreFechas(inicio, fin).isEmpty()
        //       || !persona.getDistribucionesDeViandasEntreFechas(inicio, fin).isEmpty())
          //                         .collect(Collectors.toList());
    }

    public TarjetaColaborador buscarTarjetaPorId(Integer id) {
        return null; //this.personasHumanas.stream()
                       //            .map(PersonaHumana::getTarjetaColaborador)
                         //          .filter(tarjeta -> tarjeta.getCodigo().equals(id.toString()))
                           //        .findFirst()
                             //      .orElse(null);
    }
}
