/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionMysql;

import InterfazGrafica.Login;
import InterfazGrafica.frmPrincipal;
import java.awt.HeadlessException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rudy Bravo
 */
public class ClLogin {

    public void validarUsuario(JTextField usuario, JPasswordField password) {

        try {
            ResultSet rs = null;
            PreparedStatement ps = null;
            String consulta = "Select * from tbl_usuarios where usuario_usuario = (?) and contrasenia_usuario = (?)";
            Conexion conexion = new Conexion();
            ps = conexion.conectar().prepareStatement(consulta);
            String contrasenia = String.valueOf(password.getPassword());
            ps.setString(1, usuario.getText());
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Usuario Correcto");

                frmPrincipal menuPrincipal = new frmPrincipal();
                menuPrincipal.setVisible(true);
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
            }

        } catch (HeadlessException | SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error, vuelva a intentarlo" + ex.toString());

        }

    }//fin de validar usuario
}//fin de class login
