package Clases;

public class Factura {
    private String concepto;
    private double valor;
    private String nombreSocio;


    public Factura(double valor, String concepto, String nombreSocio) {
        this.valor = valor;
        this.concepto = concepto;
        this.nombreSocio = nombreSocio;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }
}
