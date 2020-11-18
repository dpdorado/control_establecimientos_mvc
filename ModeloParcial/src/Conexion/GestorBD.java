/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author sistema
 */
public class GestorBD {
     private Conexion conexion;

    public GestorBD() {
        this.conexion = new Conexion();
    }

    public boolean openConnection() {
        return conexion.conectar() == 1 ? true : false;
    }

    public boolean closeConnection() {
        boolean varResultado = false;
        if (this.conexion != null) {
            this.conexion.desconectar();
            varResultado = true;
        }
        return varResultado;
    }

    public boolean executeUpdate(String consulta) {
        conexion.conectar();
        int resultado = 0;
        try {
            PreparedStatement sentencia = null;
            //String consulta = "insert into empleado(empleado.nombresEmpleado,empleado.apellidosEmpleado,empleado.salarioEmpleado) values(?,?,?)";
            sentencia = conexion.getConnection().prepareStatement(consulta);
            resultado = sentencia.executeUpdate(consulta);
            sentencia.close();
            conexion.desconectar();

        } catch (SQLException e) {
            System.out.println("error en la inserción: " + e.getMessage());
        }
        return resultado == 0 ? false : true;
    }

    public ResultSet executeQuery(String consulta) {
        ResultSet rs = null;
        try {
            int result= conexion.conectar();
            if (result==-1){
                return null;
            }
            PreparedStatement sentencia = null;
            //String consulta = "insert into empleado(empleado.nombresEmpleado,empleado.apellidosEmpleado,empleado.salarioEmpleado) values(?,?,?)";
            sentencia = conexion.getConnection().prepareStatement(consulta);
            rs = sentencia.executeQuery(consulta);
            sentencia.close();
            conexion.desconectar();

        } catch (SQLException e) {
            System.out.println("error en la inserción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error de conexion! "+e);
        }
        return rs;
    }
}
