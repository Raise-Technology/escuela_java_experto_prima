/*
 * En esta clase se definen las caracteristivas en java previamente diseñadas en nuestra
    base de datos escuela Tabla maestros
24/02/2018
    @author Arkanakin
 */
package Controllers;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Maestros {
    private int maestro_id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String pais;
    private int edad;
    private String sexo;

    public int getMaestro_id() {
        return maestro_id;
    }

    public void setMaestro_id(int maestro_id) {
        this.maestro_id = maestro_id;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public boolean guardarMaestro(Maestros guardar){
        
        boolean insercion = false;
        //Generamos la conexión
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conexion = mysql.conectar();
        System.out.println(conexion);
        
        String query = "INSERT INTO maestros (nombre, direccion, telefono, correo, pais, edad, sexo,"
                +"creo_usuario_id, fecha_creacion) "
                + " VALUES (?, ?, ?, ?, ?, ?, ?, 1, NOW())"; //NOW agrega la fecha del server del momento
        
        try {
            PreparedStatement manejadorQuery = conexion.prepareCall(query);
            
            manejadorQuery.setString(1, guardar.getNombre());
            manejadorQuery.setString(2, guardar.getDireccion());
            manejadorQuery.setString(3, guardar.getTelefono());
            manejadorQuery.setString(4, guardar.getCorreo());
            manejadorQuery.setString(5, guardar.getPais());
            manejadorQuery.setInt(6, guardar.getEdad());
            manejadorQuery.setString(7, guardar.getSexo());
            
            int resultado = manejadorQuery.executeUpdate();
            
            if(resultado >0){
                insercion = true;
            }else{
                insercion = false;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return insercion;
    }
    
}
