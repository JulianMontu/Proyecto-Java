package Clases;

import java.util.ArrayList;

public class SocioRegular extends Socio {
    private static final  double FONDO_INICIAL = 50000;
    private static final  double MAX_FONDOS = 1000000;

    public SocioRegular() {
    }

    public SocioRegular(String nombre, String cedula, String tipoPlan, ArrayList<Factura> facturas, ArrayList<String> autorizados, double maxFondos, double fondos) {
        super(nombre, cedula, tipoPlan, facturas, autorizados, maxFondos, fondos);
    }
}
