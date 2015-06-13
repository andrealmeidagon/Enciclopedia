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
public class VacinaDAOException extends Exception{
    
    public VacinaDAOException(){
        super();
    }
    
    public VacinaDAOException(String message){
        super("Erro em VACINA: " + message);
    }
}
