package ar.edu.utn.frba.dds.models.entities.personaEnSituacionVulnerable;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.NombreYApellido;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.documento.Documento;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.tarjeta.TarjetaVulnerable;
import ar.edu.utn.frba.dds.models.entities.direccion.Direccion;
import ar.edu.utn.frba.dds.models.entities.tarjeta.TarjetaVulnerable;
import ar.edu.utn.frba.dds.models.entities.vianda.Vianda;
import ar.edu.utn.frba.dds.service.excepciones.TarjetaSinUsosException;
import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="personaVulnerable")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class PersonaEnSituacionVulnerable extends Persistente {
    @Embedded
    private NombreYApellido nombreYApellido;
    @Column(name = "fechaDeNacimiento", columnDefinition = "DATE")
    private LocalDate fechaDeNacimiento;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    @Embedded
    private Documento documento;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaVulnerable_id")
    private List<MenoresACargoDePersonaEnSituacionVulnerable> menoresACargo;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "tarjetaVulnerable_id", referencedColumnName = "id")
    private TarjetaVulnerable tarjeta;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaHumanaQueLoRegistro_id", referencedColumnName = "id")
    private PersonaHumana colaboradorQueLoRegistro;

    @Column(name = "cantidadDeHijos") // Desnormalización por porformance
    private Integer cantHijos;

    public PersonaEnSituacionVulnerable(NombreYApellido nombreYApellido,
                                        LocalDate fechaDeNacimiento,
                                        Direccion direccion, Documento documento,
                                        List<MenoresACargoDePersonaEnSituacionVulnerable> menoresACargo,
                                        TarjetaVulnerable tarjeta,
                                        PersonaHumana colaboradorQueLoRegistro) {
        this.nombreYApellido = nombreYApellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.direccion = direccion;
        this.documento = documento;
        this.menoresACargo = menoresACargo;
        this.tarjeta = tarjeta;
        this.colaboradorQueLoRegistro = colaboradorQueLoRegistro;
    }

    public PersonaEnSituacionVulnerable() {

    }

    public void agregarMenor(MenoresACargoDePersonaEnSituacionVulnerable menor) {
        menoresACargo.add(menor);
    }

    public Integer cantidadDeMenoresACargo() {
        return menoresACargo.size();
    }

    public void usarTarjeta(Heladera heladera, Vianda vianda) throws TarjetaSinUsosException {
        tarjeta.usarTarjeta(heladera, vianda);
    }
}