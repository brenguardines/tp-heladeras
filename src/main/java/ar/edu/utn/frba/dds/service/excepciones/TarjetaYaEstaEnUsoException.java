package ar.edu.utn.frba.dds.service.excepciones;

public class TarjetaYaEstaEnUsoException extends RuntimeException {
    public TarjetaYaEstaEnUsoException(String s) {
        super(s);
    }
}
