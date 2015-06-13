/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.Correspond_topicoDAOException;
import Model.Correspond_topico;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class Correspond_topicoDAO implements Correspond_topicoDAOInterface{

    @Override
    public boolean insert(Correspond_topico correspond_topico) throws Correspond_topicoDAOException {
        boolean bRet = false;
        try{           
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("INSERT INTO `enciclopedia`.`correspond_topico` (`topico_id_topico`, `vacina_id_vacina`, `doenca_id_doenca`) VALUES (?,?,?);");
            pstm.setInt(1, correspond_topico.getVacina_id_vacina());
            pstm.setInt(2, correspond_topico.getDoenca_id_doenca());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new Correspond_topicoDAOException(e.getMessage());
        }
        return bRet;
    }

    @Override
    public boolean delete(Correspond_topico correspond_topico) throws Correspond_topicoDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) throws Correspond_topicoDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("delete from correspond_topico where id_correspond_topico=(?)");
            pstm.setInt(1, id);
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new Correspond_topicoDAOException(e.getMessage());
        }
        return bRet;  
    }

    @Override
    public boolean update(Correspond_topico correspond_topico, int id) throws Correspond_topicoDAOException {
        boolean bRet = false;
        try{           
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("UPDATE cidade SET `doenca_id_doenca`=?, `topico_id_topico`=?, `vacina_id_vacina`=? WHERE `id_cidade`="+id+"");
            pstm.setInt(1, correspond_topico.getDoenca_id_doenca());
            pstm.setInt(2, correspond_topico.getTopico_id_topico());
            pstm.setInt(3, correspond_topico.getVacina_id_vacina());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new Correspond_topicoDAOException(e.getMessage());
        }
        return bRet;   
    }

    @Override
    public ArrayList<Correspond_topico> retrieveAll() throws Correspond_topicoDAOException {
        ArrayList<Correspond_topico> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from correspond_topico");
            
            while(rs.next()){
                Correspond_topico correspond_topico = new Correspond_topico(rs.getInt("doenca_id_doenca"), rs.getInt("topico_id_topico"), rs.getInt("vacina_id_vacina"));
                arRet.add(correspond_topico);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new Correspond_topicoDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public Correspond_topico retrieveByIdLike(int cod_cidade) throws Correspond_topicoDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
