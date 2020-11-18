/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sistema
 */
public class Establecimiento {
    //Attributes
    private String nComercial;
    private String tEstablecimineto;
    private int nit;    
    
    //Personas que han ingresado al establecimiento
    private ArrayList<Persona> personas;
    //Fecha en la que han ingresado las personas al establecimiento
    private ArrayList<Date> fechas;
        
    //Constructor
    public Establecimiento(){}
    
    
    public Establecimiento(String nComercial, String tEstablecimineto, int nit) {
        this.nComercial = nComercial;
        this.tEstablecimineto = tEstablecimineto;
        this.nit = nit;
    }
    
    //Setters and Getters
    public String getnComercial() {
        return nComercial;
    }

    public void setnComercial(String nComercial) {
        this.nComercial = nComercial;
    }

    public String gettEstablecimineto() {
        return tEstablecimineto;
    }

    public void settEstablecimineto(String tEstablecimineto) {
        this.tEstablecimineto = tEstablecimineto;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
    
    //Metodos
    
    //Actualiza los datos de un establecimiento
   public void ingresarPersona(Persona persona, Date date){
       if (this.personas==null){
           this.personas = new ArrayList<Persona>(); 
           this.fechas = new ArrayList<Date>();
       }
       
       this.personas.add(persona);
       this.fechas.add(date);                            
   }
   
   public ArrayList<Persona> buscarFecha(Date date){
       
       ArrayList<Persona> _personas = new ArrayList<Persona>();
       
       if (this.fechas != null){
           for (int i = 0; i< this.fechas.size();i++){
               if (date.equals(this.fechas.get(i) )){
                   _personas.add(this.personas.get(i));                       
                }
           }                      
       }                            
       return _personas;
   }
}

