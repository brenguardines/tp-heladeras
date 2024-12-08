package ar.edu.utn.frba.dds.controllers.colaboraciones;

import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.controllers.ICrudViewsHandler;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DistribucionDeViandas;
import ar.edu.utn.frba.dds.models.entities.contribuciones.MotivoDeLaDistribucion;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.*;
import io.javalin.http.Context;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DistribucionDeViandaController implements ICrudViewsHandler {

    private DistribucionDeViandaRepository distribucionDeViandaRepository;

    public DistribucionDeViandaController(DistribucionDeViandaRepository distribucionDeViandaRepository) {
        this.distribucionDeViandaRepository = distribucionDeViandaRepository;
    }

    @Override
    public void index(io.javalin.http.Context context) {    }

    @Override
    public void show(io.javalin.http.Context context) {    }

    @Override
    public void create(Context context) {
        //pretende devolver una vista que contenga un formulario para crear un colaborador humano nuevo
        Map<String, Object> model = new HashMap<>();
        model.put("motivosDeDistribucion", Arrays.asList(MotivoDeLaDistribucion.values()));
        model.put("esColaboradorHumano", true);
        model.put("titulo", "Distribuir Viandas");
        context.render("/colaboraciones/distribuirViandas.hbs", model);
    }
    public void save(Context context) {
        HeladeraRepository heladeraRepository = ServiceLocator.instanceOf(HeladeraRepository.class);
        PersonaHumanaRepository personaHumanaRepository = ServiceLocator.instanceOf(PersonaHumanaRepository.class);

        Heladera heladeraDeOrigen =  heladeraRepository.buscarPorId(Long.getLong(context.formParam("heladeraDeOrigen"))).get();
        Heladera heladeraDeDestino =  heladeraRepository.buscarPorId(Long.getLong(context.formParam("heladeraDeDestino"))).get();

        PersonaHumana personaHumana = personaHumanaRepository.buscarPorId(Long.getLong(context.formParam("personaHumanaId"))).get();

        DistribucionDeViandas distribucionDeViandas = DistribucionDeViandas.builder()
                .motivoDeLaDistribucion(MotivoDeLaDistribucion.valueOf(context.pathParam("motivoDeLaDistribucion")))
                .heladeraDeOrigen(heladeraDeOrigen)
                .heladeraDeDestino(heladeraDeDestino)
                .cantidadDeViandasAMover(Integer.getInteger(context.formParam("cantidadDeViandasAMover")))
                .fechaDeColaboracion(LocalDate.parse(context.formParam("fechaDeColaboracion")))
                .colaborador(personaHumana)
                .build();



        this.distribucionDeViandaRepository.guardar(distribucionDeViandas);
        System.out.println("Redirigiendo a /colaboracionExitosa");
        context.redirect("/colaboracionExitosa");
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

