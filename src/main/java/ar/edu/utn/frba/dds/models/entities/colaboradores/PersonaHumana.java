package ar.edu.utn.frba.dds.models.entities.colaboradores;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.NombreYApellido;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.documento.Documento;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.TipoDeMedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.direccion.Direccion;
import ar.edu.utn.frba.dds.service.excepciones.ElementoNoExisteEnRepositorioException;
import ar.edu.utn.frba.dds.utils.calculadorDePuntos.acciones.SolicitudDeApertura;
import ar.edu.utn.frba.dds.utils.clienteBroker.Broker;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DistribucionDeViandas;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeDinero;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeVianda;
import ar.edu.utn.frba.dds.models.entities.contribuciones.RegistroDePersonasEnSituacionVulnerable;
import ar.edu.utn.frba.dds.models.entities.formulario.FormularioRespondido;
import ar.edu.utn.frba.dds.models.entities.oferta.Canje;
import ar.edu.utn.frba.dds.models.entities.tarjeta.TarjetaColaborador;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.service.excepciones.TarjetaSinPermisoException;
import ar.edu.utn.frba.dds.utils.calculadorDePuntos.CalculadorDePuntos;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.oferta.Oferta;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.eclipse.paho.client.mqttv3.MqttException;
import javax.persistence.*;
import org.apache.commons.collections4.CollectionUtils;

@Entity
@Table(name = "personaHumana")
@Getter
@AllArgsConstructor
@Builder
public class PersonaHumana extends Persistente {

    @Embedded
    @Setter
    private NombreYApellido nombreYApellido;

    @Setter
    @Column(name = "fechaNacimiento", columnDefinition = "DATE")
    private LocalDate fechaDeNacimiento;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaHumana_id")
    private List<MedioDeContacto> mediosDeContactos;

    @Setter
    @Embedded
    private Documento documento;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    @OneToOne
    @JoinColumn(name = "formularioRespondido_id", referencedColumnName = "id")
    private FormularioRespondido formularioRespondido;

    @Setter
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "colaboradorHumano", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DonacionDeDinero> donacionesDeDinero;

