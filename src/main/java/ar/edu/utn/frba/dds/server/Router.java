package ar.edu.utn.frba.dds.server;

import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.controllers.*;
import ar.edu.utn.frba.dds.controllers.colaboraciones.*;
import ar.edu.utn.frba.dds.controllers.incidentes.IncidenteController;
import ar.edu.utn.frba.dds.models.entities.direccion.Coordenada;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.oferta.Canje;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;
import ar.edu.utn.frba.dds.models.usuario.RolDeUsuario;
import io.javalin.Javalin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Router {
    public static void init(Javalin app) {
        /*EJEMPLOS
        app.get("/prueba", ctx -> ctx.result("Hola mundo!"));

        //Query Params
        app.get("/saludo", ctx -> {
            ctx.result("Hola " + ctx.queryParam("nombre") + " " + ctx.queryParam("apellido"));
        });

        //Route params | Path params
        app.get("/saludo-para/{nombre}", ctx -> ctx.result("Hola " + ctx.pathParam("nombre")));
        */
        // abrir el index
        //app.get("", ctx -> ctx.render("colaboradores/edicionHumana.hbs"));

        app.get("", ctx -> ctx.render("indexYLogin/index.hbs"));

        // manejar el login
        app.get("/login", ctx ->ctx.render("indexYLogin/login.hbs"));
        app.post("/login", ServiceLocator.instanceOf(AuthController.class)::login);

        //registrar a un nuevo colaborador humano
        app.get("/personaHumana/register", ServiceLocator.instanceOf(PersonaHumanaController.class)::create);
        app.post("/personaHumana", ServiceLocator.instanceOf(PersonaHumanaController.class)::save);

        //registrar a un nuevo colaborador juridico
        app.get("/personaJuridica/register", ServiceLocator.instanceOf(PersonaJuridicaController.class)::create);
        app.post("/personaJuridica", ServiceLocator.instanceOf(PersonaJuridicaController.class)::save);

        app.get("/registroExitoso", ctx -> ctx.render("/mensajes/exitos/registroExitoso.hbs"));

        // canje
        app.get("/canjeDePuntos", ServiceLocator.instanceOf(PersonaHumanaController.class)::canjePuntos);


        app.post("/canjearOferta", ServiceLocator.instanceOf(PersonaHumanaController.class)::canjearOferta);

        //suscribirse a una heladera
        app.get("/heladera/suscribirse/{id}", ServiceLocator.instanceOf(PersonaHumanaController.class)::suscripcionHeladera);

        //reportar falla en una heladera
        app.get("/heladera/reportarFalla/{id}", ServiceLocator.instanceOf(PersonaHumanaController.class)::reportarFalla);

        //vista de selección del tipo de persona a la hora de registrarse
        app.get("/tipoDeColaborador", ctx -> ctx.render("/colaboradores/tipoDePersonaParaRegistro.hbs"));

        // Mapa de heladeras
        app.get("/mapaDeHeladeras",ctx -> ctx.render("mapa/mapaHeladeras.hbs"));


        // TODO: GENERAR LOS CONTROLLERS

        // MENU ADMINISTRADOR --------------------------------------------------------------------------------------------------------
        app.get("/menuAdmin", ctx -> {
                    Map model = new HashMap<>();
                    model.put("esAdministrador",true);
                    ctx.render("/accionesAdministrador/menuAdmin.hbs", model);},
                RolDeUsuario.ADMINISTRADOR);

        // FORMAS DE CONTRIBUCIÓN --------------------------------------------------------------------------------------------------------
        // forma juridica
        app.get("/formaDeContribucionJuridica", ctx -> {
                    Map model = new HashMap<>();
                    model.put("esColaboradorJuridico",true);
                    ctx.render("/colaboraciones/formasDeContribucion/formaDeContribucionJuridica.hbs", model);},
                RolDeUsuario.COLABORADOR_JURIDICO);

        // forma humana
        app.get("/formaDeContribucionHumana", ctx -> {
                    Map model = new HashMap<>();
                    model.put("esColaboradorHumano",true);
                    ctx.render("/colaboraciones/formasDeContribucion/formaDeContribucionHumana.hbs", model);},
                RolDeUsuario.COLABORADOR_HUMANO);

        // donar una oferta
        app.get("/colaboraciones/donarOferta", ServiceLocator.instanceOf(DonacionDeOfertaController.class)::create, RolDeUsuario.COLABORADOR_JURIDICO);
        app.post("/colaboraciones/donarOferta", ServiceLocator.instanceOf(DonacionDeOfertaController.class)::save, RolDeUsuario.COLABORADOR_JURIDICO);

        // donar Viandas
        app.get("/colaboraciones/donarViandas", ServiceLocator.instanceOf(DonacionDeViandaController.class)::create, RolDeUsuario.COLABORADOR_HUMANO);
        app.post("/colaboraciones/donarViandas", ServiceLocator.instanceOf(DonacionDeViandaController.class)::save, RolDeUsuario.COLABORADOR_HUMANO);

        // donar dinero
        app.get("/colaboraciones/donarDinero", ServiceLocator.instanceOf(DonacionDeDineroController.class)::create, RolDeUsuario.COLABORADOR_JURIDICO, RolDeUsuario.COLABORADOR_HUMANO);
        app.post("/colaboraciones/donarDinero", ServiceLocator.instanceOf(DonacionDeDineroController.class)::save, RolDeUsuario.COLABORADOR_JURIDICO, RolDeUsuario.COLABORADOR_HUMANO);

        // distribuir Viandas
        app.get("/colaboraciones/distribuirViandas", ServiceLocator.instanceOf(DistribucionDeViandaController.class)::create, RolDeUsuario.COLABORADOR_HUMANO);
        app.post("/colaboraciones/distribuirViandas", ServiceLocator.instanceOf(DistribucionDeViandaController.class)::save, RolDeUsuario.COLABORADOR_HUMANO);

        // registrar persona vulnerable
        app.get("/colaboraciones/registrarPersona", ServiceLocator.instanceOf(PersonaVulnerableController.class)::create, RolDeUsuario.COLABORADOR_HUMANO);
        app.post("/colaboraciones/registrarPersona", ServiceLocator.instanceOf(PersonaVulnerableController.class)::save, RolDeUsuario.COLABORADOR_HUMANO);

        // hacerce cargo de una heladera
        app.get("/colaboraciones/hacerCargoDeUnaHeladera", ServiceLocator.instanceOf(HacerceCargoDeUnaHeladeraController.class)::create, RolDeUsuario.COLABORADOR_JURIDICO);
        app.post("/colaboraciones/hacerCargoDeUnaHeladera", ServiceLocator.instanceOf(HacerceCargoDeUnaHeladeraController.class)::save, RolDeUsuario.COLABORADOR_JURIDICO);

        app.get("/personaHumana/canjesRealizados", ServiceLocator.instanceOf(PersonaHumanaController.class)::canjesRealizados);


        // carga CSV
        app.get("/menuAdmin/cargaCSV", ctx -> {
            Map model = new HashMap<>();
            model.put("esAdministrador",true);
            ctx.render("/accionesAdministrador/cargaArchivoCSV.hbs", model);
        });
        app.post("/menuAdmin/cargaCSV", ServiceLocator.instanceOf(AdminController.class)::cargarCSV);
        app.get("/colaboracionExitosaHumana", ctx -> ctx.render("/mensajes/exitos/colaboracionExitosaHumana.hbs"), RolDeUsuario.COLABORADOR_HUMANO);
        app.get("/colaboracionExitosaJuridica", ctx -> ctx.render("/mensajes/exitos/colaboracionExitosaJuridica.hbs"), RolDeUsuario.COLABORADOR_JURIDICO);

        //visualizacion de alertas, fallas y reportes
        app.get("/alertas", ctx -> ctx.render("/incidentes/visualizacionAlertas.hbs"));
        app.get("/fallas", ctx -> ctx.render("/incidentes/reporteFallas.hbs"));
        app.get("/reportes", ctx -> ctx.render("/incidentes/visualizacionReportes.hbs"));

        // gestion de usuarios, heladeras y personas vulnerables
        app.get("/gestionPersonasVulnerables", ctx -> ctx.render("/accionesAdministrador/gestionarPersonasVulnerables.hbs"));
        app.get("/administracionPersonasVulnerablesExistentes", ctx -> ctx.render("/accionesAdministrador/administrarPersonasVulnerablesExistentes.hbs"));
        // editar personas vulnerables
        app.post("/gestionPersonasVulnerables/update", ServiceLocator.instanceOf(PersonaVulnerableController.class)::update);
        // borrar personas vulnerables
        app.post("/gestionPersonasVulnerables/delete", ServiceLocator.instanceOf(PersonaVulnerableController.class)::delete);

        app.get("/gestionUsuario", ctx -> ctx.render("/accionesAdministrador/gestionarUsuarios.hbs"));
        app.get("/administracionHumanosExistentes", ServiceLocator.instanceOf(AdminController.class)::gestionarPersonas);
        app.post("/gestionUsuarios/update", ServiceLocator.instanceOf(PersonaHumanaController.class)::update);
        app.post("/gestionUsuarios/delete", ServiceLocator.instanceOf(PersonaHumanaController.class)::delete);

        app.get("/gestionHeladeras", ctx -> ctx.render("/accionesAdministrador/gestionarHeladeras.hbs"));
        app.get("/administracionHeladerasExistentes", ctx -> ctx.render("/accionesAdministrador/administrarHeladerasExistentes.hbs"));
        //app.post("/gestionHeladeras/update", ServiceLocator.instanceOf(.class)::update);
        //app.post("/gestionHeladeras/delete", ServiceLocator.instanceOf(PersonaHumanaController.class)::delete);

        // Mapa de heladeras
        app.get("/mapaHeladeras", ctx -> {
            List<Heladera> heladeras = ServiceLocator.instanceOf(HeladeraRepository.class).buscarHeladerasActivas();
            List<Coordenada> coordenadas = heladeras.stream().map(Heladera::getCoordenada) // Extrae la coordenada de cada heladera
                    .collect(Collectors.toList()); // Recoge los resultados en una lista

            // Convertir las coordenadas a formato adecuado para JavaScript (números)
            List<Map<String, Double>> coordenadasJavaScript = coordenadas.stream()
                    .map(c -> {
                        Map<String, Double> coordMap = new HashMap<>();
                        coordMap.put("lat", Double.parseDouble(c.getLatitud()));
                        coordMap.put("lng", Double.parseDouble(c.getLongitud()));
                        return coordMap;
                    })
                    .collect(Collectors.toList());

            Map<String, Object> model = new HashMap<>();
            model.put("coordenadas", coordenadasJavaScript);

            ctx.render("/mapa/mapaHeladeras.hbs", model);
        });

        // MENSAJES --------------------------------------------------------------------------------------------------------
        app.get("/canjeoExitoso", ctx -> ctx.render("/mensajes/exitos/canjeoExitoso.hbs"));

        app.get("/colaboracionFallida", ctx -> ctx.render("/mensajes/errores/colaboracionFallida.hbs"));

        app.get("/reporteExitoso", ctx -> ctx.render("/mensajes/exitos/reporteExitoso.hbs"));

        app.get("/puntosInsuficientes", ctx -> ctx.render("/mensajes/errores/puntosInsuficientes.hbs"));

        app.get("/suscripcionExitosa", ctx -> ctx.render("/mensajes/exitos/suscripcionExitosa.hbs"));

        app.get("/cargando", ctx -> ctx.render("/mensajes/cargando.hbs"));

        app.get("/noHayCanjesRealizados", ctx -> ctx.render("/mensajes/errores/noHayCanjesRealizados.hbs"));

        // MENU TECNICO --------------------------------------------------------------------------------------------------------
        app.get("/menuTecnico", ctx -> {
                    Map model = new HashMap<>();
                    model.put("esTecnico",true);
                    ctx.render("/tecnico/menuTecnico.hbs", model);},
                RolDeUsuario.TECNICO);

        app.get("/tecnico/solucionarIncidente", ServiceLocator.instanceOf(IncidenteController.class)::solucionar, RolDeUsuario.TECNICO);

    }
}
