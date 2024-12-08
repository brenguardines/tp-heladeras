package ar.edu.utn.frba.dds.config;

import ar.edu.utn.frba.dds.controllers.*;
import ar.edu.utn.frba.dds.controllers.colaboraciones.*;
import ar.edu.utn.frba.dds.models.entities.cargaDeUsuarios.CargaDeUsuarios;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.*;
import ar.edu.utn.frba.dds.utils.validadorDeContrasenias.ValidadorDeContrasenias;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private static Map<String, Object> instances = new HashMap<>();


    @SuppressWarnings("unchecked")
    public static <T> T instanceOf(Class<T> componentClass) {
        String componentName = componentClass.getName();

        if (!instances.containsKey(componentName)) {
            if(componentName.equals(PersonaHumanaController.class.getName())) {
                PersonaHumanaController instance = new PersonaHumanaController(instanceOf(PersonaHumanaRepository.class), new ValidadorDeContrasenias(), new UsuarioRepository(), instanceOf(OfertaRepository.class));
                instances.put(componentName, instance);
            }
            else if (componentName.equals(PersonaHumanaRepository.class.getName())) {
                PersonaHumanaRepository instance = new PersonaHumanaRepository();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(UsuarioRepository.class.getName())) {
                UsuarioRepository instance = new UsuarioRepository();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(PersonaJuridicaRepository.class.getName())) {
                PersonaJuridicaRepository instance = new PersonaJuridicaRepository();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(PersonaVulnerableRepository.class.getName())) {
                PersonaVulnerableRepository instance = new PersonaVulnerableRepository();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(ModeloHeladeraRepository.class.getName())) {
                ModeloHeladeraRepository instance = new ModeloHeladeraRepository();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(TecnicoRepository.class.getName())) {
                TecnicoRepository instance = new TecnicoRepository();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(AuthController.class.getName())) {
                AuthController instance = new AuthController(instanceOf(UsuarioRepository.class),
                        instanceOf(PersonaHumanaRepository.class), instanceOf(PersonaJuridicaRepository.class), instanceOf(TecnicoRepository.class));
                instances.put(componentName, instance);
            }
            else if (componentName.equals(PersonaJuridicaController.class.getName())) {
                PersonaJuridicaController instance = new PersonaJuridicaController(instanceOf(PersonaJuridicaRepository.class), instanceOf(UsuarioRepository.class), new ValidadorDeContrasenias());
                instances.put(componentName, instance);
            }
            else if (componentName.equals(HacerceCargoDeUnaHeladeraController.class.getName())) {
                HacerceCargoDeUnaHeladeraController instance = new HacerceCargoDeUnaHeladeraController(instanceOf(HacerseCargoDeUnaHeladeraRepository.class), instanceOf(ModeloHeladeraRepository.class), instanceOf(UsuarioRepository.class), instanceOf(PersonaJuridicaRepository.class));
                instances.put(componentName, instance);
            }
            else if (componentName.equals(DonacionDeDineroReporitory.class.getName())) {
                DonacionDeDineroReporitory instance = new DonacionDeDineroReporitory();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(HacerseCargoDeUnaHeladeraRepository.class.getName())) {
                HacerseCargoDeUnaHeladeraRepository instance = new HacerseCargoDeUnaHeladeraRepository();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(DistribucionDeViandaRepository.class.getName())) {
                DistribucionDeViandaRepository instance = new DistribucionDeViandaRepository();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(RegistroDePersonaVulnerableRepository.class.getName())) {
                RegistroDePersonaVulnerableRepository instance = new RegistroDePersonaVulnerableRepository();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(DistribucionDeViandaController.class.getName())) {
                DistribucionDeViandaController instance = new DistribucionDeViandaController(new DistribucionDeViandaRepository());
                instances.put(componentName, instance);
            }

            else if (componentName.equals(DonacionDeViandaController.class.getName())) {
                DonacionDeViandaController instance = new DonacionDeViandaController(instanceOf(DonacionDeViandaRepository.class));
                instances.put(componentName, instance);
            }
            else if (componentName.equals(DonacionDeViandaRepository.class.getName())) {
                DonacionDeViandaRepository instance = new DonacionDeViandaRepository();
                instances.put(componentName, instance);
            }else if (componentName.equals(DonacionDeDineroController.class.getName())) {
                DonacionDeDineroController instance = new DonacionDeDineroController(instanceOf(DonacionDeDineroReporitory.class), instanceOf(PersonaHumanaRepository.class),instanceOf(PersonaJuridicaRepository.class), instanceOf(UsuarioRepository.class));
                instances.put(componentName, instance);
            }else if (componentName.equals(PersonaVulnerableController.class.getName())) {
                PersonaVulnerableController instance = new PersonaVulnerableController(
                    instanceOf(PersonaVulnerableRepository.class), instanceOf(RegistroDePersonaVulnerableRepository.class)
                );
                instances.put(componentName, instance);
            }else if (componentName.equals(AdminController.class.getName())) {
                AdminController instance = new AdminController(new CargaDeUsuarios(new UsuarioRepository()),new UsuarioRepository(), new PersonaHumanaRepository());
                instances.put(componentName, instance);
            }else if (componentName.equals(HeladeraRepository.class.getName())) {
                HeladeraRepository instance = HeladeraRepository.getInstance();
                instances.put(componentName, instance);
            }else if (componentName.equals(DonacionDeOfertaReporitory.class.getName())) {
                DonacionDeOfertaReporitory instance = new DonacionDeOfertaReporitory();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(DonacionDeOfertaController.class.getName())) {
                DonacionDeOfertaController instance = new DonacionDeOfertaController(new DonacionDeOfertaReporitory());
                instances.put(componentName, instance);
            }
            else if (componentName.equals(OfertaRepository.class.getName())) {
                OfertaRepository instance = new OfertaRepository();
                instances.put(componentName, instance);
            }
            else if (componentName.equals(CanjeRepository.class.getName())) {
                CanjeRepository instance = new CanjeRepository();
                instances.put(componentName, instance);
            }


        }

        return (T) instances.get(componentName);
    }
}