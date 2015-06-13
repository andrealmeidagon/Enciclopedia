/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.DoencaDAOException;
import Model.Doenca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class DoencaDAO implements DoencaDAOInterface{

    @Override
    public boolean insert(Doenca vacina) throws DoencaDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("INSERT INTO `doenca` (`nom_doenca`) VALUES (?);");
            pstm.setString(1, vacina.getNom_doenca());
            
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new DoencaDAOException(e.getMessage());
        }
        return bRet;    }

    @Override
    public boolean delete(Doenca vacina) throws DoencaDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id_doenca) throws DoencaDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("delete from doenca where id_doenca=(?)");
            pstm.setInt(1, id_doenca);
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new DoencaDAOException(e.getMessage());
        }
        return bRet;    
    }

    @Override
    public boolean update(Doenca doenca, int id) throws DoencaDAOException {
        boolean bRet = false;
        try{ 
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("UPDATE `doenca` SET `nom_doenca`=? WHERE `id_doenca`="+id+"");
            pstm.setString(1, doenca.getNom_doenca());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new DoencaDAOException(e.getMessage());
        }
        return bRet;    
    }

    @Override
    public ArrayList<Doenca> retrieveAll() throws DoencaDAOException {
        ArrayList<Doenca> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from doenca");
           
            while(rs.next()){
                Doenca doenca = new Doenca(rs.getInt("id_doenca"), rs.getString("nom_doenca"));
                arRet.add(doenca);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new DoencaDAOException(e.getMessage());
        }
        return arRet;    
    }

    @Override
    public ArrayList<Doenca> retrieveByNameLike(String name) throws DoencaDAOException {
        ArrayList<Doenca> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from doenca where 'nom_doenca' like '%" + name + "%'");
            
            while(rs.next()){
                Doenca doenca = new Doenca(rs.getInt("id_doenca"), rs.getString("nom_doenca"));
                arRet.add(doenca);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new DoencaDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public Doenca retrieveByIdLike(int id_doenca) throws DoencaDAOException {
        Doenca doenca;
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from doenca where 'id_doenca' like '%" + id_doenca + "%'");
            
            doenca = new Doenca(rs.getInt("id_doenca"), rs.getString("nom_doenca"));
                
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new DoencaDAOException(e.getMessage());
        }
        return doenca;
    }
    
}
