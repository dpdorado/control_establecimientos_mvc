/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Contenedor;
import Modelo.Establecimiento;
import Modelo.Persona;
import Vista.Consola;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sistema
 */
public class ControladorEstablecimiento {
    //Attributes
    private Contenedor contenedor;
    private Consola consola;

    //Constructor
    public ControladorEstablecimiento(Consola consola, Contenedor contenedor) {
        this.consola = consola;
        this.contenedor = contenedor;
    }
    //Metodos
    
    //Registro de un establecimiento
    public void registrarEstablecimiento(){
        consola.imprimirCabecera("Registro de un Establecimineto");
        Establecimiento est =  consola.pedirEstablecimeinto();
        if (est != null){
            contenedor.registrarEstablecimiento(est);
            consola.imprimirMensaje("Establecimiento registrado correctamente.");
        }else{
            consola.imprimirMensaje("No se pudo registrar el establecimiento, contacte al adminiestrador.");
        }        
    }
    
    //Actualizacion de un establecimiento
    public void actualizarEstablecimiento(){
        ArrayList<Establecimiento> estableciminetos = contenedor.getEstablecimientos();
        Establecimiento e=null;
        int n_est = 0;
        consola.imprimirCabecera("Actualizacion de un establecimiento");
        if (estableciminetos.size()==0){
            consola.imprimirMensaje("No hay establecimientos registrados.");
        }else{
            consola.mostrarEstableciminetos(estableciminetos);
            n_est = consola.seleccionEstablecimiento(estableciminetos.size());            
            e = estableciminetos.get(n_est-1);
            consola.imprimirMensaje("****");
            consola.mostrarEstablecimiento(e);
            e.settEstablecimineto(consola.pedirTipoEstablecimiento());
            consola.imprimirMensaje("Datos actualizados correctamente.");
        }                
    
    }
    
    //Simula el ingreso de una persona a un establecimiento
    public void ingresoPersona(){
        ArrayList<Establecimiento> estableciminetos = contenedor.getEstablecimientos();
        Establecimiento e=null;
        Persona persona = null;
        Date fecha = null;         
        int n_est = 0;
        consola.imprimirCabecera("Simulacion de ingreso de persona a un establecimiento");
        if (estableciminetos.size()==0){
            consola.imprimirMensaje("No hay establecimientos registrados.");
        }else{
            consola.mostrarEstableciminetos(estableciminetos);
            n_est = consola.seleccionEstablecimiento(estableciminetos.size());            
            e = estableciminetos.get(n_est-1);
            consola.mostrarEstablecimiento(e);
            persona = new Persona();
            fecha = consola.perdirDatosPersona(persona);
            e.ingresarPersona(persona, fecha);                      
            consola.imprimirMensaje("Simulacion exitosa.");
        }          
    } 
    
    //Buscar personas por fecha de ingreso en un establecimineto
    public void buscarFecha(){
        ArrayList<Establecimiento> estableciminetos = contenedor.getEstablecimientos();
        Establecimiento e=null;       
        Date fecha = null;         
        int n_est = 0;
        consola.imprimirCabecera("Busqueda de una persona por fecha en un establecimineto");
        if (estableciminetos.size()==0){
            consola.imprimirMensaje("No hay establecimientos registrados.");
        }else{
            consola.mostrarEstableciminetos(estableciminetos);
            n_est = consola.seleccionEstablecimiento(estableciminetos.size());            
            e = estableciminetos.get(n_est-1);
            consola.mostrarEstablecimiento(e);                                    
            fecha = consola.ingresarFechaBusqueda();
            ArrayList<Persona> personas = e.buscarFecha(fecha);
            if (personas.size()!=0){
                    consola.MostrarPersonas(personas);
                    consola.imprimirMensaje("Busqueda terminada correctamente.");
            }else{
                consola.imprimirMensaje("No hay personas con ingreso en esa fecha.");
            }            
        }         
    }        
    
    
}
