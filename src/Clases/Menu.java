package Clases;

import javax.swing.*;
import java.util.ArrayList;

public class Menu {
    public ArrayList<Usuario> usuarios;

    public Menu() {
        usuarios = new ArrayList<Usuario>();
    }


    public void inicio() {
        Usuario usuario = new Usuario("Miguel","1234");
        this.usuarios.add(usuario);

        String pUsuario = (String) JOptionPane.showInputDialog(null, "Ingrese su Usuario");
        String pPassword = (String) JOptionPane.showInputDialog(null, "Ingrese su Password");

        if(pUsuario.equals(usuario.getUsuario()) && pPassword.equals(usuario.getPassword())) {
            JOptionPane.showMessageDialog(null, "Bienvenido");
        }
        else {
            JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecta","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
