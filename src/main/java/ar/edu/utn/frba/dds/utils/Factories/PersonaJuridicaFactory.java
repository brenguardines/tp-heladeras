package ar.edu.utn.frba.dds.utils.Factories;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.TipoDeMedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.colaboradores.TipoDePersonaJuridica;
import ar.edu.utn.frba.dds.models.entities.direccion.Direccion;
import ar.edu.utn.frba.dds.models.entities.rubro.Rubro;
import ar.edu.utn.frba.dds.models.entities.formulario.FormularioRespondido;
import ar.edu.utn.frba.dds.models.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class PersonaJuridicaFactory {

    public static PersonaJuridica create(String razonSocial, TipoDePersonaJuridica tipo, Rubro rubro) {
        return new PersonaJuridica(razonSocial, tipo, rubro, new ArrayList<>(), null, null);
    }

    public static PersonaJuridica create(String razonSocial, TipoDePersonaJuridica tipo, Rubro rubro,
                                         List<MedioDeContacto> mediosDeContacto, FormularioRespondido formulario, Usuario usuario) {
        return new PersonaJuridica(razonSocial, tipo, rubro, mediosDeContacto, formulario, usuario);
    }

    public static PersonaJuridica create(String razonSocial, TipoDePersonaJuridica tipo, Rubro rubro,
                                         MedioDeContacto medioDeContacto, FormularioRespondido formulario, Usuario usuario) {
        return new PersonaJuridica(razonSocial, tipo, rubro, medioDeContacto, formulario, usuario);
    }

    public static PersonaJuridica create(String razonSocial, MedioDeContacto medioDeContacto, Direccion direccion){
        PersonaJuridica personaJuridica = new PersonaJuridica();
        personaJuridica.setRazonSocial(razonSocial);
        personaJuridica.aniadirMedioDeContacto(medioDeContacto);
        personaJuridica.setDireccion(direccion);
        return personaJuridica;
    }
}
