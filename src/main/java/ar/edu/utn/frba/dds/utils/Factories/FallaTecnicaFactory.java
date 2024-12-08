package ar.edu.utn.frba.dds.utils.Factories;

import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.NombreYApellido;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.documento.Documento;
import ar.edu.utn.frba.dds.models.entities.abstraccionesNecesarias.medioDeContacto.MedioDeContacto;
import ar.edu.utn.frba.dds.models.entities.colaboradores.PersonaHumana;
import ar.edu.utn.frba.dds.models.entities.heladera.Heladera;
import ar.edu.utn.frba.dds.models.entities.incidentes.FallaTecnica;

import java.time.LocalDate;

public class FallaTecnicaFactory {
    public static FallaTecnica create(String descripcion, Heladera heladera, PersonaHumana personaHumana, String foto) {
        return new FallaTecnica(descripcion, heladera,personaHumana, foto);
    }

    public static FallaTecnica create(String descripcion, Heladera heladera, PersonaHumana personaHumana) {
        FallaTecnica falla = new FallaTecnica();
        falla.setDescripcion(descripcion);
        falla.setHeladera(heladera);
        falla.setPersonaHumana(personaHumana);
        return falla;
    }

}
