package ar.edu.utn.frba.dds.middelwares;

import ar.edu.utn.frba.dds.models.usuario.RolDeUsuario;
import ar.edu.utn.frba.dds.service.excepciones.AccessDeniedException;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class AuthMiddleware {

    public static void apply(Javalin app) {
        app.beforeMatched(ctx -> {
            var userRole = getUserRoleType(ctx);
            if (!ctx.routeRoles().isEmpty() && !ctx.routeRoles().contains(userRole)) {
                throw new AccessDeniedException();
            }
        });
    }

    private static RolDeUsuario getUserRoleType(Context context) {
        return context.sessionAttribute("tipoRol") != null?
                RolDeUsuario.valueOf(context.sessionAttribute("tipoRol")) : null;
    }
}