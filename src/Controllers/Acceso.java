package Controllers;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Arkanakin
 */
public class Acceso {
    public static boolean acceso(String correo, String contrasena){
        boolean ingreso = false;
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conexion = mysql.conectar();
        
        String query = "SELECT * FROM usuarios WHERE correo = '"+correo+"'"
                +" AND contrasena = '"+contrasena+"'";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.first()){
                ingreso = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return ingreso;
    }
}
