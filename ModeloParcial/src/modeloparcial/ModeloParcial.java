/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloparcial;

import Controlador.ControladorEstablecimiento;
import Modelo.Contenedor;
import Modelo.Establecimiento;
import Modelo.Persona;
import Persistencia.EstablecimientoDAOImpl;
import Persistencia.PersonaDAOImpl;
import Vista.Consola;
import java.util.Scanner;


/**
 *
 * @author sistema
 */
public class ModeloParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Establecimiento est = new Establecimiento("EL", "EL", 2);
        EstablecimientoDAOImpl estDAO = new EstablecimientoDAOImpl();
        if(estDAO.resgistrar(est)){
            System.out.println("Registrado ");
        }else{
            System.out.println("XXXXXXXXXXX");
        }*/
        
        Persona per = new Persona(1,"r","casr","32186723",35);
        PersonaDAOImpl perDAO = new PersonaDAOImpl();                
        
        if(perDAO.resgistrar(per)){
            System.out.println("Registrado ");
        }else{
            System.out.println("XXXXXXXXXXX");
        }
        /*Consola consola = new Consola();
        Contenedor contenedor = new Contenedor();
        
        ControladorEstablecimiento controlador = new ControladorEstablecimiento(consola, contenedor);
                                       
        Scanner opc2 = new Scanner(System.in);
        String opc = "";
        do{
            menuPrincipal();
            System.out.println("Ingresar la opcion: ");
            opc = opc2.nextLine();

            switch(opc){
                case "1":                                        
                    controlador.registrarEstablecimiento();
                    break;
                case "2":                       
                       controlador.actualizarEstablecimiento();
                        break;

                case "3":
                    controlador.ingresoPersona();                       
                    break;
                case "4":
                       controlador.buscarFecha();
                        break;
                case "5":
                    System.out.println("App finalizada....");
                default:                    
                    break;
            }
        }while(!opc.equalsIgnoreCase("5"));
        */      
        
    }
    
    public static void menuPrincipal(){
        System.out.println("**********************MENU PRINCIPAL********************");
        System.out.println("[1] - Registrar establecimiento.");
        System.out.println("[2] - Actualizar tipo de un establecimiento.");
        System.out.println("[3] - Simular ingreso de una persona a un establecimiento.");
        System.out.println("[4] - Buscar personas que visitaron un establecimiento por fecha.");
        System.out.println("[5] - Para Salir");        
    }
    
    public void menuSecundario(String cabecera){
        System.out.println("**********************"+ cabecera+"********************");
        System.out.println("[1] - Listar los establecimientos.");
        System.out.println("[2] - Reresar.");
    }
    
    
}
