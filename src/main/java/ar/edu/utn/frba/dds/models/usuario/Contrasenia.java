package ar.edu.utn.frba.dds.models.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@Builder
public class Contrasenia {
    @Column(name = "contrasenia", columnDefinition = "VARCHAR(255)")
    private String contrasenia;

    @Column(name = "fechaDeCreacionDeContrasenia", columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaDeCreacionDeContrasenia;

    public Contrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
        this.fechaDeCreacionDeContrasenia = LocalDateTime.now();
    }
    public Contrasenia() {

    }
}
