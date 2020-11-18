/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Persona;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sistema
 */
public interface IPersonaDAO {
    public boolean resgistrar(Persona per);
    public boolean actualizar(Date fecha);
}
