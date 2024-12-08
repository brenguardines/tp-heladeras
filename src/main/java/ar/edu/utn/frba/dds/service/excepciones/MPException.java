package ar.edu.utn.frba.dds.service.excepciones;

public class MPException extends Exception {

    // Constructor que acepta solo un mensaje
    public MPException(String message) {
        super(message);
    }

    // Constructor que acepta un mensaje y una excepción original
    public MPException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor que solo acepta una excepción original
    public MPException(Throwable cause) {
        super(cause);
    }
}
