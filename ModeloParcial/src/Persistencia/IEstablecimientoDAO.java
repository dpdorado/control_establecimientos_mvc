/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Establecimiento;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sistema
 */
public interface IEstablecimientoDAO {
    public  boolean resgistrar(Establecimiento est);
    public boolean actualizar(int nit, String tipo);
    public ArrayList<Persona> bucarPersonasFecha(int nit, Date fecha);
    public ArrayList<Establecimiento> buscarEstPersona(Persona per);
}
