package ar.edu.utn.frba.dds.models.entities.receptores.temperatura;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class MensajeTemperatura {
    Integer id;
    Double temperatura;
    LocalDateTime fechaHora;
}
