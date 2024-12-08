package ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mensaje {
    private String asunto;
    private String mensaje;

    public Mensaje(String asunto, String mensaje) {
        this.asunto = asunto;
        this.mensaje = mensaje;
    }
    public Mensaje(){}
}
