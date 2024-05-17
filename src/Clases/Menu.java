package Clases;

import javax.swing.*;
import java.util.ArrayList;

public class Menu {
    private Club club = new Club();
    private int posicion;
    public ArrayList<Usuario> usuarios;

    public Menu() {
        usuarios = new ArrayList<Usuario>();
    }


    public void inicio() {
        String[] menus = {"Menu Club", "Menu Factura", "Estado Financiero"};
        Usuario usuario = new Usuario("Miguel", "1234");
        this.usuarios.add(usuario);

        String pUsuario = (String) JOptionPane.showInputDialog(null, "Ingrese su Usuario");
        String pPassword = (String) JOptionPane.showInputDialog(null, "Ingrese su Password");
        do {
            if (pUsuario.equals(usuario.getUsuario()) && pPassword.equals(usuario.getPassword())) {
                String opcion = (String) JOptionPane.showInputDialog(null, "Selecionar la opcion", "Conversion", JOptionPane.QUESTION_MESSAGE, null, menus, menus[0]);

                switch (opcion) {
                    case "Menu Club":
                        menuClub();
                        break;
                    case "Menu Factura":
                        menuFacturas();
                        break;
                    case "Estado Financiero":
                        mostrarEstadoFinanciero();
                        break;
                    default:
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (true);
    }

    public void menuClub() {
        String[] menus = {"Afiliar Socio", "Estado Socio"};
        try {
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecionar la opcion", "Conversion", JOptionPane.QUESTION_MESSAGE, null, menus, menus[0]);
            switch (opcion) {
                case "Afiliar Socio":
                    AfiliarSocio();
                    break;
                case "Estado Socio":
                    estadoSocio();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor incorrecto", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void menuFacturas() {
        String[] menus = {"Registrar consumo", "Pagar"};
        try {
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecionar la opcion", "Conversion", JOptionPane.QUESTION_MESSAGE, null, menus, menus[0]);
            switch (opcion) {
                case "Registrar consumo":
                    registrarConsumo();
                    break;
                case "Pagar":
                    pagar();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor incorrecto", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void AfiliarSocio() {
        String[] planes = {"VIP", "Regular"};
        String pNombre = (String) JOptionPane.showInputDialog(null, "Ingrese su Nombre");
        String pCedula = (String) JOptionPane.showInputDialog(null, "Ingrese su Cedula");
        String pTipoPlan = (String) JOptionPane.showInputDialog(null, "Selecionar la opcion", "Conversion", JOptionPane.QUESTION_MESSAGE, null, planes, planes[0]);
        club.afiliarSocio(pCedula, pNombre, pTipoPlan);
    }

    public void registrarConsumo() {
        String pNombre = (String) JOptionPane.showInputDialog(null, "Ingrese su Nombre");
        String pCedula = (String) JOptionPane.showInputDialog(null, "Ingrese su Cedula");
        String pConcepto = (String) JOptionPane.showInputDialog(null, "Ingrese el Concepto");
        double pValor = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor"));
        club.registrarConsumo(pCedula, pNombre,pConcepto,pValor);
    }

    public void pagar() {
        String pCedula = (String) JOptionPane.showInputDialog(null, "Ingrese su Cedula");
        int pIndiceFactura = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el indice de la factura"));
        club.pagarFacturaSocio(pCedula,pIndiceFactura);
    }

    public void estadoSocio() {
        String pCedula = (String) JOptionPane.showInputDialog(null, "Ingrese su Cedula");
        club.estadoDeSocio(pCedula);
    }

    public void mostrarEstadoFinanciero(){
        club.mostrarEstadoFinanciero();
    }


}


