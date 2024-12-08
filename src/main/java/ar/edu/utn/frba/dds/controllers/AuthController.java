package ar.edu.utn.frba.dds.controllers;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.tecnico.Tecnico;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.PersonaHumanaRepository;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.PersonaJuridicaRepository;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.TecnicoRepository;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.UsuarioRepository;
import ar.edu.utn.frba.dds.models.usuario.RolDeUsuario;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import io.javalin.http.Context;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.eclipse.jetty.webapp.MetaData.Complete.True;

public class AuthController{
    private UsuarioRepository usuarioRepository;
    private PersonaHumanaRepository personaHumanaRepository;
    private PersonaJuridicaRepository personaJuridicaRepository;
    private TecnicoRepository tecnicoRepository;

    public AuthController(UsuarioRepository repoUsuarios, PersonaHumanaRepository repoPersonaHumana, PersonaJuridicaRepository repoPersonaJuridica, TecnicoRepository repoTecnico ) {
        this.usuarioRepository = repoUsuarios;
        this.personaHumanaRepository = repoPersonaHumana;
        this.personaJuridicaRepository = repoPersonaJuridica;
        this.tecnicoRepository = repoTecnico;
    }

    public void login(Context context) {
        String usuario = context.formParam("usuario");
        String contrasenia = context.formParam("contrasenia");
        Usuario usuarioLogueado = null;
        List<Usuario> usuariosLogueados = usuarioRepository.buscarPorString(usuario);
        Map model = new HashMap<>();
        model.put("user",context.formParam("usuario"));
        model.put("contra",context.formParam("contrasenia"));

        if (usuariosLogueados.isEmpty()){
            model.put("errorDeUsuario",true);
            model.put("errorDeContrasenia",false);
            context.render("/indexYLogin/login.hbs",model);
        }else {
            usuarioLogueado = usuariosLogueados.get(0);
            if (usuarioLogueado.contraseniaCorrecta(contrasenia)) {

                context.sessionAttribute("usuario", usuarioLogueado.getNombreDeUsuario());

                switch (usuarioLogueado.getRol()) {
                    case ADMINISTRADOR:
                        context.sessionAttribute("esAdministrador", true);
                        // context.result("ADMINISTRADOR");
                        context.redirect("/menuAdmin");
                        break;
                    case COLABORADOR_HUMANO:
                        context.sessionAttribute("esColaboradorHumano", true);
                        model.put("esColaboradorHumano", true);

                        //context.sessionAttribute("idColaboradorHumano", personaHumana.getId().toString());
                        // Buscar la PersonaJuridica asociada al usuario
                        List<PersonaHumana> humanas = personaHumanaRepository.buscarElementosPorUsuario(usuarioLogueado);
                        if (!humanas.isEmpty()) {
                            PersonaHumana personaHumana = humanas.get(0);
                            context.sessionAttribute("idColaboradorHumano", personaHumana.getId()); // Guardar ID en la sesión
                            System.out.println("ID Colaborador Humano configurado en sesión: " + personaHumana.getId());
                        } else {
                            model.put("error", "No se encontró un colaborador humano asociado a este usuario.");
                            context.render("/indexYLogin/login.hbs", model);
                            return;
                        }
                        context.render("/colaboraciones/formasDeContribucion/formaDeContribucionJuridica.hbs", model);
                        context.redirect("/formaDeContribucionHumana");

                        break;
                    case TECNICO:
                        context.sessionAttribute("esTecnico", true);
                        model.put("esTecnico", true);

                        //context.sessionAttribute("idColaboradorHumano", personaHumana.getId().toString());
                        // Buscar la PersonaJuridica asociada al usuario
                        List<Tecnico> tecnicos = this.tecnicoRepository.buscarElementosPorUsuario(usuarioLogueado);
                        if (!tecnicos.isEmpty()) {
                            Tecnico tecnico = tecnicos.get(0);
                            context.sessionAttribute("idTecnico", tecnico.getId()); // Guardar ID en la sesión
                            System.out.println("ID Técnico configurado en sesión: " + tecnico.getId());
                        } else {
                            model.put("error", "No se encontró un técnico asociado a este usuario.");
                            context.render("/indexYLogin/login.hbs", model);
                            return;
                        }
                        context.render("/tecnico/menuTecnico.hbs", model);
                        context.redirect("/menuTecnico");

                        break;
                    case COLABORADOR_JURIDICO:
                        context.sessionAttribute("esColaboradorJuridico", true);

                        // Buscar la PersonaJuridica asociada al usuario
                        List<PersonaJuridica> juridicas = personaJuridicaRepository.buscarElementosPorUsuario(usuarioLogueado);
                        if (!juridicas.isEmpty()) {
                            PersonaJuridica personaJuridica = juridicas.get(0);
                            context.sessionAttribute("idColaboradorJuridico", personaJuridica.getId()); // Guardar ID en la sesión
                            System.out.println("ID Colaborador Jurídico configurado en sesión: " + personaJuridica.getId());
                        } else {
                            model.put("error", "No se encontró un colaborador jurídico asociado a este usuario.");
                            context.render("/indexYLogin/login.hbs", model);
                            return;
                        }

                        context.redirect("/formaDeContribucionJuridica");
                        break;


                }
                context.sessionAttribute("idUsuario",usuarioLogueado.getId().toString());
                context.sessionAttribute("tipoRol",usuarioLogueado.getRol().toString());
            }
            else {
                model.put("errorDeUsuario",false);
                model.put("errorDeContrasenia",true);
                context.render("/indexYLogin/login.hbs", model);
            }
        }
    }

}

