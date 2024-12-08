package ar.edu.utn.frba.dds.models.entities.contribuciones;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.personaEnSituacionVulnerable.PersonaEnSituacionVulnerable;
import ar.edu.utn.frba.dds.models.entities.tarjeta.TarjetaVulnerable;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="RegistroDePersonasEnSituacionVulnerable")
public class RegistroDePersonasEnSituacionVulnerable extends Persistente {
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaHumana_id")
    private PersonaHumana colaborador;

    @Column(name = "fechaDeColaboracion", columnDefinition = "DATE")
    private LocalDate fechaDeColaboracion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaVulnerable_id", referencedColumnName = "id")
    private PersonaEnSituacionVulnerable personaEnSituacionVulnerable;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "tarjetaVulnerable_id", referencedColumnName = "id")
    private TarjetaVulnerable tarjeta;

    public static RegistroDePersonasEnSituacionVulnerable of(PersonaHumana colaborador){
        RegistroDePersonasEnSituacionVulnerable colaboracion = new RegistroDePersonasEnSituacionVulnerable();
        colaboracion.setColaborador(colaborador);
        return colaboracion;
    }
    public static RegistroDePersonasEnSituacionVulnerable of(PersonaHumana colaborador, LocalDate fechaDeColaboracion){
        RegistroDePersonasEnSituacionVulnerable colaboracion = new RegistroDePersonasEnSituacionVulnerable();
        colaboracion.setColaborador(colaborador);
        colaboracion.setFechaDeColaboracion(fechaDeColaboracion);
        return colaboracion;
    }

    public boolean tieneRegistradoDomicilio() {
        return personaEnSituacionVulnerable.getDireccion() != null;
    }
}