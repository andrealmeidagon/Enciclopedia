/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Exceptions.InstituicaoDAOException;
import Model.Instituicao;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class InstituicaoDAO implements InstituicaoDAOInterface {

    @Override
    public boolean insert(Instituicao instituicao) throws InstituicaoDAOException {
        boolean bRet = false;
        try{
            
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("insert instituicao (nom_instituicao, cidade_id, sigla_instituicao) values (?,?,?)");
            pstm.setString(1, instituicao.getNom_instituicao());
            pstm.setInt(2, instituicao.getCidade_id());
            pstm.setString(3, instituicao.getSigla_instituicao());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new InstituicaoDAOException(e.getMessage());
        }
        return bRet;
    }

    @Override
    public boolean delete(Instituicao cidade) throws InstituicaoDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Instituicao instituicao) throws InstituicaoDAOException {
        boolean bRet = false;
        try{           
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("UPDATE `instituicao` SET `nom_instituicao`=?, `sigla_instituicao`=?, `cidade_id`=? WHERE `id_instituicao`="+instituicao.getId_instituicao()+"");
            pstm.setString(1, instituicao.getNom_instituicao());
            pstm.setString(2,instituicao.getSigla_instituicao());
            pstm.setInt(3, instituicao.getCidade_id());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new InstituicaoDAOException(e.getMessage());
        }
        return bRet;   
    }

    @Override
    public boolean delete(int id_instituicao) throws InstituicaoDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("delete from instituicao where id_instituicao=(?)");
            pstm.setInt(1, id_instituicao);
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new InstituicaoDAOException(e.getMessage());
        }
        return bRet;
    }
    
    @Override
    public ArrayList<Instituicao> retrieveAll() throws InstituicaoDAOException {
        ArrayList<Instituicao> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from instituicao");
            
            while(rs.next()){
                Instituicao instituicao = new Instituicao(rs.getInt("id_instituicao"),rs.getInt("cidade_id"),rs.getString("nom_instituicao"), rs.getString("sigla_instituicao"));
                arRet.add(instituicao);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new InstituicaoDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public ArrayList<Instituicao> retrieveByNameLike(String like) throws InstituicaoDAOException {
        ArrayList<Instituicao> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from instituicao where 'nom_instituicao' like '%" + like + "%'");
            
            while(rs.next()){
                Instituicao instituicao = new Instituicao(rs.getInt("id_instituicao"),rs.getInt("cidade_id"),rs.getString("nom_instituicao"), rs.getString("sigla_instituicao"));
                arRet.add(instituicao);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new InstituicaoDAOException(e.getMessage());
        }
        return arRet;
    }    

    @Override
    public Instituicao retrieveByIdLike(int id) throws InstituicaoDAOException {
        Instituicao instituicao;
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from instituicao where id_instituicao like '%" + id + "%'");
            
            rs.next();
            instituicao = new Instituicao(rs.getInt("id_instituicao"),rs.getInt("cidade_id"),rs.getString("nom_instituicao"), rs.getString("sigla_instituicao"));
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new InstituicaoDAOException(e.getMessage());
        }
        return instituicao;
    }
}
