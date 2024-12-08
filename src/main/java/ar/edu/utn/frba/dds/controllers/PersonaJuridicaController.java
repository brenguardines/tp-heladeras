package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.NombreYApellido;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.documento.Documento;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.TipoDeMedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.colaboradores.TipoDePersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.direccion.Calle;
import ar.edu.utn.frba.dds.models.entities.direccion.Direccion;
import ar.edu.utn.frba.dds.models.entities.rubro.Rubro;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.PersonaJuridicaRepository;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.UsuarioRepository;
import ar.edu.utn.frba.dds.models.usuario.Contrasenia;
import ar.edu.utn.frba.dds.models.usuario.RolDeUsuario;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import ar.edu.utn.frba.dds.utils.Factories.PersonaHumanFactory;
import ar.edu.utn.frba.dds.utils.Factories.PersonaJuridicaFactory;
import ar.edu.utn.frba.dds.utils.validadorDeContrasenias.ValidadorDeContrasenias;
import io.javalin.http.Context;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonaJuridicaController implements ICrudViewsHandler {
    private PersonaJuridicaRepository repositorioDePersonasJuridicas;
    private UsuarioRepository repositorioDeUsuarios;
    private ValidadorDeContrasenias validadorDeContrasenias;

    public PersonaJuridicaController(PersonaJuridicaRepository repositorioDePersonasJuridicas, UsuarioRepository repositorioDeUsuarios, ValidadorDeContrasenias validadorDeContrasenias) {
        this.repositorioDePersonasJuridicas = repositorioDePersonasJuridicas;
        this.repositorioDeUsuarios = repositorioDeUsuarios;
        this.validadorDeContrasenias = validadorDeContrasenias;
    }

    @Override
    public void index(Context context) {

    }

    @Override
    public void show(Context context) {

    }

    @Override
    public void create(Context context) {
        //pretende devolver una vista que contenga un formulario para crear un colaborador humano nuevo
        Map<String, Object> model=new HashMap<>();
        model.put("titulo", "Registro de Colaboradores Juridicos");
        context.render("colaboradores/registroPersonaJuridica.hbs", model);

    }

    public void save(Context context) {
        Contrasenia contraseniaDeUsuario =Contrasenia.builder().contrasenia(context.formParam("contrasenia")).fechaDeCreacionDeContrasenia(LocalDateTime.now()).build();
        Map model = new HashMap<>();
        model.put("contra",context.formParam("contrasenia"));
        model.put("contraRepetida",context.formParam("contraseniaRepetida"));
        model.put("razonSocial",context.formParam("razonSocial"));
        model.put("rubro",context.formParam("rubro"));
        model.put("descripcionRubro",context.formParam("descripcionRubro"));
        model.put("calle",context.formParam("calle"));
        model.put("altura",context.formParam("altura"));
        model.put("codigoPostal",context.formParam("codigoPostal"));
        model.put("usuario",context.formParam("usuario"));
        model.put("contacto",context.formParam("contacto"));

        List<Usuario> usuariosDB = repositorioDeUsuarios.buscarPorString(context.formParam("usuario"));

        PersonaJuridica.PersonaJuridicaBuilder personaJuridica= PersonaJuridica.
                builder().
                razonSocial(model.get("razonSocial").toString()).
                tipo(TipoDePersonaJuridica.valueOf(context.formParam("tipoJuridico"))).
                direccion(Direccion.of(new Calle(context.formParam("calle")), context.formParam("altura"), context.formParam("codigoPostal"))).
                rubro(Rubro.of(model.get("rubro").toString(), model.get("descripcionRubro").toString()));

        if (!usuariosDB.isEmpty()){
            model.put("errorUsuario","El nombre de usuario no está disponible");
            context.render("colaboradores/registroPersonaJuridica.hbs", model);
        }else {
            if(validadorDeContrasenias.contraseniaValida(contraseniaDeUsuario)){
                Usuario usuario = Usuario.builder()
                        .nombreDeUsuario(context.formParam("usuario"))
                        .rol(RolDeUsuario.COLABORADOR_JURIDICO).contrasenia(contraseniaDeUsuario).build();
                this.repositorioDeUsuarios.guardar(usuario);
                personaJuridica.usuario(usuario);
                this.repositorioDePersonasJuridicas.guardar(personaJuridica.build());

                context.redirect("/registroExitoso");
            }else {
                model.put("errorContra","Las Contraseña no cumple con los requisitos de complejidad requeridos");
                context.render("colaboradores/registroPersonaJuridica.hbs", model);
            }
        }
    }

    @Override
    public void edit(Context context) {

    }

    @Override
    public void update(Context context) {

    }

    @Override
    public void delete(Context context) {

    }

}
