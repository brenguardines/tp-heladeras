package ar.edu.utn.frba.dds.donarOfertaTest;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.TipoDeMedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.colaboradores.TipoDePersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.contribuciones.DonacionDeOferta;
import ar.edu.utn.frba.dds.models.entities.oferta.Oferta;
import ar.edu.utn.frba.dds.models.entities.rubro.Rubro;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DonarOfertaTest {
    /*

    private Rubro gastronomia = new Rubro("Gastronomia", "Comida y utensillos de cocina");
    private Rubro electronica = new Rubro("Electronica", "Elementos que se enchufan o tienen pilas");

    PersonaJuridica chefsito = new PersonaJuridica(
                                            "Chefsito",
                                            TipoDePersonaJuridica.EMPRESA,
                                            gastronomia,
                                            new MedioDeContacto(TipoDeMedioDeContacto.NUMERO_DE_TELEFONO, "1166666667"),
                            null,
                                            new Usuario("chefsito123", "gB4u#Pj9@L2oXs")
                                            );

    PersonaJuridica sonycMusic = new PersonaJuridica(
            "Sonyc Music",
            TipoDePersonaJuridica.EMPRESA,
            electronica,
             List.of(new MedioDeContacto(TipoDeMedioDeContacto.NUMERO_DE_TELEFONO, "1166666667"),
                     new MedioDeContacto(TipoDeMedioDeContacto.CORREO, "sonycMusicDoReMi@gmail.com")),
            null,
            new Usuario("sonycMusicFaSolLaSi", "eB4u@Sj9#L3oXs")
    );
    Oferta pelaPapa = new Oferta("Pela papa", 30.1);
    Oferta auricularesSonyc3000 = new Oferta("Auriculares Sonyc 3000", 3004.73);

    @Test
    @DisplayName("Chefsito donó un \"Pela papa\".")
    public void contraseniaValidaTest(){
        DonacionDeOferta donarPelaPapa = new DonacionDeOferta(chefsito, pelaPapa);
        chefsito.hacerDonacion(donarPelaPapa);
        Assertions.assertTrue(chefsito.getDonacionesDeOfertas().contains(donarPelaPapa));
    }

    @Test
    @DisplayName("Sonyc Music donó unos \"Auriculares Sonyc 3000\".")
    public void sonyDonaAusicularesTest(){
        DonacionDeOferta donarAuricularesSonyc3000 = new DonacionDeOferta(sonycMusic, auricularesSonyc3000);
        sonycMusic.hacerDonacion(donarAuricularesSonyc3000);
        Assertions.assertTrue(sonycMusic.getDonacionesDeOfertas().contains(donarAuricularesSonyc3000));
    }

     */

}
