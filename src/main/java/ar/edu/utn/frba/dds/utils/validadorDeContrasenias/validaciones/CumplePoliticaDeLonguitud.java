package ar.edu.utn.frba.dds.utils.validadorDeContrasenias.validaciones;

import ar.edu.utn.frba.dds.models.usuario.Contrasenia;

public class CumplePoliticaDeLonguitud implements Validacion {
    @Override
    public boolean cumpleValidacion(Contrasenia contrasenia) {
        if (contrasenia.getContrasenia().length() < 8 || contrasenia.getContrasenia().length() > 64){
            System.out.print("La contraseña " + contrasenia.getContrasenia() + " es invalida, ya que no cumple con las Politicas de Longitud.\n");
            return false;
        }

        return true;
    }
}