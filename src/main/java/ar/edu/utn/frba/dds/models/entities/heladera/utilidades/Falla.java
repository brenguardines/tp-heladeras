package ar.edu.utn.frba.dds.models.entities.heladera.utilidades;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Falla {
    private String descripcion;
    private LocalDateTime fecha;

    public Falla(String descripcion) {
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
    }

    public boolean fechaEntre(LocalDateTime inicio, LocalDateTime fin) {
        return this.fecha.isAfter(inicio) && this.fecha.isBefore(fin);
    }
}
