package ar.edu.utn.frba.dds.cargaMasivaTest;
import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Mensaje;
import ar.edu.utn.frba.dds.models.entities.cargaDeUsuarios.CargaDeUsuarios;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DistribucionDeViandas;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeDinero;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeVianda;
import ar.edu.utn.frba.dds.models.entities.contribuciones.RegistroDePersonasEnSituacionVulnerable;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.EstrategiaEnvioMensaje;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.email.AdapterEmail;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.email.EnvioEmail;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.List;
import static org.mockito.Mockito.*;

public class CargaMasivaTest {
    /*
    String archivoCSV;
    CargaDeUsuarios carga;
    List<PersonaHumana> colaboradores;

    @BeforeEach
    public void init(){
        this.archivoCSV = "../2024-tpa-mi-no-grupo-14/src/main/java/ar/edu/utn/frba/dds/models/entities/cargaDeUsuarios/csv.csv";
        this.carga = new CargaDeUsuarios(ServiceLocator.instanceOf(UsuarioRepository.class));
        colaboradores = carga.getColaboradores(archivoCSV);
        LocalDate f = LocalDate.now();
    }

    @Test
    @DisplayName("Muestra el dni, nombre, apellido y correo de todos los colaboradores pasados")
    public void cargaMasivaTest() {
        for (PersonaHumana colaborador : colaboradores) {
            System.out.println(colaborador.getDocumento().getTipoDeDocumento() + " "+
            colaborador.getDocumento().getNumeroDeDocumento() + " " +
            colaborador.getNombreYApellido().getNombre() + " " +
            colaborador.getNombreYApellido().getApellido() + " " +
            colaborador.getMediosDeContactos().get(0).getContacto());
        }
    }
    @Test
    @DisplayName("Mostrar todas las contribuciones de un colaborador")
    public void contribucionesTest() {
        PersonaHumana colaborador = colaboradores.get(2);
        for (DonacionDeDinero donacionDeDinero : colaborador.getDonacionesDeDinero()) {
            System.out.println(colaborador.getNombreYApellido().getNombre() +" "+ colaborador.getNombreYApellido().getApellido()+" "+ donacionDeDinero.getClass().getSimpleName());
        }
        for (DistribucionDeViandas distribucionDeViandas : colaborador.getDistribucionesDeViandas()) {
            System.out.println(colaborador.getNombreYApellido().getNombre() +" "+ colaborador.getNombreYApellido().getApellido()+" "+ distribucionDeViandas.getClass().getSimpleName());
        }
        for (RegistroDePersonasEnSituacionVulnerable registro : colaborador.getRegistrosDePersonasEnSituacionVulnerables()) {
            System.out.println(colaborador.getNombreYApellido().getNombre() +" "+ colaborador.getNombreYApellido().getApellido()+" "+ registro.getClass().getSimpleName());
        }
        for (DonacionDeVianda donacionDeVianda : colaborador.getDonacionesDeViandas()) {
            System.out.println(colaborador.getNombreYApellido().getNombre() +" "+ colaborador.getNombreYApellido().getApellido()+" "+ donacionDeVianda.getClass().getSimpleName());
        }
    }

    @Test
    @DisplayName("Enviar correos al grupo 14 agradeciendo")
    public void grupoTest() throws MessagingException {
        String csvGrupo14 = "../2024-tpa-mi-no-grupo-14/src/main/java/ar/edu/utn/frba/dds/models/entities/cargaDeUsuarios/grupo14.csv";
        CargaDeUsuarios carga = new CargaDeUsuarios(ServiceLocator.instanceOf(UsuarioRepository.class));
        List<PersonaHumana> grupo14 = carga.getColaboradores(csvGrupo14);
        EnvioEmail sender = new EnvioEmail();
        Mensaje msj = new Mensaje();
        msj.setMensaje("Holaaaaaaaa, gracias por contribuir");
        msj.setAsunto("Prueba de envio de mensaje");

        sender.enviarMensajes(msj, grupo14);
    }

    @Test
    @DisplayName("Enviar correos pero con la biblioteca mockeada")
    public void correosMockeados() throws MessagingException {
        String csvGrupo14 = "../2024-tpa-mi-no-grupo-14/src/main/java/ar/edu/utn/frba/dds/models/entities/cargaDeUsuarios/grupo14.csv";
        CargaDeUsuarios carga = new CargaDeUsuarios(ServiceLocator.instanceOf(UsuarioRepository.class));
        List<PersonaHumana> grupo14 = carga.getColaboradores(csvGrupo14);
        Mensaje msj = new Mensaje();
        msj.setMensaje("Holaaaaaaaa, gracias por contribuir");
        msj.setAsunto("Prueba de envio de mensaje");

        AdapterEmail sender = mock(AdapterEmail.class);

        doNothing().when(sender).enviarMensajes(msj, grupo14);
        sender.enviarMensajes(msj,grupo14);
    }
     */
}


