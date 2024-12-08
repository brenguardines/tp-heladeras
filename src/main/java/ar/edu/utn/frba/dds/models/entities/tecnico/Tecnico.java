package ar.edu.utn.frba.dds.models.entities.tecnico;

import java.util.List;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.Persistente;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.documento.Documento;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.NombreYApellido;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.TipoDeMedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.direccion.UbicacionConRadio;
import ar.edu.utn.frba.dds.models.entities.incidentes.VisitaTecnico;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Entity
@Table(name = "tecnico")
public class Tecnico extends Persistente {

    @Embedded
    private NombreYApellido nombreYApellido;

    @Getter
    @OneToMany
    @JoinColumn(name = "tecnico_id")
    private List<MedioDeContacto> medioDeContacto;

    @Embedded
    private Documento documento;

    @Column(name = "cuil", columnDefinition = "VARCHAR(11)")
    private String cuil;

    @Embedded
    private UbicacionConRadio areaDeCobertura;

    @Setter
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "tecnico")
    private List<VisitaTecnico> visitasRealizadas;

    public void agregarMedioDeContacto(MedioDeContacto medio) {
        medioDeContacto.add(medio);
    }
}
