package ar.edu.utn.frba.dds.utils.validadorDeContrasenias.validaciones;

import ar.edu.utn.frba.dds.models.usuario.Contrasenia;

import java.time.LocalDateTime;

public class CumplePoliticaDeRotacion implements Validacion {
    @Override
    public boolean cumpleValidacion(Contrasenia contrasenia) {
        LocalDateTime fechaActual = LocalDateTime.now();

        if (fechaActual.minusMonths(3).isAfter(contrasenia.getFechaDeCreacionDeContrasenia())) {
            System.out.print("La contraseña " + contrasenia.getContrasenia() + " es invalida, ya que no cumple con las Politicas de Rotación.\n");
            return false; // hay que cambiar contraseñia
        }

        return true; // NO hay que cambiar contraseñia
    }

}