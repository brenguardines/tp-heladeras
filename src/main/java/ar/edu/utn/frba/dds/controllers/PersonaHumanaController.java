package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.NombreYApellido;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.documento.Documento;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.direccion.Calle;
import ar.edu.utn.frba.dds.models.entities.direccion.Direccion;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.heladera.utilidades.ModeloHeladera;
import ar.edu.utn.frba.dds.models.entities.incidentes.FallaTecnica;
import ar.edu.utn.frba.dds.models.entities.oferta.Canje;
import ar.edu.utn.frba.dds.models.entities.oferta.Oferta;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.*;
import ar.edu.utn.frba.dds.models.usuario.Contrasenia;
import ar.edu.utn.frba.dds.models.usuario.RolDeUsuario;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import ar.edu.utn.frba.dds.utils.Factories.FallaTecnicaFactory;
import ar.edu.utn.frba.dds.utils.validadorDeContrasenias.ValidadorDeContrasenias;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.apache.maven.model.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class PersonaHumanaController implements ICrudViewsHandler {
    private PersonaHumanaRepository repositorioDePersonasHumanas;
    private ValidadorDeContrasenias validadorDeContrasenias;
    private UsuarioRepository repositorioDeUsuarios;
    private OfertaRepository repositorioDeOfertas;
    private HeladeraRepository heladeraRepository;

    public PersonaHumanaController(PersonaHumanaRepository repositorioDePersonasHumanas, ValidadorDeContrasenias validadorDeContrasenias,
                                   UsuarioRepository repositorioDeUsuarios, OfertaRepository repositorioDeOfertas) {
        this.repositorioDePersonasHumanas = repositorioDePersonasHumanas;
        this.validadorDeContrasenias = validadorDeContrasenias;
        this.repositorioDeUsuarios = repositorioDeUsuarios;
        this.repositorioDeOfertas = repositorioDeOfertas;
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
        model.put("titulo", "Registro de Colaboradores Humanos");
        context.render("colaboradores/registroPersonaHumana.hbs", model);

    }

    public void save(Context context) {
        Contrasenia contraseniaDeUsuario =Contrasenia.builder().contrasenia(context.formParam("contrasenia")).fechaDeCreacionDeContrasenia(LocalDateTime.now()).build();
        Map model = new HashMap<>();
        model.put("contra",context.formParam("contrasenia"));
        model.put("contraRepetida",context.formParam("contraseniaRepetida"));
        model.put("nombre",context.formParam("nombre"));
        model.put("apellido",context.formParam("apellido"));
        model.put("nacimiento",context.formParam("fechaDeNacimiento"));
        model.put("calle",context.formParam("calle"));
        model.put("altura",context.formParam("altura"));
        model.put("codigoPostal",context.formParam("codigoPostal"));
        model.put("usuario",context.formParam("usuario"));
        model.put("documento",context.formParam("numeroDeDocumento"));
        model.put("contacto",context.formParam("contacto"));
        model.put("tipoContacto", context.formParam("tipoMedioDeContacto"));
        model.put("tipoDocumento", context.formParam("tipoDocumento"));

        List<Usuario> usuariosDB = repositorioDeUsuarios.buscarPorString(context.formParam("usuario"));

        PersonaHumana.PersonaHumanaBuilder personaHumana= PersonaHumana.
                builder().
                nombreYApellido(NombreYApellido.of(context.formParam("nombre"), context.formParam("apellido"))).
                documento(Documento.of(context.formParam("tipoDocumento"), context.formParam("numeroDeDocumento"))).
                fechaDeNacimiento(LocalDate.parse(context.formParam("fechaDeNacimiento"))).
                direccion(Direccion.of(new Calle(context.formParam("calle")), context.formParam("altura"), context.formParam("codigoPostal")));

        if (!usuariosDB.isEmpty()){
            model.put("errorUsuario","El nombre de usuario no está disponible");
            context.render("colaboradores/registroPersonaHumana.hbs", model);
        }else {
            if(validadorDeContrasenias.contraseniaValida(contraseniaDeUsuario)){
                Usuario usuario = Usuario.builder()
                        .nombreDeUsuario(context.formParam("usuario"))
                        .rol(RolDeUsuario.COLABORADOR_HUMANO)
                        .contrasenia(contraseniaDeUsuario).build();
                this.repositorioDeUsuarios.guardar(usuario);
                personaHumana.usuario(usuario);
                this.repositorioDePersonasHumanas.guardar(personaHumana.build());

                context.redirect("/registroExitoso");
            }else {
                model.put("errorContra","Las Contraseña no cumple con los requisitos de complejidad requeridos");
                context.render("colaboradores/registroPersonaHumana.hbs", model);
            }
        }
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

    }

    @Override
    public void delete(Context context) {

    }

    public void suscripcionHeladera(Context context) {
        // TODO
    }

    public void reportarFalla(Context context) {
        FallaTecnica fallaTecnica = null;
        String descripcion = context.formParam("descripcion");
        Heladera heladera = heladeraRepository.buscarPorId(Long.getLong(context.formParam("heladera"))).get();
        PersonaHumana persona = repositorioDePersonasHumanas.buscarPorId(Long.getLong(context.formParam("persona"))).get();

        if (context.body().contains("foto")) {
            fallaTecnica = FallaTecnicaFactory.create(descripcion, heladera, persona, context.formParam("foto"));

        }
        else{
            fallaTecnica = FallaTecnicaFactory.create(descripcion, heladera, persona);
        }

        heladera.reportarFallaTecnica(fallaTecnica);
    }

    public void canjePuntos2(Context context) { //TODO ubicar en el router
        Map<String, Object> model=new HashMap<>();
        model.put("titulo", "Canje de puntos");
        model.put("ofertas", repositorioDeOfertas.buscarTodos());
        model.put("esColaboradorHumano",true);
        PersonaHumana personaHumana = repositorioDePersonasHumanas.buscarPorId(context.sessionAttribute("idColaboradorHumano")).get();
        Double puntos = personaHumana.puntosObtenidos() - personaHumana.puntosYaCanjeados();
        model.put("puntos", puntos);
        context.render("puntos/canjeDePuntos.hbs", model);
    }

    public void canjePuntos(Context context) {
        Map<String, Object> model = new HashMap<>();
        model.put("titulo", "Canje de puntos");
        model.put("ofertas", repositorioDeOfertas.buscarTodos());
        model.put("esColaboradorHumano", true);

        PersonaHumana personaHumana = repositorioDePersonasHumanas.buscarPorId(context.sessionAttribute("idColaboradorHumano"))
            .orElseThrow(() -> new IllegalArgumentException("El colaborador humano no existe"));

        Double puntosDisponibles = personaHumana.puntosObtenidos() - personaHumana.puntosYaCanjeados();
        model.put("puntos", puntosDisponibles);

        context.render("puntos/canjeDePuntos.hbs", model);
    }


    public void canjearOferta2(Context context){
        Long idOferta = Long.parseLong(context.formParam("id"));
        Oferta oferta = repositorioDeOfertas.buscarPorId(idOferta).get();

        //String nombre= repositorioDeOfertas.buscarPorId(idOferta).get().getNombre();
        //String descripcion= repositorioDeOfertas.buscarPorId(idOferta).get().getBeneficio().getDescripcion();
        //Double puntos = repositorioDeOfertas.buscarPorId(idOferta).get().getPuntosNecesariosParaAccederAlBeneficio();

        PersonaHumana personaHumana = repositorioDePersonasHumanas.buscarPorId(context.sessionAttribute("idColaboradorHumano")).get();
        System.out.println(personaHumana.getNombreYApellido().getNombre());
        personaHumana.canjearPuntos(oferta);



    }

    public void canjearOferta(Context context) {
        Long idOferta = Long.parseLong(context.formParam("id"));
        Oferta oferta = this.repositorioDeOfertas.buscarPorId(idOferta)
            .orElseThrow(() -> new IllegalArgumentException("La oferta no existe"));

        PersonaHumana personaHumana = this.repositorioDePersonasHumanas.buscarPorId(context.sessionAttribute("idColaboradorHumano"))
            .orElseThrow(() -> new IllegalArgumentException("El colaborador humano no existe"));

        Double puntosDisponibles = personaHumana.puntosObtenidos() - personaHumana.puntosYaCanjeados();

        if (puntosDisponibles >= oferta.getPuntosNecesariosParaAccederAlBeneficio()) {
            Canje nuevoCanje = new Canje(oferta);
            personaHumana.getCanjes().add(nuevoCanje);
            this.repositorioDePersonasHumanas.actualizar(personaHumana);

            context.redirect("/canjeoExitoso");
        } else {
            context.redirect("/puntosInsuficientes");
        }
    }

    public void canjesRealizados(Context context) {
        PersonaHumana personaHumana = repositorioDePersonasHumanas.buscarPorId(context.sessionAttribute("idColaboradorHumano"))
            .orElseThrow(() -> new IllegalArgumentException("El colaborador humano no existe"));

        Map<String, Object> model = new HashMap<>();

        if (personaHumana.getCanjes().isEmpty()) {
            context.redirect("/noHayCanjesRealizados");
        }

        model.put("canjes", personaHumana.getCanjes());
        context.render("/personaHumana/canjesRealizados", model);
    }

}
