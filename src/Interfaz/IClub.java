package Interfaz;

import Clases.Socio;

public interface IClub {
    public boolean afiliarSocio( String pCedula, String pNombre, String pTipo );
    public Socio buscarSocio(String pCedulaSocio );
    public void registrarConsumo( String pCedulaSocio, String pNombreCliente, String pConcepto, double pValor );
    public void pagarFacturaSocio( String pCedulaSocio, int pFacturaIndice );

}
