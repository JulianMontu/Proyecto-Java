package Clases;

import Interfaz.IClub;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Club implements IClub {
    public final static int MAXIMO_VIP = 3;
    private ArrayList<Socio> socios;
    private ArrayList<SocioVip> sociosVIP;
    private ArrayList<SocioRegular> sociosRegular;


    public Club() {
        socios = new ArrayList<Socio>();
        sociosVIP = new ArrayList<SocioVip>();
        sociosRegular = new ArrayList<SocioRegular>();

    }

    @Override
    public boolean afiliarSocio(String pCedula, String pNombre, String pTipo) {
        // Revisar que no haya ya un socio con la misma cédula
        Socio isNull = buscarSocio(pCedula);
        pTipo = pTipo.toUpperCase();
        if (pTipo.equals("VIP") && contarSociosVIP() == MAXIMO_VIP) {
            JOptionPane.showMessageDialog(null, "El club en el momento no acepta más socios VIP");
            return false;
        }

        // Revisar que no se haya alcanzado el límite de subscripciones VIP
        if (isNull == null) {
            // Se crea el objeto del nuevo socio (todavía no se ha agregado al club)
            Socio nuevoSocio = new Socio(pNombre, pCedula, pTipo);

            if (nuevoSocio.getTipoPlan().equals("VIP")) {
                SocioVip socioVip = new SocioVip(pNombre, pCedula, 0, pTipo);
                sociosVIP.add(socioVip);
            } else {
                SocioRegular socioRegular = new SocioRegular(pNombre, pCedula, 0, pTipo);
                sociosRegular.add(socioRegular);
            }
            // Se agrega el nuevo socio al club
            socios.add(nuevoSocio);
            JOptionPane.showMessageDialog(null, "Socio agregado correctamente");
            return true;
        }

        JOptionPane.showMessageDialog(null, "El socio ya existe");
        return false;

    }

    @Override
    public Socio buscarSocio(String pCedulaSocio) {
        Socio elSocio = null;

        int numSocios = socios.size();
        for (int i = 0; i < numSocios; i++) {
            String cedula = socios.get(i).getCedula();
            if (cedula.toLowerCase().equals(pCedulaSocio.toLowerCase())) {
                return elSocio = socios.get(i);
            }
        }

        return elSocio;
    }

    public SocioVip buscarSocioVIP(String pCedulaSocio) {
        SocioVip elSocio = null;

        int numSocios = sociosVIP.size();
        for (int i = 0; i < numSocios; i++) {
            String cedula = sociosVIP.get(i).getCedula();
            if (cedula.toLowerCase().equals(pCedulaSocio.toLowerCase())) {
                return elSocio = sociosVIP.get(i);
            }
        }

        return elSocio;
    }

    public SocioRegular buscarSocioRegular(String pCedulaSocio) {
        SocioRegular elSocio = null;

        int numSocios = sociosRegular.size();
        for (int i = 0; i < numSocios; i++) {
            String cedula = sociosRegular.get(i).getCedula();
            if (cedula.toLowerCase().equals(pCedulaSocio.toLowerCase())) {
                return elSocio = sociosRegular.get(i);
            }
        }

        return elSocio;
    }

    @Override
    public void registrarConsumo(String pCedulaSocio, String pNombreCliente, String pConcepto, double pValor) {
        Socio s = buscarSocio( pCedulaSocio );
        if (s.getTipoPlan().equals("VIP")){
            SocioVip sVIP = buscarSocioVIP(s.getCedula());
            s.registrarConsumo( pNombreCliente, pConcepto, pValor, sVIP.getFondos() );
        }
        else {

            SocioRegular sRegular = buscarSocioRegular(s.getCedula());
            s.registrarConsumo( pNombreCliente, pConcepto, pValor, sRegular.getFondos());
        }

    }

    @Override
    public void pagarFacturaSocio(String pCedulaSocio, int pFacturaIndice) {
        double nuevoValorDeFondos;
        Socio s = buscarSocio( pCedulaSocio );

        if (pFacturaIndice == 1){
            pFacturaIndice = 0;
        }

        if (s.getTipoPlan().equals("VIP")){
            SocioVip sVIP = buscarSocioVIP(s.getCedula());
            nuevoValorDeFondos = s.pagarFactura( pFacturaIndice, sVIP.getFondos() );
            sVIP.setFondos(nuevoValorDeFondos);
        }
        else {
            SocioRegular sRegular = buscarSocioRegular(s.getCedula());
            nuevoValorDeFondos = s.pagarFactura( pFacturaIndice , sRegular.getFondos());
            sRegular.setFondos(nuevoValorDeFondos);
        }

    }

    public void estadoDeSocio(String pCedulaSocio){
        Socio s = buscarSocio( pCedulaSocio );
        JOptionPane.showMessageDialog(null,s.estadoDeSocio(s));
    }

    public int contarSociosVIP() {
        return sociosVIP.size();
    }

    public void mostrarEstadoFinanciero() {
        List<String> estadoFinanciero = new ArrayList<>();

        for (Socio socio : socios) {
            List<String> estadoDeSocio = socio.estadoDeSocio(socio);
            estadoFinanciero.addAll(estadoDeSocio);
            estadoFinanciero.add("");  // Añadir una línea en blanco entre los socios para mayor claridad
        }

        JOptionPane.showMessageDialog(null,estadoFinanciero);
    }
}
