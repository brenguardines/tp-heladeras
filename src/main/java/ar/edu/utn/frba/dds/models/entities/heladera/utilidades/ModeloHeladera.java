package ar.edu.utn.frba.dds.models.entities.heladera.utilidades;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="modeloHeladera")
public class ModeloHeladera extends Persistente {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "temperaturaMinima")
    private Float temperaturaMinima;

    @Column(name = "temperaturaMaxima")
    private Float temperaturaMaxima;

    @Column(name = "marca")
    private String marca;

    public ModeloHeladera(String nombre, Float temperaturaMinima, Float temperaturaMaxima) {
        this.nombre = nombre;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public ModeloHeladera() {
    }
}
