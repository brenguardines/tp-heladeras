package ar.edu.utn.frba.dds.controllers.colaboraciones;

import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.controllers.ICrudViewsHandler;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.NombreYApellido;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.documento.Documento;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.contribuciones.RegistroDePersonasEnSituacionVulnerable;
import ar.edu.utn.frba.dds.models.entities.direccion.Calle;
import ar.edu.utn.frba.dds.models.entities.direccion.Direccion;
import ar.edu.utn.frba.dds.models.entities.personaEnSituacionVulnerable.MenoresACargoDePersonaEnSituacionVulnerable;
import ar.edu.utn.frba.dds.models.entities.personaEnSituacionVulnerable.PersonaEnSituacionVulnerable;
import ar.edu.utn.frba.dds.models.entities.tarjeta.TarjetaVulnerable;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.*;
import ar.edu.utn.frba.dds.service.excepciones.TarjetaYaEstaEnUsoException;
import io.javalin.http.Context;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PersonaVulnerableController implements ICrudViewsHandler {
    private PersonaVulnerableRepository repositorioDePersonasVulnerable;
    private RegistroDePersonaVulnerableRepository registroDePersonaVulnerableRepository;

    public PersonaVulnerableController(PersonaVulnerableRepository repositorioDePersonasVulnerable, RegistroDePersonaVulnerableRepository registroDePersonaVulnerableRepository) {
        this.repositorioDePersonasVulnerable = repositorioDePersonasVulnerable;
        this.registroDePersonaVulnerableRepository = registroDePersonaVulnerableRepository;
    }

    @Override
    public void index(Context context) {
        context.result("sdada");
    }

    @Override
    public void show(Context context) {

    }

    @Override
    public void create(Context context) {
        //pretende devolver una vista que contenga un formulario para crear un colaborador humano nuevo
        Map<String, Object> model=new HashMap<>();
        model.put("titulo", "Registro de Personas Vulnerables");
        model.put("esColaboradorHumano", true);
        context.render("/colaboraciones/registroDePersonasVulnerables.hbs", model);
    }

    public void save(Context context) {
        PersonaEnSituacionVulnerable personaVulnerable = this.generarPersonaVulnerableDesdeContexto(context);

        this.repositorioDePersonasVulnerable.guardar(personaVulnerable);

        RegistroDePersonasEnSituacionVulnerable registro =
                RegistroDePersonasEnSituacionVulnerable.builder()
                        .colaborador(personaVulnerable.getColaboradorQueLoRegistro())
                        .personaEnSituacionVulnerable(personaVulnerable)
                        .tarjeta(personaVulnerable.getTarjeta())
                        .fechaDeColaboracion(LocalDate.now()).build();
        this.registroDePersonaVulnerableRepository.guardar(registro);

        context.redirect("/colaboracionExitosaHumana");
    }

    @Override
    public void edit(Context context) {
        /* // TODO hace falta? MNo se me ocurre como, me trabo
        PersonaHumana nuevaPersonaHumana = PersonaHumanFactory.create(NombreYApellido.of(context.formParam("nombre"), context.formParam("apellido")),
                new MedioDeContacto(TipoDeMedioDeContacto.valueOf(context.formParam("tipoMedioDeContacto")), context.formParam("contacto")),
                new Documento(), LocalDate.parse(context.formParam("fechaDeNacimiento")));

        Long id = Long.parseLong(context.formParam("id"));

        if (this.repositorioDePersonasHumanas.buscarPorId(id).isPresent()) {
            this.repositorioDePersonasHumanas.actualizar(nuevaPersonaHumana);
        }
        else {
            context.result("NO SE ENCONTRÓ AL USUARIO");
        }

         */
    }

    @Override
    public void update(Context context) {

        /*PersonaEnSituacionVulnerable personaVulnerableModificada = this.generarPersonaVulnerableDesdeContexto(context);

        this.repositorioDePersonasVulnerable.actualizar(personaVulnerableModificada);*/
    }

    @Override
    public void delete(Context context) {
        /*PersonaEnSituacionVulnerable personaVulnerable = this.repositorioDePersonasVulnerable.buscarPorId(Long.getLong(context.formParam("id"))).get();

        this.repositorioDePersonasVulnerable.eliminar(personaVulnerable); // le pongo baja logica, no fisica para tener forma de recuperación en caso de error */
    }

    protected PersonaEnSituacionVulnerable generarPersonaVulnerableDesdeContexto(Context context) {
        //TarjetaVulnerableRepository tarjetaVulnerableRepository = ServiceLocator.instanceOf(TarjetaVulnerableRepository.class);
        PersonaHumanaRepository personaHumanaRepository = ServiceLocator.instanceOf(PersonaHumanaRepository.class);

        PersonaHumana personaHumana = personaHumanaRepository.buscarPorId(context.sessionAttribute("idColaboradorHumano")).get();

        TarjetaVulnerable tarjeta = TarjetaVulnerable.builder().estaEnUso(Boolean.TRUE).codigo(context.sessionAttribute("idColaboradorHumano").toString()).build();

        PersonaEnSituacionVulnerable personaVulnerable = PersonaEnSituacionVulnerable.builder()
                .nombreYApellido(NombreYApellido.of(context.formParam("nombre"), context.formParam("apellido")))
                .fechaDeNacimiento(LocalDate.parse(context.formParam("fechaDeNacimiento")))
                .colaboradorQueLoRegistro(personaHumana)
                .direccion(Direccion.of(new Calle(context.formParam("calle")), context.formParam("altura"), context.formParam("codigoPostal")))
                .tarjeta(tarjeta)
                .build();

        if (!context.formParam("cantidad").isEmpty()){
            personaVulnerable.setCantHijos(Integer.parseInt(context.formParam("cantidad")));
        }else {
            personaVulnerable.setCantHijos(0);
        }
        if (!context.formParam("tipoDocumento").isEmpty()){
            personaVulnerable.setDocumento(Documento.of(context.formParam("tipoDocumento"), context.formParam("dni")));
        }
        /*if (!tarjeta.getEstaEnUso()) {
            personaVulnerable.setTarjeta(tarjeta);
        }
        else {
            throw new TarjetaYaEstaEnUsoException("La tarjeta ya está en uso.");
        }*/

        /* // TODO: REVISAR COMO HACEMOS EL TEMA DEL FORMS DE LOS MENORES
        if (!context.formParam("menoresACargo").isBlank()) {
            String[] menoresACargo = context.formParam("menoresACargo").split(",");

            for (String menorACargo : menoresACargo) {
                MenoresACargoDePersonaEnSituacionVulnerable menor = MenoresACargoDePersonaEnSituacionVulnerable.builder()
                       .nombreYApellido(NombreYApellido.of(menorACargo.split(" ")[0], menorACargo.split(" ")[1]))
                       .build();

                personaVulnerable.agregarMenor(menor);
            }
        }
        */

        return personaVulnerable;
    }
}
