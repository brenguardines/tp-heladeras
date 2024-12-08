package ar.edu.utn.frba.dds.models.entities.colaboradores;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.contribuciones.*;
import ar.edu.utn.frba.dds.models.entities.direccion.Direccion;
import ar.edu.utn.frba.dds.models.entities.formulario.FormularioRespondido;
import ar.edu.utn.frba.dds.models.entities.rubro.Rubro;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "personaJuridica")
@Entity
@Builder
@AllArgsConstructor
public class PersonaJuridica extends Persistente {

    @Setter
    @Column(name = "razonSocial")
    private String razonSocial;

    @Column(name = "tipo", columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private TipoDePersonaJuridica tipo;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    @Embedded
    private Rubro rubro;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personaJuridica_id", referencedColumnName = "id")
    private List<MedioDeContacto> medioDeContacto;

    @OneToOne
    @JoinColumn(name = "formularioRespondido_id", referencedColumnName = "id")
    private FormularioRespondido formularioRespondido;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "colaboradorJuridico")
    private List<DonacionDeDinero> donacionesDeDinero;

    @OneToMany(mappedBy = "colaborador")
    private List<DonacionDeOferta> donacionesDeOfertas;

    @OneToMany(mappedBy = "colaborador")
    private List<HacerseCargoDeUnaHeladera> hacerseCargoDeHeladeras;

    public PersonaJuridica(String razonSocial,
                           TipoDePersonaJuridica tipo,
                           Rubro rubro,
                           List<MedioDeContacto> medioDeContacto,
                           FormularioRespondido formularioRespondido,
                           Usuario usuario) {
        this.razonSocial = razonSocial;
        this.tipo = tipo;
        this.rubro = rubro;
        this.medioDeContacto = new ArrayList<>(medioDeContacto);
        this.medioDeContacto.addAll(medioDeContacto);
        this.formularioRespondido = formularioRespondido;
        this.usuario = usuario;
        this.donacionesDeDinero = new ArrayList<>();
        this.donacionesDeOfertas = new ArrayList<>();
        this.hacerseCargoDeHeladeras = new ArrayList<>();

    }
    public PersonaJuridica(String razonSocial,
                           TipoDePersonaJuridica tipo,
                           Rubro rubro,
                           MedioDeContacto medioDeContacto,
                           FormularioRespondido formularioRespondido,
                           Usuario usuario) {
        this.razonSocial = razonSocial;
        this.tipo = tipo;
        this.rubro = rubro;
        this.medioDeContacto.add(medioDeContacto);
        this.formularioRespondido = formularioRespondido;
        this.usuario = usuario;
        this.donacionesDeDinero = new ArrayList<>();
        this.donacionesDeOfertas = new ArrayList<>();
        this.hacerseCargoDeHeladeras = new ArrayList<>();
    }

    public PersonaJuridica() {
        this.donacionesDeDinero = new ArrayList<>();
        this.medioDeContacto=new ArrayList<>();
    }
    public void hacerDonacion(DonacionDeOferta donacion) {
        this.donacionesDeOfertas.add(donacion);
        donacion.setColaborador(this);
    }

    public void agregarDonacionDeDinero(DonacionDeDinero donacionDeDinero){
        this.donacionesDeDinero.add(donacionDeDinero);
        donacionDeDinero.setColaboradorJuridico(this);
    }
    public void hacerseCargoDeUnaHeladera(HacerseCargoDeUnaHeladera contribucion) {
        this.hacerseCargoDeHeladeras.add(contribucion);
        contribucion.setColaborador(this);

    }
    public void aniadirMedioDeContacto(MedioDeContacto contacto){
        this.medioDeContacto.add(contacto);
    }

}
