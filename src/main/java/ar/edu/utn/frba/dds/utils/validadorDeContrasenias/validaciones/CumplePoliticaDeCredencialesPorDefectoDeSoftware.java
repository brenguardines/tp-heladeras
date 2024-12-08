package ar.edu.utn.frba.dds.utils.validadorDeContrasenias.validaciones;

import ar.edu.utn.frba.dds.models.usuario.Contrasenia;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CumplePoliticaDeCredencialesPorDefectoDeSoftware implements Validacion{
    @Override
    public boolean cumpleValidacion(Contrasenia contrasenia) {
        final Set<String> BLACKLISTED_PASSWORDS = new HashSet<>(
                Arrays.asList("admin", "root", "administrator", "admin.123", "system", "localroot"));

        if (BLACKLISTED_PASSWORDS.contains(contrasenia.getContrasenia().toLowerCase())) {
            System.out.print("La contraseña " + contrasenia.getContrasenia() + " es invalida, ya que no cumple con las Politicas de Credenciales Por Defecto De Software.\n");
            return false;
        }
        return true;
    }
}
