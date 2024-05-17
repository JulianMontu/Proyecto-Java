package Clases;
import Interfaz.ISocio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

    public class Socio implements ISocio {
        private String nombre;
        private String cedula;
        private double fondos;
        private double maxFondos;
        private String tipoPlan;
        private ArrayList<Factura> facturas = new ArrayList();
        private ArrayList<String> autorizados;


        public Socio() {
            facturas = new ArrayList<Factura>();
        }

        public Socio(String nombre, String cedula, String tipoPlan) {
            this.nombre = nombre;
            this.cedula = cedula;
            this.tipoPlan = tipoPlan;
        }

        public Socio(String nombre, String cedula, double fondos, String tipoPlan) {
            this.nombre = nombre;
            this.cedula = cedula;
            this.fondos = fondos;
            this.tipoPlan = tipoPlan;
        }

        public Socio(String nombre, String cedula, String tipoPlan, ArrayList<Factura> facturas, ArrayList<String> autorizados, double maxFondos, double fondos) {
            this.nombre = nombre;
            this.cedula = cedula;
            this.tipoPlan = tipoPlan;
            this.facturas = facturas;
            this.autorizados = autorizados;
            this.maxFondos = maxFondos;
            this.fondos = fondos;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCedula() {
            return cedula;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }

        public double getFondos() {
            return fondos;
        }

        public void setFondos(double fondos) {
            this.fondos = fondos;
        }

        public double getMaxFondos() {
            return maxFondos;
        }

        public String getTipoPlan() {
            return tipoPlan;
        }

        public void setTipoPlan(String tipoPlan) {
            this.tipoPlan = tipoPlan;
        }

        @Override
        public void registrarConsumo(String pNombre, String pConcepto, double pValor, double pFondos) {
            this.fondos = pFondos;
            if( pValor > this.fondos )
            {
                JOptionPane.showMessageDialog(null,"El socio no posee fondos suficientes para este consumo");

            }
            else
            {

                Factura nuevaFactura = new Factura(pValor, pConcepto, pNombre);
                facturas.add( nuevaFactura );
                JOptionPane.showMessageDialog(null,"Consumo registrado exitosamente ");
            }
        }

        @Override
        public double pagarFactura(int pIndiceFactura, double pFondos) {
            fondos = pFondos;

            Factura factura = facturas.get( pIndiceFactura );
            if( factura.getValor( ) > fondos )
            {
                JOptionPane.showMessageDialog(null, "El socio no posee fondos suficientes para pagar esta factura" );
                return fondos;
            }
            else
            {
                fondos = fondos - factura.getValor( );
                facturas.remove( pIndiceFactura );
                JOptionPane.showMessageDialog(null, "Factura pagada" );
            }
            return fondos;
        }

        public List<String> estadoDeSocio(Socio socio){
            List<String> estadoSocios = new ArrayList<String>();
            String conceptoCompelto;
            String conceptoFinal;
            double total = 0;
            for (int i=0; i<facturas.size(); i++){
                conceptoCompelto = facturas.get(i).conceptoCompleto();
                total =+ facturas.get(i).getValor();
                estadoSocios.add(conceptoCompelto);
            }
            conceptoFinal = "Total: " + String.valueOf(total);;
            estadoSocios.add(conceptoFinal);
            return estadoSocios;
        }



    }

