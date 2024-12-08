package ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "medioDeContacto")
public class MedioDeContacto extends Persistente {

    @Enumerated(EnumType.STRING)
    @Column(name="tipoMedioContacto")
    private TipoDeMedioDeContacto tipoDeMedioDeContacto;

    @Column(name = "contacto")
    private String contacto;

    public MedioDeContacto(TipoDeMedioDeContacto tipoDeMedioDeContacto, String contacto) {
        this.tipoDeMedioDeContacto = tipoDeMedioDeContacto;
        this.contacto = contacto;
    }

    public MedioDeContacto() {}

    public static MedioDeContacto of(String tipoContacto, String contacto) {
        MedioDeContacto medioDeContacto = new MedioDeContacto();
        medioDeContacto.setContacto(contacto);
        medioDeContacto.setTipoDeMedioDeContacto(TipoDeMedioDeContacto.valueOf(tipoContacto));
        return medioDeContacto;
    }
}
