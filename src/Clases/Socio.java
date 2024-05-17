package Clases;
import java.util.ArrayList;
import java.util.List;

    public class Socio {
        private String nombre;
        private String cedula;
        private double fondos;
        private double maxFondos;
        private String tipoPlan;
        private ArrayList<Factura> facturas;
        private ArrayList<String> autorizados;


        public Socio() {
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
    }

