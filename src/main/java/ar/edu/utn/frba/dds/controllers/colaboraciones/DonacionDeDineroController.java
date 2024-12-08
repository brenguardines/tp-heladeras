package ar.edu.utn.frba.dds.controllers.colaboraciones;
import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.controllers.ICrudViewsHandler;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeDinero;
import ar.edu.utn.frba.dds.models.entities.contribuciones.FrecuenciaDeDonacionDeDinero;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.DonacionDeDineroReporitory;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.PersonaHumanaRepository;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.PersonaJuridicaRepository;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.UsuarioRepository;
import ar.edu.utn.frba.dds.models.usuario.RolDeUsuario;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import com.mercadopago.net.MPRestClient;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DonacionDeDineroController implements ICrudViewsHandler {
    private DonacionDeDineroReporitory donacionDeDineroReporitory;
    private PersonaHumanaRepository personaHumanaRepository;
    private PersonaJuridicaRepository personaJuridicaRepository;
    private UsuarioRepository usuarioRepository;

    public DonacionDeDineroController(DonacionDeDineroReporitory donacionDeDineroReporitory, PersonaHumanaRepository personaHumanaRepository, PersonaJuridicaRepository personaJuridicaRepository, UsuarioRepository usuarioRepository) {
        this.donacionDeDineroReporitory = donacionDeDineroReporitory;
        this.personaHumanaRepository = personaHumanaRepository;
        this.personaJuridicaRepository = personaJuridicaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void index(io.javalin.http.Context context) {    }

    @Override
    public void show(io.javalin.http.Context context) {    }

    @Override
    public void create(Context context) {
        //pretende devolver una vista que contenga un formulario para crear un colaborador humano nuevo
        System.out.println("Entrando a la vista de donar dinero");
        Map<String, Object> model=new HashMap<>();
        model.put("titulo", "Donación de Dinero");
        model.put("esColaboradorHumano", true);
        context.render("/colaboraciones/donarDinero.hbs", model);

    }

    public void save(Context context) {
        Long idUsuario = Long.parseLong(context.sessionAttribute("idUsuario").toString());
        Usuario usuario = usuarioRepository.buscarPorId(idUsuario).get();

        DonacionDeDinero donacionDeDinero;
        PersonaHumana personaHumana = null;
        PersonaJuridica personaJuridica = null;

        if (Objects.equals(context.sessionAttribute("tipoRol").toString(), RolDeUsuario.COLABORADOR_HUMANO.toString())){
            personaHumana = personaHumanaRepository.buscarElementosPorUsuario(usuario).get(0);
            System.out.println(context.sessionAttribute("tipoRol").toString());
        }else if (Objects.equals(context.sessionAttribute("tipoRol").toString(), RolDeUsuario.COLABORADOR_JURIDICO.toString())){
            personaJuridica = personaJuridicaRepository.buscarElementosPorUsuario(usuario).get(0);
            System.out.println(context.sessionAttribute("tipoRol").toString());
        }

        donacionDeDinero = DonacionDeDinero.builder()
                    .colaboradorHumano(personaHumana)
                    .colaboradorJuridico(personaJuridica)
                    .frecuencia(FrecuenciaDeDonacionDeDinero.valueOf(context.formParam("frecuencia")))
                    .build();

        if (!context.formParam("montoPersonalizado").isEmpty()){
            donacionDeDinero.setMonto(Double.parseDouble(context.formParam("montoPersonalizado")));
        }else {
            donacionDeDinero.setMonto(Double.parseDouble(context.formParam("monto")));
        }

        this.donacionDeDineroReporitory.guardar(donacionDeDinero);

        if (Objects.equals(context.sessionAttribute("tipoRol").toString(), RolDeUsuario.COLABORADOR_HUMANO.toString())){
            context.redirect("/colaboracionExitosaHumana");
        }else if (Objects.equals(context.sessionAttribute("tipoRol").toString(), RolDeUsuario.COLABORADOR_JURIDICO.toString())){
            context.redirect("/colaboracionExitosaJuridica");
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
