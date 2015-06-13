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
public class DoencaDAOException extends Exception{
    
    public DoencaDAOException(){
        super();
    }
    
    public DoencaDAOException(String message){
        super("Erro em DOENCA: " + message);
    }
}
