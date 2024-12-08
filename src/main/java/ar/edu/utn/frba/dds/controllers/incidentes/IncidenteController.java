package ar.edu.utn.frba.dds.controllers.incidentes;

import ar.edu.utn.frba.dds.controllers.ICrudViewsHandler;
import ar.edu.utn.frba.dds.models.entities.incidentes.Alerta;
import ar.edu.utn.frba.dds.models.entities.incidentes.Incidente;
import ar.edu.utn.frba.dds.models.entities.incidentes.VisitaTecnico;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.IncidentesRepository;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.VisitaTecnicoRepository;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncidenteController implements ICrudViewsHandler {
    private IncidentesRepository incidentesRepository;
    private VisitaTecnicoRepository visitaTecnicoRepository;
    private HeladeraRepository heladeraRepository;

    public IncidenteController(IncidentesRepository incidentesRepository, VisitaTecnicoRepository visitaTecnicoRepository, HeladeraRepository heladeraRepository){
        this.incidentesRepository = incidentesRepository;
        this.visitaTecnicoRepository = visitaTecnicoRepository;
        this.heladeraRepository = heladeraRepository;
    }

    @Override
    public void index(Context context){
        //PRETENDE DEVOLVER UNA VISTA QUE CONTENGA A TODOS LOS PRODUCTOS ALMACENADOS EN MI SISTEMA
        //List<Alerta> incidentes = this.incidentesRepository.buscarTodos().stream().filter(incidente -> incidente.d); //TODO

        Map<String, Object> model = new HashMap<>();
        //model.put("Alertas", incidentes);
        model.put("titulo", "Listado de Alertas");

        context.render("productos/productos.hbs", model);
    }

    public void solucionar(Context context){
        Long idIncidente = Long.parseLong(context.pathParam("id"));
        Incidente incidente = this.incidentesRepository.buscarPorId(idIncidente).orElseThrow(() -> new RuntimeException("Incidente no encontrado"));
        VisitaTecnico visitaTecnico = new VisitaTecnico(context.pathParam("comentario"), context.pathParam("foto"), true, incidente);

        this.heladeraRepository.actualizar(incidente.getHeladera());
        this.incidentesRepository.actualizar(incidente);
        this.visitaTecnicoRepository.guardar(visitaTecnico);

        context.redirect("/menuTecnico");
    };

    public void show(Context context){

    };
    public void create(Context context){

    }
    public void save(Context context){

    }
    public void edit(Context context){

    }
    public void update(Context context){

    }
    public void delete(Context context){

    }
}
