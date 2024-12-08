package ar.edu.utn.frba.dds.models.entities.heladera;
import ar.edu.utn.frba.dds.config.ServiceLocator;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.direccion.Coordenada;
import ar.edu.utn.frba.dds.models.entities.direccion.Direccion;
import ar.edu.utn.frba.dds.models.entities.heladera.utilidades.ModeloHeladera;
import ar.edu.utn.frba.dds.models.entities.heladera.utilidades.MovimientoDeViandas;
import ar.edu.utn.frba.dds.models.entities.heladera.utilidades.TemperaturaEnCelcius;
import ar.edu.utn.frba.dds.models.entities.incidentes.FallaTecnica;
import ar.edu.utn.frba.dds.models.entities.incidentes.Incidente;
import ar.edu.utn.frba.dds.models.entities.receptores.intentosApertura.IntentoApertura;
import ar.edu.utn.frba.dds.models.entities.tarjeta.TarjetaColaborador;
import ar.edu.utn.frba.dds.models.entities.vianda.Vianda;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.HeladeraRepository;
import ar.edu.utn.frba.dds.models.repositories.implementaciones.PersonaHumanaRepository;
import ar.edu.utn.frba.dds.service.excepciones.ElementoNoExisteEnRepositorioException;
import ar.edu.utn.frba.dds.service.excepciones.TarjetaSinPermisoException;
import ar.edu.utn.frba.dds.utils.Factories.FallaTecnicaFactory;
import ar.edu.utn.frba.dds.utils.calculadorDePuntos.acciones.SolicitudDeApertura;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "Heladera")
@Getter
@AllArgsConstructor
@Builder
public class Heladera extends Persistente {

    @Embedded
    private Coordenada coordenada;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "capacidad", columnDefinition = "INTEGER(11)")
    private Integer capacidad;

    @Column(name="descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoHeladera estado;

    @Setter
    @ManyToOne
    @JoinColumn(name="modelo_id",referencedColumnName="id")
    private ModeloHeladera modelo;

    @Setter
    @Enumerated(EnumType.STRING)
    private EstadoReparacion estadoReparacion;

    @OneToMany
    @JoinColumn(name = "heladera_id")
    private List<TemperaturaEnCelcius> historialDeTemperaturas;

    @OneToMany(mappedBy = "heladeraEnLaQueSeEncuentra")
    private List<Vianda> viandas;

    @OneToMany
    @JoinColumn(name = "heladera_id")
    private List<FallaTecnica> fallas;

    @OneToMany
    @JoinColumn(name = "heladera_id")
    private List<MovimientoDeViandas> movimientoDeViandas;

    @OneToMany
    @JoinColumn(name = "heladera_id")
    private List<IntentoApertura> intentosDeApertura;

    @OneToMany(mappedBy = "heladera")
    private List <SolicitudDeApertura> solicitudesDeAperturas;

    @OneToMany(mappedBy = "heladera")
    private List<Incidente> incidentes;

    public Heladera(Coordenada coordenada, Direccion direccion, String nombre, Integer capacidad, String descripcion,
                    EstadoHeladera estado, ModeloHeladera modelo, EstadoReparacion estadoReparacion) {

        this.coordenada = coordenada;
        this.direccion = direccion;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.modelo = modelo;
        this.estadoReparacion = estadoReparacion;

        this.historialDeTemperaturas = new ArrayList<>();
        this.fallas = new ArrayList<>();
        this.viandas = new ArrayList<>();
        this.movimientoDeViandas=new ArrayList<>();
        this.intentosDeApertura= new ArrayList<>();
        this.solicitudesDeAperturas= new ArrayList<>();
        this.incidentes= new ArrayList<>();
    }

    public Heladera(){
        this.historialDeTemperaturas = new ArrayList<>();
        this.fallas = new ArrayList<>();
        this.viandas = new ArrayList<>();
        this.movimientoDeViandas=new ArrayList<>();
        this.intentosDeApertura= new ArrayList<>();
        this.solicitudesDeAperturas= new ArrayList<>();
        this.incidentes= new ArrayList<>();

    }
    public  Integer capacidad() {
        return this.viandas.size();
    }

    public void actualizarTemperaturaActual(Double temperatura, LocalDateTime fechaTemperatura) {
        TemperaturaEnCelcius temp = new TemperaturaEnCelcius(temperatura, fechaTemperatura);
        this.historialDeTemperaturas.add(temp);
    }

    public void agregarIncidente(Incidente incidente) {
        this.incidentes.add(incidente);
    }

    public void reportarFallaTecnica(FallaTecnica fallaTecnica) {
        this.fallas.add(fallaTecnica);
    }

    public List<FallaTecnica> getFallas() {
        return this.fallas;
    }

    public void setMovimiento(String motivoDeLADistribucion, Integer cantidadDeRetiros, Integer cantidadDeIngresos) {
        this.movimientoDeViandas.add( new MovimientoDeViandas(motivoDeLADistribucion, cantidadDeRetiros, cantidadDeIngresos));
    }

    public void agregarVianda(Vianda vianda){
        this.viandas.add(vianda);
        vianda.setHeladeraEnLaQueSeEncuentra(this);
    }

    public List<MovimientoDeViandas> getMovimientoDeViandas() {
        return this.movimientoDeViandas;
    }

    public List<MovimientoDeViandas> getMovimientoDeViandasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        return this.movimientoDeViandas.stream()
                                       .filter(movimiento -> movimiento.fechaEntre(inicio, fin))
                                       .collect(Collectors.toList());
    }

    public Integer cantidadDeRetiros(List<MovimientoDeViandas> movimientos) {
        return movimientos.stream().mapToInt(movimiento -> movimiento.getCantidadDeViandasARetirar()).sum();
    }

    public Integer cantidadDeIngresos(List<MovimientoDeViandas> movimientos) {
        return movimientos.stream().mapToInt(movimiento -> movimiento.getCantidadDeViandasAIngresar()).sum();
    }

    public List<FallaTecnica> getFallasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
        return this.fallas.stream()
                          .filter(falla -> falla.fechaEntre(inicio, fin))
                          .collect(Collectors.toList());
    }
    
    public void agregarIntentoDeApertura(IntentoApertura intento) throws TarjetaSinPermisoException, ElementoNoExisteEnRepositorioException {
        this.intentosDeApertura.add(intento);
        TarjetaColaborador tarjeta = ServiceLocator.instanceOf(PersonaHumanaRepository.class)
                                                            .buscarTarjetaPorId(intento.getIdTarjeta());

        Optional<Heladera> posibleHeladera = HeladeraRepository.getInstance().buscarPorId(intento.getIdHeladera());

        if(posibleHeladera.isPresent()) {
            Heladera heladera = posibleHeladera.get();

            if (intento.getEstado()) {
                tarjeta.usarTarjeta(heladera, new SolicitudDeApertura(intento.getMotivo().toString(), tarjeta, heladera));
            }
        }
        else {
            throw new ElementoNoExisteEnRepositorioException("La heladera no existe.");
        }
    }

    public void agregarSolicitudDeApertura(SolicitudDeApertura solicitud){
        this.solicitudesDeAperturas.add(solicitud);
    }

}


