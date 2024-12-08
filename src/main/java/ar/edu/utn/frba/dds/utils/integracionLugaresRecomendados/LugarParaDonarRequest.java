package ar.edu.utn.frba.dds.utils.integracionLugaresRecomendados;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class LugarParaDonarRequest {

    private String latitud;

    private String longitud;

    private String radio;

    private LocalTime horarioBuscado;

    private String diaBuscado;
}

