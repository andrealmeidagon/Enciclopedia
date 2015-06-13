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
public class UfDAOException extends Exception{
    
    public UfDAOException(){
        super();
    }
    
    public UfDAOException(String message){
        super("Erro em Instituicao: " + message);
    }
}
