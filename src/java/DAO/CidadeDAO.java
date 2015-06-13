/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.CidadeDAOException;
import Model.Cidade;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Andr�
 */
public class CidadeDAO implements CidadeDAOInterface{

    @Override
    public boolean insert(Cidade cidade) throws CidadeDAOException {
        boolean bRet = false;
        try{           
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("insert cidade (id_cidade, nom_cidade, uf_id) values (?,?,?)");
            pstm.setInt(1, cidade.getId_cidade());
            pstm.setString(2, cidade.getNom_cidade());
            pstm.setInt(3, cidade.getUf_id());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new CidadeDAOException(e.getMessage());
        }
        return bRet;
    }

    @Override
    public boolean delete(Cidade cidade) throws CidadeDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id_cidade) throws CidadeDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("delete from cidade where id_cidade=(?)");
            pstm.setInt(1, id_cidade);
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new CidadeDAOException(e.getMessage());
        }
        return bRet;  
    }

    @Override
    public boolean update(Cidade cidade) throws CidadeDAOException {
        boolean bRet = false;
        try{           
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("UPDATE cidade SET `nom_cidade`=?, `uf_id`=? WHERE `id_cidade`="+cidade.getId_cidade()+"");
            pstm.setString(1, cidade.getNom_cidade());
            pstm.setInt(2, cidade.getUf_id());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new CidadeDAOException(e.getMessage());
        }
        return bRet;   
    }

    @Override
    public ArrayList<Cidade> retrieveAll() throws CidadeDAOException {
        ArrayList<Cidade> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from cidade");
            
            while(rs.next()){
                Cidade cidade = new Cidade(rs.getInt("id_cidade"), rs.getInt("uf_id"), rs.getString("nom_cidade"));
                arRet.add(cidade);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new CidadeDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public Cidade retrieveByIdLike(int cod_cidade) throws CidadeDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
