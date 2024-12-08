package ar.edu.utn.frba.dds.models.entities.oferta;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.beneficio.Beneficio;
import ar.edu.utn.frba.dds.models.entities.rubro.Rubro;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "oferta")
public class Oferta extends Persistente{

    @Column(name = "nombre",columnDefinition = "VARCHAR(55)")
    private String nombre;

    @Column(name = "puntosNecesarios", columnDefinition = "FLOAT")
    private Double puntosNecesariosParaAccederAlBeneficio;

    @Column(name = "imagenIlustrativa")
    private String imagenIlustrativa;

    @Embedded
    private Beneficio beneficio;

    public Oferta(String nombre, Double puntosNecesariosParaAccederAlBeneficio) {
        this.nombre = nombre;
        this.puntosNecesariosParaAccederAlBeneficio = puntosNecesariosParaAccederAlBeneficio;
    }

    public Oferta(String nombre, Double puntosNecesariosParaAccederAlBeneficio, String imagenIlustrativa) {
        this.nombre = nombre;
        this.puntosNecesariosParaAccederAlBeneficio = puntosNecesariosParaAccederAlBeneficio;
        this.imagenIlustrativa = imagenIlustrativa;
    }

    public Oferta() {
    }

    public Rubro rubro() {
        return this.beneficio.getRubro();
    }

    public boolean cumpleConLosPuntosNecesarios(Double puntos) {
        return puntos >= this.puntosNecesariosParaAccederAlBeneficio;
    }
}
