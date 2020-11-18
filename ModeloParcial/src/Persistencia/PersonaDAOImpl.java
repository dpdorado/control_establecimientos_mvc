/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Conexion.GestorBD;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sistema
 */
public class PersonaDAOImpl implements IPersonaDAO {
    
    private GestorBD gestor;
    
    public PersonaDAOImpl(){
        this.gestor = new GestorBD();
    }
    
    @Override
    public boolean resgistrar(Persona per) {
        boolean resultado=false;        
        String consulta = "INSERT INTO personas (identificacion, nombres, apellidos, telefono, temperatura) values ("+per.getIdentificacion()+",'"+per.getNombre()+"','"+per.getApellidos()+"','"+per.getTelefono()+"',"+per.getTemperatura()+")";
        if (this.gestor.openConnection()){
            resultado=this.gestor.executeUpdate(consulta); 
            this.gestor.closeConnection();
        }                                            
        return resultado; 
    }  

    @Override
    public boolean actualizar(Date fecha) {
        boolean resultado=false;
        //TODO: hacer consulta
        /*String consulta = "UPDATE USUARIOS_ANTEPROYECTO SET "+IConstantes.CONCEPTO+"="+object.get(IConstantes.CONCEPTO) +" WHERE "
                    + ""+IConstantes.CODIGO_ANTEPROYECTO+"="+object.get(IConstantes.CODIGO_ANTEPROYECTO)+"";                    */
        String consulta =null;
        if (this.gestor.openConnection()){
            resultado=this.gestor.executeUpdate(consulta); 
            this.gestor.closeConnection();
        }                                            
        return resultado; 
    }
    
}
