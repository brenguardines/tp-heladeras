package ar.edu.utn.frba.dds.controllers.colaboraciones;

import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.controllers.ICrudViewsHandler;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeOferta;
import ar.edu.utn.frba.dds.models.entities.oferta.Oferta;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.DonacionDeOfertaReporitory;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.OfertaRepository;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.PersonaJuridicaRepository;
import io.javalin.http.Context;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DonacionDeOfertaController implements ICrudViewsHandler {

  private final DonacionDeOfertaReporitory donacionDeOfertaReporitory;

  public DonacionDeOfertaController(DonacionDeOfertaReporitory donacionDeOfertaReporitory) {
    this.donacionDeOfertaReporitory = donacionDeOfertaReporitory;
  }

  @Override
  public void index(Context context) {

  }

  @Override
  public void show(Context context) {

  }

  @Override
  public void create(Context context) {
    System.out.println("Entrando a la vista de donar oferta");
    Map<String, Object> model = new HashMap<>();
    model.put("titulo", "Donación de Oferta");
    context.render("/colaboraciones/donarOferta.hbs", model);
  }

  @Override
  public void save(Context context) {
    // Crear instancia de DonacionDeOferta
    DonacionDeOferta donacionDeOferta = new DonacionDeOferta();
    PersonaJuridicaRepository personaJuridicaRepository = ServiceLocator.instanceOf(PersonaJuridicaRepository.class);

    // Validar que el usuario tenga el rol correcto
    String tipoRol = context.sessionAttribute("tipoRol");
    System.out.println("Tipo de rol en sesión: " + tipoRol);

    if (!"COLABORADOR_JURIDICO".equals(tipoRol)) {
      context.status(403).result("El usuario actual no tiene permisos para realizar esta acción.");
      return;
    }

    // Obtener el ID del colaborador jurídico desde la sesión
    Long idColaboradorJuridico = context.sessionAttribute("idColaboradorJuridico");
    System.out.println("ID Colaborador Jurídico en sesión: " + idColaboradorJuridico);

    if (idColaboradorJuridico == null) {
      System.out.println("Error: idColaboradorJuridico no está presente en la sesión.");
      context.status(400).result("El ID del colaborador jurídico no está presente en la sesión.");
      return;
    }

    // Buscar el colaborador jurídico en la base de datos
    Optional<PersonaJuridica> personaJuridica = personaJuridicaRepository.buscarPorId(idColaboradorJuridico);
    if (personaJuridica.isEmpty()) {
      context.status(400).result("Colaborador jurídico no encontrado.");
      return;
    }

    // Asignar el colaborador a la donación
    donacionDeOferta.setColaborador(personaJuridica.get());
    donacionDeOferta.setFechaDeColaboracion(LocalDate.now());

    // Obtener datos del formulario
    String nombreOferta = context.formParam("nombreOferta");
    String puntosNecesariosStr = context.formParam("puntosNecesarios");

    // Validar los datos del formulario
    if (nombreOferta == null || puntosNecesariosStr == null || puntosNecesariosStr.isEmpty()) {
      context.status(400).result("Todos los campos son obligatorios.");
      return;
    }

    try {
      // Crear una nueva oferta
      Oferta nuevaOferta = new Oferta();
      nuevaOferta.setNombre(nombreOferta);
      nuevaOferta.setPuntosNecesariosParaAccederAlBeneficio(Double.parseDouble(puntosNecesariosStr));

      // Guardar la oferta en la base de datos
      OfertaRepository ofertaRepository = ServiceLocator.instanceOf(OfertaRepository.class);
      ofertaRepository.guardar(nuevaOferta);

      // Asignar la oferta a la donación
      donacionDeOferta.setOferta(nuevaOferta);

      // Guardar la donación en la base de datos
      donacionDeOfertaReporitory.guardar(donacionDeOferta);

      System.out.println("Donación de oferta guardada exitosamente.");
      context.redirect("/colaboracionExitosaJuridica");

    } catch (NumberFormatException e) {
      System.out.println("Error: Número inválido para puntos necesarios.");
      context.status(400).result("Puntos necesarios inválidos.");
    } catch (Exception e) {
      System.out.println("Error al guardar la donación de oferta: " + e.getMessage());
      context.status(500).result("Ocurrió un error al guardar la donación de oferta.");
      e.printStackTrace();
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
