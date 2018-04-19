/*
 * En esta clase se definen las caracteristivas en java previamente diseñadas en nuestra
    base de datos escuela Tabla grupos
24/02/2018
    @author Arkanakin
 */
package Controllers;

import java.sql.*;

public class Grupos {
    private int grupo_id;
    private int maestro_id;
    private String nombre;
    private String horario;
    private String materia;

    public int getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(int grupo_id) {
        this.grupo_id = grupo_id;
    }

    
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    
}
