  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author sistema
 */
public class Contenedor {
    //Attributes
    private ArrayList<Establecimiento> establecimientos;
    
    //Constructor
    public Contenedor(){
        establecimientos = new ArrayList<Establecimiento>();
    }
    
    //Metodos
    public ArrayList<Establecimiento> getEstablecimientos(){
        return this.establecimientos;
    }
    
    
    public Establecimiento getEstablecimiento(String nombre) {
        Establecimiento est = null;
        for (Establecimiento e: this.establecimientos){
            if (nombre.equals(e.getnComercial())){
                est = e;
                break;
            }
        }
        
        return est;
    }
    
    public void registrarEstablecimiento(Establecimiento est){
        this.establecimientos.add(est);
    }
    
    
}
