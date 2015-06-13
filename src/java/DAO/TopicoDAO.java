/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.InstituicaoDAOException;
import Exceptions.TopicoDAOException;
import Model.Instituicao;
import Model.Topico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Andr�
 */
public class TopicoDAO implements TopicoDAOInterface {

    @Override
    public boolean insert(Topico topico) throws TopicoDAOException {
        boolean bRet = false;
        try{           
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("INSERT INTO `topico` (`id_topico`, `id_secao`, `nvl_topico`, `des_topico`, `titul_topico`) VALUES (?, ?, ?, ?, ?);");
            pstm.setInt(1, topico.getId_topico());
            System.out.println("oi");
            pstm.setInt(2, topico.getId_secao());
            System.out.println("oi");
            pstm.setInt(3, topico.getNvl_topico());
            System.out.println("oi");
            pstm.setString(4, topico.getDes_topico());
            System.out.println("oi");
            pstm.setString(5, topico.getTitul_topico());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new TopicoDAOException(e.getMessage());
        }
        return bRet;  
    }
    
    @Override
    public boolean delete(Topico topico) throws TopicoDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) throws TopicoDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("delete from topico where id_topico=(?)");
            pstm.setInt(1, id);
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new TopicoDAOException(e.getMessage());
        }
        return bRet;
    }

    @Override
    public boolean update(Topico topico, int id) throws TopicoDAOException {
    boolean bRet = false;
        try{ 
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("UPDATE `topico` SET `des_topico`=?, `titul_topico`=? WHERE `id_topico`="+id+" and`id_secao`="+topico.getId_secao()+" and`nvl_topico`="+topico.getNvl_topico()+";");
            pstm.setString(1, topico.getDes_topico());
            pstm.setString(2, topico.getTitul_topico());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new TopicoDAOException(e.getMessage());
        }
        return bRet;
    }

    @Override
    public ArrayList<Topico> retrieveAll() throws TopicoDAOException {
        ArrayList<Topico> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from topico");
           
            while(rs.next()){
                Topico topico = new Topico(rs.getInt("id_topico"),rs.getInt("id_secao"),rs.getInt("nvl_topico"),rs.getString("des_topico"),rs.getString("titul_topico"));
                arRet.add(topico);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new TopicoDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public ArrayList<Topico> retrieveByTitleLike(String like) throws TopicoDAOException {
        ArrayList<Topico> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from topico where 'titul_topico' like '%" + like + "%'");
            
            while(rs.next()){
                Topico topico = new Topico(rs.getInt("id_topico"),rs.getInt("id_secao"),rs.getInt("nvl_topico"),rs.getString("des_topico"),rs.getString("titul_topico"));
                arRet.add(topico);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new TopicoDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public ArrayList<Topico> retrieveSectionByIdLike(int id, int nvl) throws TopicoDAOException {
        ArrayList<Topico> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from topico where id_topico=" + id + " and nvl_topico=" + nvl + " and id_secao <> 0");
            
            while(rs.next()){
                Topico topico = new Topico(rs.getInt("id_topico"),rs.getInt("id_secao"),rs.getInt("nvl_topico"),rs.getString("des_topico"),rs.getString("titul_topico"));
                arRet.add(topico);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new TopicoDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public int tamSectionsByTopic(int id) throws TopicoDAOException {
        int TAM = 0;
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rsAux = stm.executeQuery("SELECT max(id_secao) FROM topico WHERE id_topico ="+id+" GROUP BY id_topico;");
            rsAux.next();
            TAM = rsAux.getInt(1);
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rsAux);
            
        }catch(Exception e){
            throw new TopicoDAOException(e.getMessage());
        }
        return TAM;
    }

    @Override
    public int newId() throws TopicoDAOException {
        int id = 0;
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("SELECT id_topico FROM topico WHERE id_topico = (SELECT max(id_topico) FROM topico) GROUP BY id_topico;");
            rs.next();
            id = rs.getInt(1) + 1;
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new TopicoDAOException(e.getMessage());
        }
        return id;
    }

    @Override
    public ArrayList<Topico> retrieveAllTopics() throws TopicoDAOException {
        ArrayList<Topico> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from topico where id_secao=0");
           
            while(rs.next()){
                Topico topico = new Topico(rs.getInt("id_topico"),rs.getInt("id_secao"),rs.getInt("nvl_topico"),rs.getString("des_topico"),rs.getString("titul_topico"));
                arRet.add(topico);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new TopicoDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public boolean deleteBySectionAndLvl(int id, int secao, int lvl) throws TopicoDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("delete from topico where id_topico=(?) and id_secao=(?) and nvl_topico=(?)");
            pstm.setInt(1, id);
            pstm.setInt(2, secao);
            pstm.setInt(3, lvl);
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new TopicoDAOException(e.getMessage());
        }
        return bRet;
    }
    
}
