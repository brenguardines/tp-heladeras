package ar.edu.utn.frba.dds.models.entities.receptores.movimiento;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MensajeMovimiento {
    Integer idHeladera;
    LocalDateTime fechaHora;
    Double valor;
}
