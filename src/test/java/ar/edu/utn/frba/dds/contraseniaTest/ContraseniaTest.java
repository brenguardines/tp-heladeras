package ar.edu.utn.frba.dds.contraseniaTest;
import ar.edu.utn.frba.dds.models.usuario.Contrasenia;
import ar.edu.utn.frba.dds.models.usuario.RolDeUsuario;
import ar.edu.utn.frba.dds.models.usuario.Usuario;
import ar.edu.utn.frba.dds.utils.validadorDeContrasenias.validaciones.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ContraseniaTest {
    /*
    CumplePoliticaDeRotacion rotacion = new CumplePoliticaDeRotacion();
    CumplePoliticaDeLonguitud longuitud = new CumplePoliticaDeLonguitud();
    CumplePoliticaDeCredencialesPorDefectoDeSoftware credencialesPorDefectoDeSoftware = new CumplePoliticaDeCredencialesPorDefectoDeSoftware();
    CumplePoliticaDeDebilidad debil = new CumplePoliticaDeDebilidad();
    CumplePoliticaDeComplejidad complejidad = new CumplePoliticaDeComplejidad();

    @Test
    @DisplayName("La contraseña valida")
    public void contraseniaValidaTest(){
        Contrasenia contrasenia = new Contrasenia("gB4u#Pj9@L2oXs");
        RolDeUsuario rol = RolDeUsuario.ADMINISTRADOR;
        Usuario usuario = new Usuario("usuarioEjemplo", contrasenia, rol);
        Assertions.assertTrue(usuario.getContrasenia().equals("gB4u#Pj9@L2oXs"));
    }

    @Test
    @DisplayName("Contraseña invalida por contraseña debil")
    public void contraseniaInvalidaTest(){
        Assertions.assertFalse(debil.cumpleValidacion(new Contrasenia("password")));
    }
    @Test
    @DisplayName("Contraseña invalida por contraseña Longitud")
    public void contraseniaInvalidaPorLongitudTest(){
        Assertions.assertFalse(longuitud.cumpleValidacion(new Contrasenia("pass")));
    }
    @Test
    @DisplayName("Contraseña invalida por no cumplir credenciales por defecto")
    public void contraseniaInvalidaPorCredencialesTest(){
        Assertions.assertFalse(credencialesPorDefectoDeSoftware.cumpleValidacion(new Contrasenia("Admin")));
    }

    @Test
    @DisplayName("Contraseña que cumple con longitud")
    public void contraseniaValidaPorLongitudTest(){
        Assertions.assertTrue(longuitud.cumpleValidacion(new Contrasenia("contraseniaa")));
    }

    @Test
    @DisplayName("Contraseña que cumple con complejidad y largo")
    public void contraseniaValidaPorComplejidadYLargoTest(){
        Contrasenia contrasenia = new Contrasenia("Contrasenia.1");
        Assertions.assertTrue(complejidad.cumpleValidacion(contrasenia) && longuitud.cumpleValidacion(contrasenia));
    }
    @Test
    @DisplayName("Contraseña que no cumple con complejidad ni largo")
    public void contraseniaInvalidaPorComplejidadYLargoTest(){
        Contrasenia contrasenia = new Contrasenia("pass");
        Assertions.assertFalse(complejidad.cumpleValidacion(contrasenia) && longuitud.cumpleValidacion(contrasenia));
    }

    @Test
    @DisplayName("Contraseña que no cumple con rotación")
    public void contraseniaInvalidaPorRotacionTest(){
        Assertions.assertFalse(rotacion.cumpleValidacion(new Contrasenia("pass", LocalDateTime.now().minusMonths(5))));
    }

     */
}
