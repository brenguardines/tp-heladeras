package ar.edu.utn.frba.dds.models.usuario;

import io.javalin.security.RouteRole;

public enum RolDeUsuario implements RouteRole {
    ADMINISTRADOR,
    COLABORADOR_HUMANO,
    COLABORADOR_JURIDICO,
    TECNICO

}
