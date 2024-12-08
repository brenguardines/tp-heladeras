package ar.edu.utn.frba.dds.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Initializer {
    public static void init(String sqlFilePath, String dbUrl, String user, String password) throws Exception {
        try (Connection connection = DriverManager.getConnection(dbUrl, user, password);
             Statement statement = connection.createStatement()) {

            // Leer el archivo SQL
            String sql = Files.readString(Path.of(sqlFilePath));

            // Ejecutar cada instrucción del archivo SQL
            for (String query : sql.split(";")) {
                if (!query.trim().isEmpty()) {
                    statement.execute(query);
                }
            }
            System.out.println("Datos cargados exitosamente.");
        }
    }
}
