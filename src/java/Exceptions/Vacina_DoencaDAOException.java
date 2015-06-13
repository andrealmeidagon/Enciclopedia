/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author André
 */
public class Vacina_DoencaDAOException extends Exception{
    
    public Vacina_DoencaDAOException(){
        super();
    }
    
    public Vacina_DoencaDAOException(String message){
        super("Erro em VACINA_DOENCA: " + message);
    }
}
