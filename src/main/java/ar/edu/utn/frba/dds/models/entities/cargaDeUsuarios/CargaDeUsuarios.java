package ar.edu.utn.frba.dds.models.entities.cargaDeUsuarios;
import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.NombreYApellido;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Mensaje;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.documento.Documento;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.TipoDeMedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.contribuciones.*;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.EstrategiaEnvioMensaje;
import ar.edu.utn.frba.dds.models.entities.envioDeMensajes.email.EnvioEmail;
import ar.edu.utn.frba.dds.models.entities.vianda.Vianda;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.PersonaHumanaRepository;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.UsuarioRepository;
import ar.edu.utn.frba.dds.models.usuario.Contrasenia;
import ar.edu.utn.frba.dds.models.usuario.RolDeUsuario;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import ar.edu.utn.frba.dds.utils.Factories.PersonaHumanFactory;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import javax.mail.MessagingException;
import javax.mail.Service;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CargaDeUsuarios {
    List<PersonaHumana> colaboradores = new ArrayList<>();
    UsuarioRepository usuarioRepository;

    public CargaDeUsuarios(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<PersonaHumana> getColaboradores(String archivoCSV){
        try (CSVReader reader = new CSVReader(new FileReader(archivoCSV))) {
            List<String[]> filas = reader.readAll();
            for (String[] fila : filas) {

                Documento documento = Documento.of(fila[0], fila[1]);
                NombreYApellido nombreYApellido=NombreYApellido.of(fila[2], fila[3]);
                MedioDeContacto contacto = MedioDeContacto.of("CORREO", fila[4]);

                PersonaHumana colaborador = PersonaHumanFactory.create(nombreYApellido, contacto, documento);

                // formato de las fechas de las colaboraciones del archivo
                DateTimeFormatter formatoOriginal = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                switch (fila[6]) {
                    case "DINERO":
                        DonacionDeDinero donacionDinero = DonacionDeDinero.of(colaborador, (double) Integer.parseInt(fila[7]),LocalDate.parse(fila[5],formatoOriginal), FrecuenciaDeDonacionDeDinero.Mensual);
                        colaborador.agregarDonacionDeDinero(donacionDinero);
                        break;
                    case "DONACION_VIANDAS":
                        Vianda vianda=new Vianda();
                        DonacionDeVianda donacionDeVianda = DonacionDeVianda.of(colaborador,vianda,LocalDate.parse(fila[5],formatoOriginal));
                        for (int i = 0; i < Integer.parseInt(fila[7]); i++) {
                            colaborador.agregarDonacionDeVianda(donacionDeVianda);
                        }
                        break;
                    case "REDISTRIBUCION_VIANDAS":
                        DistribucionDeViandas distribucionDeViandas = DistribucionDeViandas.of(colaborador, Integer.parseInt(fila[7]), LocalDate.parse(fila[5],formatoOriginal));
                        colaborador.agregarDistribucionDeViandas(distribucionDeViandas);
                        // Se asume que la cantidad de viandas que mueve pertenece a una sola contribución
                        break;
                    case "ENTREGA_TARJETAS":
                        RegistroDePersonasEnSituacionVulnerable distribucionDeTarjetas = RegistroDePersonasEnSituacionVulnerable.of(colaborador, LocalDate.parse(fila[5],formatoOriginal));
                        for (int i = 0; i < (Integer.parseInt(fila[7])); i++) {
                            colaborador.agregarRegistroDePersonasEnSituacionVulnerable(distribucionDeTarjetas);
                        }
                }
                Contrasenia contraseniaDeUsuario =Contrasenia.builder().
                        contrasenia(colaborador.getDocumento().getNumeroDeDocumento()+colaborador.getNombreYApellido().getNombre().toLowerCase().charAt(0)+colaborador.getNombreYApellido().getApellido().toUpperCase().charAt(0)+"#").
                        fechaDeCreacionDeContrasenia(LocalDateTime.now()).build();
                Usuario usuario = Usuario.builder()
                        .nombreDeUsuario(colaborador.getNombreYApellido().getNombre().toLowerCase().charAt(0)+colaborador.getNombreYApellido().getApellido().toLowerCase())
                        .rol(RolDeUsuario.COLABORADOR_HUMANO)
                        .contrasenia(contraseniaDeUsuario).build();
                this.usuarioRepository.guardar(usuario);
                colaborador.setUsuario(usuario);
                this.colaboradores.add(colaborador);
            }
        }catch (IOException | CsvException e) {
                e.printStackTrace();
            }
        for (int j =colaboradores.size()-1; j >=0; j--) {
            PersonaHumana currentElement = this.colaboradores.get(j);
            Iterator<PersonaHumana> iterator = this.colaboradores.listIterator(j+1);
            while (iterator.hasNext()) {
                PersonaHumana nextElement = iterator.next();
                if (currentElement.getDocumento().getNumeroDeDocumento().equals(nextElement.getDocumento().getNumeroDeDocumento())) {
                    currentElement.getDistribucionesDeViandas().addAll(nextElement.getDistribucionesDeViandas());
                    currentElement.getDonacionesDeViandas().addAll(nextElement.getDonacionesDeViandas());
                    currentElement.getRegistrosDePersonasEnSituacionVulnerables().addAll(nextElement.getRegistrosDePersonasEnSituacionVulnerables());
                    currentElement.getDonacionesDeDinero().addAll(nextElement.getDonacionesDeDinero());
                    iterator.remove();
                }
            }
        }
        return colaboradores;
    }
    public static void  enviarCorreos(List<PersonaHumana> colaboradores) throws MessagingException {
        EstrategiaEnvioMensaje adapter = new EnvioEmail();
        Mensaje mensaje = new Mensaje("","");

        for (PersonaHumana colaborador : colaboradores) {
            mensaje.setAsunto("AGRADECIMIENTO DE CONTRIBUCIÓN");
            mensaje.setMensaje("Muchas gracias por haber colaborado con la causa. En caso de que desee " +
                "seguir ayudando, puede usar las siguientes credenciales para poder acceder " +
                "al nuevo sistema.\n" +
                "Usuario: " +colaborador.getNombreYApellido().getNombre().toLowerCase().charAt(0)+colaborador.getNombreYApellido().getApellido().toLowerCase()+ "\n"+
                "Contraseña: número de DNI seguido de la primera letra del " +
                "primer nombre en minúscula, seguido de la primera letra del primer apellido en mayúscula" +
                ", seguido del caracter '#'");
                    /* el patrón del nombre de usuario sería la primera letra del nombre en minúscula seguido del apellido con la primer letra en mayúscula
                      y la contraseña tiene un patrón para ser válida pero es distinta según el colaborador.
                     Ejemplo para alguien llamado Lionel Messi con documento 33016244:
                        33016244lM#
                     */
            adapter.enviarMensaje(mensaje, colaborador);
        }
    }
}
