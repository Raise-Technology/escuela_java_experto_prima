/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Consultas  {
    DefaultTableModel modelo; //Modelo de la tabla
    public void consulta(){
        String encabezados[] = {"Nombre", "Dirección", "Telefono", "Correo", "País", "Edad", "Sexo"};
        String fila[] = new String[7];
        
        modelo = new DefaultTableModel(null, encabezados);
        
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conexion = mysql.conectar();
        
        String query = "SELECT * FROM maestros";
        
        Statement st;
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            //Valida un unico registro del query
            //rs.first(); //jalar el valor del query
            
            while(rs.next()){
            
                fila[0] = rs.getString("nombre");
                fila[1] = rs.getString("direccion");
                fila[2] = rs.getString("telefono");
                fila[3] = rs.getString("correo");
                fila[4] = rs.getString("pais");
                fila[5] = rs.getString("edad");
                fila[6] = rs.getString("sexo");

                modelo.addRow(fila); //asignamos el arreglo al modelo
            } //while
            //tblMaestros.setModel(modelo); //asignamos el arreglo a la tabla
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    public void consultaNombre(String nombre){
        String encabezados[] = {"Nombre", "Dirección", "Telefono", "Correo", "País", "Edad", "Sexo"};
        String fila[] = new String[7];
        
        modelo = new DefaultTableModel(null, encabezados);
        
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conexion = mysql.conectar();
        
        String query = "SELECT * FROM maestros WHERE nombre LIKE '%"+nombre+"%'";
        
        Statement st;
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            //Valida un unico registro del query
            //rs.first(); //jalar el valor del query
            
            while(rs.next()){
            
                fila[0] = rs.getString("nombre");
                fila[1] = rs.getString("direccion");
                fila[2] = rs.getString("telefono");
                fila[3] = rs.getString("correo");
                fila[4] = rs.getString("pais");
                fila[5] = rs.getString("edad");
                fila[6] = rs.getString("sexo");

                modelo.addRow(fila); //asignamos el arreglo al modelo
            } //while
            //tblMaestros.setModel(modelo); //asignamos el arreglo a la tabla
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
