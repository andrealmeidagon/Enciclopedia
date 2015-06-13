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
public class Correspond_topicoDAOException extends Exception{
    
    public Correspond_topicoDAOException(){
        super();
    }
    
    public Correspond_topicoDAOException(String message){
        super("Erro em Correspond_topico: " + message);
    }
}
