package ar.edu.utn.frba.dds.server.handlers;

import ar.edu.utn.frba.dds.service.excepciones.AccessDeniedException;
import io.javalin.Javalin;



public class AccessDeniedHandler implements IHandler {

    @Override
    public void setHandle(Javalin app) {
        //atrapando la excepción
        app.exception(AccessDeniedException.class, (e, context) -> {
            context.status(401);
            context.render("/erroresConCodigo/error.hbs");
        });
    }
}