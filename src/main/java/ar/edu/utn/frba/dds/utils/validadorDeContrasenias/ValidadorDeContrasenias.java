package ar.edu.utn.frba.dds.utils.validadorDeContrasenias;
import ar.edu.utn.frba.dds.models.usuario.Contrasenia;
import ar.edu.utn.frba.dds.utils.validadorDeContrasenias.validaciones.*;

import java.util.*;

public class ValidadorDeContrasenias {
    private List<Validacion> validacionesARealizar;

    public ValidadorDeContrasenias() {
        this.validacionesARealizar = List.of(new CumplePoliticaDeDebilidad(),
                                             new CumplePoliticaDeCredencialesPorDefectoDeSoftware(),
                                             new CumplePoliticaDeComplejidad(),
                                             new CumplePoliticaDeLonguitud(),
                                             new CumplePoliticaDeRotacion()
                                            );
    }

    public boolean contraseniaValida(Contrasenia contrasenia) {
        return this.validacionesARealizar.stream().allMatch(validacion -> validacion.cumpleValidacion(contrasenia));
    }
}