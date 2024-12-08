package ar.edu.utn.frba.dds.utils.validadorDeContrasenias.validaciones;

import ar.edu.utn.frba.dds.models.usuario.Contrasenia;

import java.util.regex.Pattern;

public class CumplePoliticaDeComplejidad implements Validacion {
    @Override
    public boolean cumpleValidacion(Contrasenia contrasenia) {
        Pattern SPECIAL_CHAR = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]");
        Pattern DIGIT = Pattern.compile("[0-9]");
        Pattern UPPER_CASE = Pattern.compile("[A-Z]");
        Pattern LOWER_CASE = Pattern.compile("[a-z]");

        /* verificaciones de que la contraseña contenga al menos una minúscula, mayúscula, un número, un caracter espercial,
        no sea null o espacios en blanco ni tenga caracteres secuenciales */

        if (!LOWER_CASE.matcher(contrasenia.getContrasenia()).find()
                || !UPPER_CASE.matcher(contrasenia.getContrasenia()).find()
                || !DIGIT.matcher(contrasenia.getContrasenia()).find()
                || !SPECIAL_CHAR.matcher(contrasenia.getContrasenia()).find()
                || contrasenia.getContrasenia() == null
                || contrasenia.getContrasenia().isBlank()
                || contieneCaracteresSecuenciales(contrasenia.getContrasenia())) {

            System.out.print("La contraseña " + contrasenia.getContrasenia() + " es invalida, ya que no cumple con las Politicas de Complejidad.\n");
            return false;
        }

        return true;
    }

    protected boolean contieneCaracteresSecuenciales(String contrasenia) {
        int secuenciaMaximaPermitida = 3;  // Longitud máxima de la secuencia permitida
        int secuenciaActual = 1;
        for (int i = 1; i < contrasenia.length(); i++) {
            if (contrasenia.charAt(i) == contrasenia.charAt(i - 1) + 1) {

                secuenciaActual++;

                if (secuenciaActual > secuenciaMaximaPermitida) {
                    return true;
                }

            } else {
                secuenciaActual = 1;
            }
        }

        return false;
    }
}