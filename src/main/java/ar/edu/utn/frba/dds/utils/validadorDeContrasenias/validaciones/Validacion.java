package ar.edu.utn.frba.dds.utils.validadorDeContrasenias.validaciones;

import ar.edu.utn.frba.dds.models.usuario.Contrasenia;

public interface Validacion {
    public boolean cumpleValidacion(Contrasenia contrasenia);
}