package ar.edu.utn.frba.dds.models.entities.contribuciones;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name="donacionDeDinero")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class DonacionDeDinero extends Persistente {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaHumana_id")
    private PersonaHumana colaboradorHumano;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaJuridica_id")
    private PersonaJuridica colaboradorJuridico;

    @Column(name = "fechaColaboracion", columnDefinition = "DATE")
    private LocalDate fechaDeColaboracion;

    @Column(name = "monto", columnDefinition = "DOUBLE")
    private Double monto;

    @Enumerated(EnumType.STRING)
    private FrecuenciaDeDonacionDeDinero frecuencia;

    @Column(name = "mercadoPagoId")
    private String mercadoPagoId;  // ID de la transacción en Mercado Pago

    public DonacionDeDinero() {}
    public DonacionDeDinero(Double monto, FrecuenciaDeDonacionDeDinero frecuencia, String mercadoPagoId) {
        this.monto = monto;
        this.frecuencia = frecuencia;
        this.fechaDeColaboracion = LocalDate.now();
        this.mercadoPagoId = mercadoPagoId;
    }

    public static DonacionDeDinero of(PersonaHumana personaHumana){
        DonacionDeDinero donacion = new DonacionDeDinero();
        donacion.setColaboradorHumano(personaHumana);
        return donacion;
    }

    public static DonacionDeDinero of(PersonaJuridica personaJuridica){
        DonacionDeDinero donacion = new DonacionDeDinero();
        donacion.setColaboradorJuridico(personaJuridica);
        return donacion;
    }

    public static DonacionDeDinero of(PersonaHumana personaHumana, Double monto, LocalDate fecha, FrecuenciaDeDonacionDeDinero frecuenciaDeDonacionDeDinero){
        DonacionDeDinero donacion = new DonacionDeDinero();
        donacion.setColaboradorHumano(personaHumana);
        donacion.setMonto(monto);
        donacion.setFechaDeColaboracion(LocalDate.now());
        donacion.setFechaDeColaboracion(fecha);
        donacion.setFrecuencia(frecuenciaDeDonacionDeDinero);
        return donacion;
    }
}
