package Interfaz;

public interface ISocio {
    public void registrarConsumo( String pNombre, String pConcepto, double pValor,double pFondos);
    public double pagarFactura( int pIndiceFactura, double Fondos );

}
