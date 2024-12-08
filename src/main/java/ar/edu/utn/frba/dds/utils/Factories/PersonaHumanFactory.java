package ar.edu.utn.frba.dds.utils.Factories;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.NombreYApellido;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.documento.Documento;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;

import java.time.LocalDate;

public class PersonaHumanFactory {
    public static PersonaHumana create(String nombre, String apellido){
        PersonaHumana persona = new PersonaHumana();
        persona.setNombreYApellido(NombreYApellido.of(nombre,apellido));
        return persona;
    }

    public static PersonaHumana create(NombreYApellido nombreYApellido, MedioDeContacto contacto, Documento documento){
        PersonaHumana persona = new PersonaHumana();
        persona.setDocumento(documento);
        persona.setNombreYApellido(nombreYApellido);
        persona.aniadirMedioDeContacto(contacto);
        return persona;
    }

    public static PersonaHumana create(NombreYApellido nombreYApellido, MedioDeContacto contacto, Documento documento, LocalDate fechaNacimiento){
        PersonaHumana persona = create(nombreYApellido, contacto, documento);
        persona.setFechaDeNacimiento(fechaNacimiento);
        return persona;
    }
}
