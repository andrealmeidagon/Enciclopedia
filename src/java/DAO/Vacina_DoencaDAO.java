/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.Vacina_DoencaDAOException;
import Model.Vacina_Doenca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class Vacina_DoencaDAO implements Vacina_DoencaDAOInterface{

    @Override
    public boolean insert(Vacina_Doenca correspond) throws Vacina_DoencaDAOException {
        boolean bRet = false;
        try{           
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("INSERT INTO `vacina_doenca` (`vacina_id_vacina`, `doenca_id_doenca`) VALUES (?, ?);");
            pstm.setInt(1, correspond.getVacina_id_vacina());
            pstm.setInt(2, correspond.getDoenca_id_doenca());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new Vacina_DoencaDAOException(e.getMessage());
        }
        return bRet;
    }

    @Override
    public boolean delete(Vacina_Doenca correspond) throws Vacina_DoencaDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id_vacina, int id_doenca) throws Vacina_DoencaDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("delete from vacina_doenca where vacina_id_vacina=(?) and doenca_id_doenca=(?)");
            pstm.setInt(1, id_vacina);
            pstm.setInt(2, id_doenca);
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new Vacina_DoencaDAOException(e.getMessage());
        }
        return bRet;  
    }

    @Override
    public boolean update(Vacina_Doenca correspond, int id_vacina, int id_doenca) throws Vacina_DoencaDAOException {
        boolean bRet = false;
        try{           
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("UPDATE vacina_doenca SET `doenca_id_doenca`=?, `vacina_id_vacina`=? WHERE `doenca_id_doenca`="+id_doenca+", `vacina_id_vacina`="+id_vacina);
            pstm.setInt(1, correspond.getDoenca_id_doenca());
            pstm.setInt(2, correspond.getVacina_id_vacina());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new Vacina_DoencaDAOException(e.getMessage());
        }
        return bRet;   
    }

    @Override
    public ArrayList<Vacina_Doenca> retrieveAll() throws Vacina_DoencaDAOException {
        ArrayList<Vacina_Doenca> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from vacina_doenca");
            
            while(rs.next()){
                Vacina_Doenca correspond = new Vacina_Doenca(rs.getInt("doenca_id_doenca"), rs.getInt("vacina_id_vacina"));
                arRet.add(correspond);
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
            
        }catch(Exception e){
            throw new Vacina_DoencaDAOException(e.getMessage());
        }
        return arRet;
    }

    @Override
    public Vacina_Doenca retrieveByIdLike(int id) throws Vacina_DoencaDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public ArrayList<Vacina_Doenca> retrieveByNameLike(String nome) throws Vacina_DoencaDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
