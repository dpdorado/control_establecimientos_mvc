/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Conexion.GestorBD;
import Modelo.Establecimiento;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sistema
 */
public class EstablecimientoDAOImpl implements IEstablecimientoDAO{
    private GestorBD gestor;
    
    
    public EstablecimientoDAOImpl(){
        this.gestor = new GestorBD();
    }
        
    @Override
    public boolean resgistrar(Establecimiento est) {
        boolean resultado=false;        
        String consulta ="INSERT INTO establecimientos (nit, combre_comercial, tipo_establecimiento) values ("+est.getNit()+",'"+est.getnComercial()+"','"+est.gettEstablecimineto()+"')";
        if (this.gestor.openConnection()){
            resultado=this.gestor.executeUpdate(consulta); 
            this.gestor.closeConnection();
        }                                            
        return resultado; 
    }

    @Override
    public boolean actualizar(int nit, String tipo) {        
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

    @Override
    public ArrayList<Persona> bucarPersonasFecha(int nit, Date fecha) {
        ArrayList<Persona> personas = new ArrayList<Persona>();
        //TODO: HAcer consulata
        String consulta = null;
        //String consulta="SELECT ID_ANTEPROYECTO, TITULO FROM ANTEPROYECTO";
        ResultSet rs = null;
        
        if (this.gestor.openConnection()){
            try {
                rs=this.gestor.executeQuery(consulta);
                while(rs.next()){
                    Persona per = new Persona();
                    per.setIdentificacion(rs.getInt(1));
                    per.setNombre(rs.getString(2));
                    per.setApellidos(rs.getString(3));
                    per.setTelefono(rs.getString(4));
                    per.setTemperatura(rs.getInt(5));
                    personas.add(per);
                }                                
                this.gestor.closeConnection();
            } catch (SQLException ex) {
                //TODO: editar mensaje
                Logger.getLogger(EstablecimientoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                                    
        return personas;                
    }

    @Override
    public ArrayList<Establecimiento> buscarEstPersona(Persona per) {
        ArrayList<Establecimiento> establecimientos = new ArrayList<Establecimiento>();
        //TODO: HAcer consulata
        String consulta = null;
        //String consulta="SELECT ID_ANTEPROYECTO, TITULO FROM ANTEPROYECTO";
        ResultSet rs = null;
        
        if (this.gestor.openConnection()){
            try {
                rs=this.gestor.executeQuery(consulta);
                while(rs.next()){
                    Establecimiento est = new Establecimiento();
                    est.setNit(rs.getInt(1));
                    est.setnComercial(rs.getString(2));
                    est.settEstablecimineto(rs.getString(3));
                    establecimientos.add(est);
                }                                
                this.gestor.closeConnection();
            } catch (SQLException ex) {
                //TODO: editar mensaje
                Logger.getLogger(EstablecimientoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                                    
        return establecimientos;        
    }
}