    @OneToMany(mappedBy = "colaborador", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DistribucionDeViandas> distribucionesDeViandas;

    @OneToMany(mappedBy = "colaborador", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DonacionDeVianda> donacionesDeViandas;

    @OneToMany(mappedBy = "colaborador", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RegistroDePersonasEnSituacionVulnerable> registrosDePersonasEnSituacionVulnerables;

    @Transient
    protected CalculadorDePuntos calculadorDePuntos;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaHumana_id")
    private  List<Canje> canjes;

    @OneToMany
    @JoinColumn(name = "personaHumana_id")
    private  List<TarjetaColaborador> tarjetas;


    public PersonaHumana(){
        this.mediosDeContactos= new ArrayList<>();
        this.donacionesDeDinero = new ArrayList<>();
        this.distribucionesDeViandas = new ArrayList<>();
        this.donacionesDeViandas = new ArrayList<>();
        this.registrosDePersonasEnSituacionVulnerables = new ArrayList<>();
        this.tarjetas=new ArrayList<>();
        this.canjes = new ArrayList<>();
        this.calculadorDePuntos = new CalculadorDePuntos();
    }

    public PersonaHumana(Usuario usuario, FormularioRespondido formularioRespondido) {
        this.usuario = usuario;
        this.formularioRespondido = formularioRespondido;
        this.calculadorDePuntos = new CalculadorDePuntos();
        this.mediosDeContactos= new ArrayList<>();
        this.donacionesDeDinero = new ArrayList<>();
        this.distribucionesDeViandas = new ArrayList<>();
        this.donacionesDeViandas = new ArrayList<>();
        this.registrosDePersonasEnSituacionVulnerables = new ArrayList<>();
    }

    public String getNombreYApellidoSeparado() {
        return nombreYApellido.getNombre() + " " + nombreYApellido.getApellido();
    }

    public TarjetaColaborador getTarjetaColaborador(){
        return this.tarjetas.stream().filter(TarjetaColaborador::getEstaEnUso).toList().get(0);
    }
    public void canjearPuntos(Oferta oferta) {
        if (oferta.cumpleConLosPuntosNecesarios(this.puntosObtenidos() - this.puntosYaCanjeados())) {
            Canje canje = new Canje(oferta);
            this.canjes.add(canje);
            System.out.println(this.canjes.size());
        }
    }
    public void agregarTarjeta(TarjetaColaborador tarjeta){
        tarjeta.activarTarjeta();
        this.tarjetas.add(tarjeta);
    }

    public Double puntosYaCanjeados(){
        return this.canjes.stream()
                          .mapToDouble(Canje::puntos)
                          .sum();
    }

    public List<TarjetaColaborador> tarjetasActivas(){
        return this.tarjetas.stream()
                          .filter(TarjetaColaborador::getEstaEnUso)
                          .collect(Collectors.toList());
    }

    public Double puntosObtenidos(){
        Double totalPuntos = 0.0;

        if (!this.donacionesDeViandas.isEmpty() || !this.donacionesDeDinero.isEmpty() ||
                !this.distribucionesDeViandas.isEmpty() || !this.registrosDePersonasEnSituacionVulnerables.isEmpty()) {
            totalPuntos =  calculadorDePuntos.calcularPuntos(this);
        }

        return totalPuntos;
    }

    public void aniadirMedioDeContacto(MedioDeContacto contacto){
        mediosDeContactos.add(contacto);
    }

    public boolean tieneUsuario(){
        return this.usuario == null;
    }

    public void agregarDonacionDeDinero(DonacionDeDinero donacion){
        this.donacionesDeDinero.add(donacion);
        donacion.setColaboradorHumano(this);
    }

    public void agregarDonacionDeVianda(DonacionDeVianda donacion){
        this.donacionesDeViandas.add(donacion);
        donacion.setColaborador(this);
    }

    public void agregarRegistroDePersonasEnSituacionVulnerable(RegistroDePersonasEnSituacionVulnerable registro){
        this.registrosDePersonasEnSituacionVulnerables.add(registro);
        registro.setColaborador(this);
    }

    public void agregarDistribucionDeViandas(DistribucionDeViandas distribucion){
        this.distribucionesDeViandas.add(distribucion);
        distribucion.setColaborador(this);
    }

    public List<DonacionDeVianda> getDonacionesDeViandasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        return this.donacionesDeViandas.stream()
                                       .filter(donacion -> donacion.fechaEntre(inicio, fin))
                                       .collect(Collectors.toList());
    }

    public List<DistribucionDeViandas> getDistribucionesDeViandasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        return this.distribucionesDeViandas.stream()
                .filter(distribucion -> distribucion.fechaEntre(inicio, fin))
                .collect(Collectors.toList());
    }

    public void solicitarAperturaHeladera(Long idHeladera, String descripcion) throws MqttException, TarjetaSinPermisoException, ElementoNoExisteEnRepositorioException {
        if (descripcion.equals("")) {
            throw new TarjetaSinPermisoException("La el usuario no tiene el permiso para realizar dicha accion");
        }
        else {
            Optional<Heladera> posibleHeladera = HeladeraRepository.getInstance().buscarPorId(idHeladera);
            if(posibleHeladera.isPresent()) {
                Heladera heladera = posibleHeladera.get();

                SolicitudDeApertura solicitud = new SolicitudDeApertura(descripcion, getTarjetaColaborador(), heladera);
                Broker broker = new Broker("tcp://test.mosquitto.org:1883");
                broker.connect();
                broker.publish("dds/tpAnual/solicitudesApertura", "{\"idHelader\": " + idHeladera + ", \"fechaHora\": " + LocalDateTime.now() + ", \"idTarjeta\": \"" + getTarjetaColaborador().getCodigo() + "\"}", 2);
                heladera.agregarSolicitudDeApertura(solicitud);
            }
            else {
                throw new ElementoNoExisteEnRepositorioException("La heladera no existe.");
            }
        }
    }

    public MedioDeContacto obtenerMedioDeContactoPorTipo(TipoDeMedioDeContacto tipo) {
        return mediosDeContactos.stream()
            .filter(medio -> medio.getTipoDeMedioDeContacto().equals(tipo))
            .findFirst()
            .orElse(null);
    }
}
