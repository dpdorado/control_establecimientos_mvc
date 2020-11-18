/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Establecimiento;
import Modelo.Persona;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author sistema
 */
public class Consola {
    Scanner lector = new Scanner(System.in);
    //Metodos
    
    //Pide el tipo de establecimiento
    public String pedirTipoEstablecimiento(){
        imprimirMensaje("Ingrese el tipo de establecimeinto: ");
        return lector.nextLine();
    }    
    
    
    //*****************************************************Opcion 1
     //Pide los datos de un establecimiento
    public Establecimiento pedirEstablecimeinto(){         
        imprimirMensaje("Ingrese el nombre comercial del establecimeinto: ");
        String nComercial =  lector.nextLine();       
        String tEstablecimineto = pedirTipoEstablecimiento();
        int nit=0;
        while(nit<=0){
            try{
                imprimirMensaje("Ingrese el NIT del establecimiento: ");
                nit = Integer.parseInt(lector.nextLine());
            }catch(Exception e){
                imprimirMensaje("NIT debe ser numerico, vuelva a ingresarlo.");            
            }
        }
        return new Establecimiento(nComercial,tEstablecimineto,nit);
    }
    
    //****************************************************OPcion 2
    //Permite seleccionar un numero entre los estableciminetos liestados
    public int seleccionEstablecimiento(int numEstableciminetos){
        int num=0;
        while(num < 1 || num >numEstableciminetos){
            try{
                imprimirMensaje("Ingrese numero de establecimineto: ");
                num = Integer.parseInt(lector.nextLine());                
                if (num < 1 || num >numEstableciminetos){
                    imprimirMensaje("El numero de establecimiento no existe");            
                }
            }catch(Exception e){
                imprimirMensaje("El dato debe ser numerico.");            
            }
        }        
        return num;
    }
    
    //Muestra en consola los datos de un establecimineto
    public void mostrarEstablecimiento( Establecimiento e){
        imprimirMensaje("Nombre comercial: "+e.getnComercial());
        imprimirMensaje("Tipo de establecimiento: "+e.gettEstablecimineto());
        imprimirMensaje("NIT: "+e.getNit());
    }
    
    
    //Muestra en consola los establecimiento registrados
    public void mostrarEstableciminetos( ArrayList<Establecimiento> estableciminetos){
        int c= 1;
        for (Establecimiento e :estableciminetos){
            imprimirMensaje("------------------Establecimineto   "+c+"--------------------");
            mostrarEstablecimiento(e);
            c++;
        }
    }
    //********************************************Opcion 3
    //Metodo que pide los datos de una persona
    public Date perdirDatosPersona(Persona persona){
        Date dt = null;
        imprimirMensaje("****");
        imprimirMensaje("Nombre de la persona: ");
        String nombre =  lector.nextLine();        
        imprimirMensaje("Apellido de la persona: ");
        String apellidos =  lector.nextLine();          
        imprimirMensaje("Telefono: ");
        String telefono =  lector.nextLine();              
        int num=0;
        while(num < 1 || num >45){
            try{
                imprimirMensaje("Ingrese la temperatura: ");
                num = Integer.parseInt(lector.nextLine());                
                if (num < 1 || num >45){
                    imprimirMensaje("Temperatura invalida.");            
                }
            }catch(Exception e){
                imprimirMensaje("El dato debe ser numerico.");            
            }
        }        
        
        dt = fechaIngreso("Fecha de ingreso ");
        
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setTelefono(telefono);
        persona.setTemperatura(num);
        
        return dt;
    }
    
    
    //Pide la fecha de ingreso de una persona
    public Date fechaIngreso(String mensaje){
        String fecha;
        Date fechaDate;
        while(true){
                                    
            imprimirMensaje(mensaje +"dd/MM/yyyy:");
            fecha = lector.nextLine(); 
            try {
               fechaDate=ParseFecha(fecha);
               break;
            } 
            catch (ParseException ex) 
            {
                imprimirMensaje("Formato de fecha no valido."); 
            }
            
        }
        return fechaDate;
    }
    
     //Convierte un estring a date
    public static Date ParseFecha(String fecha) throws ParseException
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        
        fechaDate = formato.parse(fecha);
       
        return fechaDate;
    }
    //*********************************Opcion 4
      //Mtodo que pide la fecha para hacer la busqeuda
    public Date ingresarFechaBusqueda(){
        return fechaIngreso("Fecha para hacer la busqueda ");
    }
    
    //Metodo qeu muestra los datos de las personas encontradas
    public void MostrarPersonas(ArrayList<Persona> personas){
        int c= 1;
        for (Persona e :personas){
            imprimirMensaje("------------------Persona   "+c+"--------------------");
            mostrarPersona(e);
            c++;
        }
    }
    
   
   
 
    //Muestra en consola los datos de un establecimineto
    public void mostrarPersona( Persona e){
        imprimirMensaje("Nombre: "+e.getNombre());
        imprimirMensaje("Apellidos: "+e.getApellidos());
        imprimirMensaje("Telefono: "+e.getTelefono());
        imprimirMensaje("Temperatura: "+e.getTemperatura());                
    }
        
        
    public void imprimirMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public void imprimirCabecera(String mensaje){
        System.out.println("*****************************"+mensaje+"****************************");
    }
    
    
}
