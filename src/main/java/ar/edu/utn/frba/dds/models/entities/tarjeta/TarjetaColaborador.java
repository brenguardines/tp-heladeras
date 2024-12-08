package ar.edu.utn.frba.dds.models.entities.tarjeta;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.utils.calculadorDePuntos.acciones.SolicitudDeApertura;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.tarjeta.usos.UsoTarjetaColaborador;
import ar.edu.utn.frba.dds.service.excepciones.TarjetaSinPermisoException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name="tarjetaColaborador")
public class TarjetaColaborador extends Persistente {
    @Setter
    @Column(name = "codigo", columnDefinition = "VARCHAR(55)")
    private String codigo;
    @Setter
    @OneToMany
    @JoinColumn(name = "tarjetaColaborador_id")
    private List<UsoTarjetaColaborador> usos;

    @Setter
    @Column(name = "estaEnUso", columnDefinition = "TINYINT(1)")
    private Boolean estaEnUso = false;

    public TarjetaColaborador() {
        this.usos = new ArrayList<>();
    }

    public void usarTarjeta(Heladera heladera, SolicitudDeApertura solicitud) throws TarjetaSinPermisoException {

        if(!this.puedeUsarTarjeta(solicitud)) {
            throw new TarjetaSinPermisoException("La el usuario no tiene el permiso para realizar dicha accion");
        }
        else {
            usos.add(new UsoTarjetaColaborador(heladera, solicitud));
        }
    }

    public void activarTarjeta() {
        this.estaEnUso = true;
    }

    public void desactivarTarjeta() {
        this.estaEnUso = false;
    }

    protected boolean puedeUsarTarjeta(SolicitudDeApertura solicitud) {
        Duration diferencia = Duration.between(LocalDateTime.now(), solicitud.getHoraDeRegistro());
        boolean esMismoDia = LocalDateTime.now().toLocalDate().equals(solicitud.getHoraDeRegistro().toLocalDate());

        return (solicitud != null) && esMismoDia && diferencia.equals(Duration.ofHours(3));
    }

    public LocalDateTime ultimaVezUtilizada(){
        //return usos.getLast().getFecha();
        return usos.get(usos.size()-1).getFecha();
    }

    public Heladera ultimaHeladeraUsada(){
        return usos.get(usos.size()-1).getHeladera();
    }
}
