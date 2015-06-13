/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.VacinaDAOException;
import Model.Vacina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class VacinaDAO implements VacinaDAOInterface{

    @Override
    public boolean insert(Vacina vacina) throws VacinaDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("INSERT INTO `vacina` (`nom_vacina`) VALUES (?);");
            pstm.setString(1, vacina.getNom_vacina());
            
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new VacinaDAOException(e.getMessage());
        }
        return bRet;    
    }

    @Override
    public boolean delete(Vacina vacina) throws VacinaDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id_vacina) throws VacinaDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("delete from vacina where id_vacina=(?)");
            pstm.setInt(1, id_vacina);
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new VacinaDAOException(e.getMessage());
        }
        return bRet;    
    }

    @Override
    public boolean update(Vacina doenca, int id) throws VacinaDAOException {
        boolean bRet = false;
        try{ 
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("UPDATE `vacina` SET `nom_vacina`=? WHERE `id_vacina`="+id+"");
            pstm.setString(1, doenca.getNom_vacina());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new VacinaDAOException(e.getMessage());
        }
        return bRet;    
    }

    @Override
    public ArrayList<Vacina> retrieveAll() throws VacinaDAOException {
        ArrayList<Vacina> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from vacina");
           
            while(rs.next()){
                Vacina vacina = new Vacina(rs.getInt("id_vacina"), rs.getString("nom_vacina"));
                arRet.add(vacina);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new VacinaDAOException(e.getMessage());
        }
        return arRet;    
    }

    @Override
    public ArrayList<Vacina> retrieveByNameLike(String name) throws VacinaDAOException {
        ArrayList<Vacina> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from vacina where 'nom_vacina' like '%" + name + "%'");
            
            while(rs.next()){
                Vacina vacina = new Vacina(rs.getInt("id_vacina"), rs.getString("nom_vacina"));
                arRet.add(vacina);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new VacinaDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public Vacina retrieveByIdLike(int id_vacina) throws VacinaDAOException {
        Vacina vacina;
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from vacina where 'id_vacina' like '%" + id_vacina + "%'");
            
            vacina = new Vacina(rs.getInt("id_vacina"), rs.getString("nom_vacina"));
                
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new VacinaDAOException(e.getMessage());
        }
        return vacina;
    }
    
}
