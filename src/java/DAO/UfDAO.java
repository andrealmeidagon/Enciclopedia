/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Exceptions.UfDAOException;
import Model.Uf;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class UfDAO implements UfDAOInterface {

    @Override
    public boolean insert(Uf uf) throws UfDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("insert uf (nom_uf, id_uf,sigla_uf) values (?,?,?)");
            pstm.setString(1, uf.getNom_uf());
            pstm.setInt(2, uf.getId_uf());
            pstm.setString(3, uf.getSigla_uf());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new UfDAOException(e.getMessage());
        }
        return bRet;
    }

    
    @Override
    public boolean delete(int id_uf) throws UfDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("delete from uf where id_uf=(?)");
            pstm.setInt(1, id_uf);
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new UfDAOException(e.getMessage());
        }
        return bRet;
    }
    
    @Override
    public ArrayList<Uf> retrieveAll() throws UfDAOException {
        ArrayList<Uf> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from uf");
            
            while(rs.next()){
                Uf uf = new Uf(rs.getInt("id_uf"),rs.getString("nom_uf"),rs.getString("sigla_uf"));
                arRet.add(uf);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new UfDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public ArrayList<Uf> retrieveByNameLike(String like) throws UfDAOException {
        ArrayList<Uf> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from uf where nom_uf like '%" + like + "%'");
            
            while(rs.next()){
                Uf uf = new Uf(rs.getInt("id_uf"),rs.getString("nom_uf"),rs.getString("sigla_uf"));
                arRet.add(uf);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new UfDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public boolean update(Uf uf) throws UfDAOException {
        boolean bRet = false;
        try{           
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("UPDATE `uf` SET `nom_uf`=?, sigla_uf=? WHERE `id_uf`="+uf.getId_uf()+"");
            pstm.setString(1, uf.getNom_uf());
            pstm.setString(2, uf.getSigla_uf());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new UfDAOException(e.getMessage());
        }
        return bRet;
    }

    @Override
    public Uf retrieveByIdLike(int id_uf) throws UfDAOException {
        Uf uf;
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from uf where id_uf like '%" + id_uf + "%'");
            
            rs.next();
            uf = new Uf(rs.getInt("id_uf"),rs.getString("nom_uf"),rs.getString("sigla_uf"));
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);            
        }catch(Exception e){
            throw new UfDAOException(e.getMessage());
        }
        return uf;   
    }

    @Override
    public boolean delete(Uf uf) throws UfDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
