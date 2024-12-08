package ar.edu.utn.frba.dds.utils.builders;
/*
import ar.edu.utn.frba.dds.models.community.Community;
import ar.edu.utn.frba.dds.models.community_member.CommunityMember;
import ar.edu.utn.frba.dds.models.entities_establishment.Establishment;
import ar.edu.utn.frba.dds.models.proximity_finder.CustomProximityFinder;
import ar.edu.utn.frba.dds.models.services.Service;
import net.bytebuddy.implementation.bytecode.Throw;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
*/
public class CommunityBuilder {
    // EJEMPLO DE UN BUILDER
    /*
    private Community community = new Community();


    public CommunityBuilder withName(String name) {
        this.community.setName(name);
        return this;
    }

    public CommunityBuilder withInteretingServices(Service... services) {
        this.community.addInteretingServices(services);
        return this;
    }

    public CommunityBuilder withMembers(CommunityMember ... members) {
        this.community.addCommunityMember(members);
        return this;
    }

    public CommunityBuilder withCustomProximityFinder(CustomProximityFinder customProximityFinder) {
        this.community.setCustomProximityFinder(customProximityFinder);
        return this;
    }

    public CommunityBuilder withInteretingEstablishment(Establishment... establishments) {
        this.community.addInteretingEstablishments(establishments);
        return this;
    }

    public CommunityBuilder withDescription(String description) {
        this.community.setDescription(description);
        return this;
    }


    public Community build(){
        // validaciones si necesitamos

        List<String> errores = new ArrayList<String>();

        if(!this.community.getName().equals(null)){
            errores.add("paso tal cosa");
        }

        if( errores.size() > 0){
            // agarro todos los strings y lanzo excepcion de todos concatenados.
            throw new RuntimeException("error");
        }


            // si quiero aca puedo configurar valores por defecto para la clase comunidad.

        return this.community;
    }
*/

}

