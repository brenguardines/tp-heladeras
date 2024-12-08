package ar.edu.utn.frba.dds.utils.validadorDeContrasenias.validaciones;
import ar.edu.utn.frba.dds.models.usuario.Contrasenia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CumplePoliticaDeDebilidad implements Validacion {
    @Override
    public boolean cumpleValidacion(Contrasenia contrasenia) {
        // Especifica la ruta del archivo que quieres abrir
        String rutaArchivo = "../2024-tpa-mi-no-grupo-14/src/main/java/ar/edu/utn/frba/dds/utils/validadorDeContrasenias/validaciones/10-million-password-list-top-10000.txt";

        try {
            // Crea un objeto Path con la ruta del archivo
            Path archivo = Paths.get(rutaArchivo);

            // Lee todas las líneas del archivo y las guarda en una lista
            List<String> lineas = Files.readAllLines(archivo);

            // Verifica si contraseña está en el archivo
            for (String linea : lineas) {
                if(contrasenia.getContrasenia().equals(linea)){
                    System.out.print("La contraseña " + contrasenia.getContrasenia() + " es invalida, ya que no cumple con las Politicas de Débilidad.\n");
                    return false; // La contraseña es invalida
                }
            }

            return true; // La contraseña es valida
        }
        catch (IOException error) {
            // Maneja la excepción si ocurre algún problema al leer el archivo
            System.err.println("Error al leer el archivo: " + error.getMessage());
        }

        return true; // lo ponemos porque necesitamos retornar algo fuera del Try-Catch, pero nunca llega a este punto
    }
}
