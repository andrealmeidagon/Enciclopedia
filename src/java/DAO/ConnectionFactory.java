/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author André
 */
public class ConnectionFactory {
    public static Connection Con;
    
    public static Connection getConnection() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost/enciclop_vacina","root","root");
        }catch(Exception e){
            throw new Exception("ERRO EM CONNECTIONFACTORY - getConnection: " + e.getMessage());
        }
        return Con;
    }
    
    public static void closeConnection(Connection con) throws Exception{
        try{
            con.close();
        }catch(Exception e){
            throw new Exception("ERRO EM CONNECTIONFACTORY - closeConnection: " + e.getMessage());
        }
    }
    
        public static void closeConnection(Connection con, Statement stm) throws Exception{
        try{
            con.close();
            stm.close();
        }catch(Exception e){
            throw new Exception("ERRO EM CONNECTIONFACTORY - closeConnection: " + e.getMessage());
        }
    }
        
    public static void closeConnection(Connection con, PreparedStatement pstm) throws Exception{
        try{
            con.close();
            pstm.close();
        }catch(Exception e){
            throw new Exception("ERRO EM CONNECTIONFACTORY - closeConnection: " + e.getMessage());
        }
    }
    
    public static void closeConnection(Connection con, Statement stm, ResultSet rs) throws Exception{
        try{
            con.close();
            stm.close();
            rs.close();
        }catch(Exception e){
            throw new Exception("ERRO EM CONNECTIONFACTORY - closeConnection: " + e.getMessage());
        }
    }
    
        public static void closeConnection(Connection con, PreparedStatement pstm, ResultSet rs) throws Exception{
        try{
            con.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            throw new Exception("ERRO EM CONNECTIONFACTORY - closeConnection: " + e.getMessage());
        }
    }
}
