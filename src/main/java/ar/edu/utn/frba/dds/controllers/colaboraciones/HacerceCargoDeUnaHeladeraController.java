package ar.edu.utn.frba.dds.controllers.colaboraciones;

import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.controllers.ICrudViewsHandler;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.contribuciones.HacerseCargoDeUnaHeladera;
import ar.edu.utn.frba.dds.models.entities.direccion.Calle;
import ar.edu.utn.frba.dds.models.entities.direccion.Coordenada;
import ar.edu.utn.frba.dds.models.entities.direccion.Direccion;
import ar.edu.utn.frba.dds.models.entities.heladera.EstadoHeladera;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.heladera.utilidades.ModeloHeladera;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.*;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HacerceCargoDeUnaHeladeraController implements ICrudViewsHandler {
    private HacerseCargoDeUnaHeladeraRepository repositorioDeHacerceCargoDeUnaHeladera;
    private ModeloHeladeraRepository modeloHeladeraRepository;
    private UsuarioRepository usuarioRepository;
    private PersonaJuridicaRepository personaJuridicaRepository;

    public HacerceCargoDeUnaHeladeraController(HacerseCargoDeUnaHeladeraRepository repositorioDeHacerceCargoDeUnaHeladera, ModeloHeladeraRepository modeloHeladeraRepository, UsuarioRepository usuarioRepository, PersonaJuridicaRepository personaJuridicaRepository) {
        this.repositorioDeHacerceCargoDeUnaHeladera = repositorioDeHacerceCargoDeUnaHeladera;
        this.modeloHeladeraRepository=modeloHeladeraRepository;
        this.usuarioRepository = usuarioRepository;
        this.personaJuridicaRepository = personaJuridicaRepository;
    }

    @Override
    public void index(Context context) {    }

    @Override
    public void show(Context context) {    }

    @Override
    public void create(Context context) {
        //pretende devolver una vista que contenga un formulario para crear un colaborador humano nuevo
        Map<String, Object> model=new HashMap<>();
        List<ModeloHeladera> modelosHeladera = modeloHeladeraRepository.buscarTodos();

        model.put("titulo", "Hacerce Cargo De Una Heladera");
        model.put("modelos", modelosHeladera);
        context.render("/colaboraciones/hacerceCargoDeHeladera.hbs", model);
    }

    public void save(Context context) {
        Long idUsuario = Long.parseLong(context.sessionAttribute("idUsuario").toString());
        Usuario usuario = usuarioRepository.buscarPorId(idUsuario).get();
        PersonaJuridica personaJuridica = personaJuridicaRepository.buscarElementosPorUsuario(usuario).get(0);

        Direccion direccion = Direccion.of(new Calle(context.formParam("calle")), context.formParam("altura"), context.formParam("codigoPostal"));

        List<ModeloHeladera> modelosHeladera = modeloHeladeraRepository.buscarPorNombreModelo(context.formParam("modelo"));

        Heladera heladera = Heladera.builder()
                .coordenada(new Coordenada(context.formParam("longitud"), context.formParam("latitud")))
                .direccion(direccion)
                .nombre(context.formParam("nombre"))
                .descripcion(context.formParam("descripcion"))
                .estado(EstadoHeladera.Activa)
                .modelo(modelosHeladera.get(0))
                .build();

        /*if (!modelosHeladera.isEmpty()) {
            heladera.setModelo(modelosHeladera.get(0));
        }
        else {
            heladera.setModelo(new ModeloHeladera(context.formParam("modeloHeladeraNombre"),
                    Float.valueOf(context.formParam("temperaturaMinima")), Float.valueOf(context.formParam("temperaturaMaxima"))));
        }*/

        HacerseCargoDeUnaHeladera hacerceCargoDeUnaHeladera = new HacerseCargoDeUnaHeladera(personaJuridica, heladera);

        this.repositorioDeHacerceCargoDeUnaHeladera.guardar(hacerceCargoDeUnaHeladera);
        System.out.println("Redirigiendo a /colaboracionExitosa");
        context.redirect("/colaboracionExitosaJuridica");
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