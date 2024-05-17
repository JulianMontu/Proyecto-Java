package Clases;

import java.util.ArrayList;

public class SocioVip extends Socio {
    private static final  double FONDO_INICIAL = 100000;
    private static final  double MAX_FONDOS = 5000000;

    public SocioVip() {
    }

    public SocioVip(String nombre, String cedula, double fondos, String tipoPlan) {
        super(nombre, cedula, fondos, tipoPlan);
        super.setFondos(FONDO_INICIAL);
    }

    public SocioVip(String nombre, String cedula, String tipoPlan, ArrayList<Factura> facturas, ArrayList<String> autorizados, double maxFondos, double fondos) {
        super(nombre, cedula, tipoPlan, facturas, autorizados, maxFondos, fondos);
    }


}
