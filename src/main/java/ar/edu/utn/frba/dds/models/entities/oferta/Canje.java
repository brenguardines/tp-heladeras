package ar.edu.utn.frba.dds.models.entities.oferta;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "canje")
public class Canje extends Persistente {

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "oferta_id", referencedColumnName = "id")
    private Oferta oferta;

    @Column(name = "fechaDeCanje", columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;

    public Canje() {

    }

    public Double puntos() {
        return this.oferta.getPuntosNecesariosParaAccederAlBeneficio();
    }

    public Canje(Oferta oferta) {
        this.oferta = oferta;
        this.fecha = LocalDateTime.now();
    }
}
