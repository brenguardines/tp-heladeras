package ar.edu.utn.frba.dds.models.entities.contribuciones;

public enum MotivoDeLaDistribucion {
    DesperfectoEnLaHeladera {
        @Override
        public String toString() {
            return "Desperfecto en la Heladera";
        }
    },
    FaltaDeViandasEnLaHeladeraDeDestino {
        @Override
        public String toString() {
            return "Falta de Viandas en la Heladera de Destino";
        }
    }
}
