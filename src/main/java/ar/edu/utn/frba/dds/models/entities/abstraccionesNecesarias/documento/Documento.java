package ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.documento;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
@Embeddable
public class Documento {
    @Enumerated(EnumType.STRING)
    @Column(name="tipoDocumento")
    private TipoDeDocumento tipoDeDocumento;
    @Column(name = "numeroDeDocumento", columnDefinition = "VARCHAR(8)")
    private String numeroDeDocumento;

    public static Documento of(String tipoDeDocumento){
        Documento documento = new Documento();
        //si el tipo de documento no es alguno del enumerado, se lanza una excepción propia de la clase ENUM
        documento.setTipoDeDocumento(TipoDeDocumento.valueOf(tipoDeDocumento));
        return documento;
    }

    public static Documento of(String tipoDeDocumento, String nroDocumento){
        Documento documento = Documento.of(tipoDeDocumento);
        documento.setNumeroDeDocumento(nroDocumento);
        return documento;
    }
}
