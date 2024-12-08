package ar.edu.utn.frba.dds.models.usuario;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.utils.validadorDeContrasenias.ValidadorDeContrasenias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@Getter
@AllArgsConstructor
@Builder
public class Usuario extends Persistente {
    @Setter
    @Column(name = "nombreDeUsuario", columnDefinition = "VARCHAR(255)")
    private String nombreDeUsuario;

    @Embedded
    private Contrasenia contrasenia;
    @Setter
    @Enumerated(EnumType.STRING)
    private RolDeUsuario rol;

    public Usuario() {
    }

    public String getContrasenia() {
        return this.contrasenia.getContrasenia();
    }

    public void setContrasenia(String contrasenia) {

        ValidadorDeContrasenias validador = new ValidadorDeContrasenias();
        Contrasenia contrseniaAuxiliar = new Contrasenia(contrasenia);

        if (validador.contraseniaValida(contrseniaAuxiliar)) {
            this.contrasenia = contrseniaAuxiliar;
        }
    }

    public boolean contraseniaCorrecta(String contrasenia) {
        return this.getContrasenia().equals(contrasenia);
    }

}