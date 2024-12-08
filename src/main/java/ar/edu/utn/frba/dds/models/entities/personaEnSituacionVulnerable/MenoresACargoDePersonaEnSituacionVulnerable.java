package ar.edu.utn.frba.dds.models.entities.personaEnSituacionVulnerable;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.NombreYApellido;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "hijoDePersonaVulnerable")
@Builder
public class MenoresACargoDePersonaEnSituacionVulnerable extends Persistente {
    @Embedded
    private NombreYApellido nombreYApellido;
    @Column(name = "fechaDeNacimiento", columnDefinition = "TIMESTAMP")
    private LocalDateTime  fechaDeNacimiento;

    @Column(name = "parentesco",columnDefinition = "VARCHAR(55)")
    private String relacionConPersonaEnSituacionVulnerable;

    public MenoresACargoDePersonaEnSituacionVulnerable(NombreYApellido nombreYApellido,LocalDateTime fechaDeNacimiento, String relacionConPersonaEnSituacionVulnerable) {
        this.nombreYApellido = nombreYApellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.relacionConPersonaEnSituacionVulnerable = relacionConPersonaEnSituacionVulnerable;
    }

    public MenoresACargoDePersonaEnSituacionVulnerable() {

    }

    public boolean esMenorDeEdad() {
        return LocalDateTime.now().minusYears(18).isAfter(fechaDeNacimiento);
    }
}