package ar.edu.utn.frba.dds.models.entities.tarjeta;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.tarjeta.usos.UsoTarjetaVulnerable;
import ar.edu.utn.frba.dds.models.entities.vianda.Vianda;
import ar.edu.utn.frba.dds.service.excepciones.TarjetaSinUsosException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "tarjetaVulnerable")
@Builder
@AllArgsConstructor
public class TarjetaVulnerable extends Persistente {
    @Column(name = "codigo", columnDefinition = "VARCHAR(255)")
    private String codigo;

    @OneToMany
    @JoinColumn(name = "tarjetaVulnerable_id")
    private List<UsoTarjetaVulnerable> usos;

    @Column(name = "usosMaximosPermitidos", columnDefinition = "INTEGER")
    private Integer maximaCantidadDeUsosPermitidos = 4;

    @Column(name = "usosMaximosPermitidosPorMenos", columnDefinition = "INTEGER")
    private Integer maximaCantidadDeUsosPorMenoresACargo = 2;

    @Column(name = "usosMaximosPropio", columnDefinition = "INTEGER")
    protected Integer usoMaximo = 0;

    @Setter
    @Column(name = "estaEnUso", columnDefinition = "TINYINT(1)")
    private Boolean estaEnUso = false;

    public TarjetaVulnerable(String codigo, Integer cantidadMenoresACargo) {
        this.codigo = codigo;
        this.usos = new ArrayList<UsoTarjetaVulnerable>();
        this.usoMaximo = (cantidadMenoresACargo * this.maximaCantidadDeUsosPorMenoresACargo) + this.maximaCantidadDeUsosPermitidos;
    }

    public TarjetaVulnerable(String codigo) {
        this.codigo = codigo;
    }

    public TarjetaVulnerable() {

    }

    public void usarTarjeta(Heladera heladera, Vianda vianda) throws TarjetaSinUsosException {

        if(!puedeUsarTarjeta()) {
            throw new TarjetaSinUsosException("La tarjeta agoto la cantidad de usos disponibles");
        }
        else {
            usos.add(new UsoTarjetaVulnerable(heladera, vianda));
        }
    }

    public boolean puedeUsarTarjeta() {
        return (this.usos.stream()
                        .filter(uso -> this.comparacionDeFechas(uso.getFecha(), LocalDateTime.now()))
                        .count()) < this.maximaCantidadDeUsosPermitidos;
    }

    public Boolean comparacionDeFechas (LocalDateTime fecha1, LocalDateTime fecha2) {
        return fecha1.getYear() == fecha2.getYear()
               && fecha1.getMonthValue() == fecha2.getMonthValue()
               && fecha1.getDayOfMonth() == fecha2.getDayOfMonth();
    }

    public LocalDateTime ultimaVezUtilizada(){
        //return usos.getLast().getFecha();
        return usos.get(usos.size()-1).getFecha();
    }
    public Heladera ultimaHeladeraUsada(){
        return usos.get(usos.size()-1).getHeladera();
    }
}
