/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.UsuarioDAOException;
import Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class UsuarioDAO implements UsuarioDAOInterface {

    @Override
    public boolean insert(Usuario usuario) throws UsuarioDAOException {
        boolean bRet = false;
        try{           
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("insert usuario (instituicao_id, tipo_usuario, email_usuario, nom_usuario, txt_senha) values (?,?,?,?,?)");
            pstm.setInt(1, usuario.getInstituicao_id());
            pstm.setInt(2, usuario.getTipo_usuario());
            pstm.setString(3, usuario.getEmail_usuario());
            pstm.setString(4, usuario.getNom_usuario());
            pstm.setString(5, usuario.getSenha_usuario());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        
        }catch(Exception e){
            throw new UsuarioDAOException(e.getMessage());
        }
        return bRet;
    }

    @Override
    public boolean delete(Usuario usuario) throws UsuarioDAOException {
        return false;
    }

    @Override
    public boolean delete(int id) throws UsuarioDAOException {
        boolean bRet = false;
        try{
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("delete from usuario where id_usuario=(?)");
            pstm.setInt(1, id);
            
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new UsuarioDAOException(e.getMessage());
        }
        return bRet;    
    }

    @Override
    public boolean update(Usuario usuario) throws UsuarioDAOException {
        boolean bRet = false;
        try{           
            PreparedStatement pstm = ConnectionFactory.getConnection().prepareStatement("UPDATE usuario SET `nom_usuario`=?, `txt_senha`=?, `email_usuario`=?, `instituicao_id`=? WHERE `id_usuario`="+usuario.getId_usuario()+"");
            pstm.setString(1, usuario.getNom_usuario());
            pstm.setString(2, usuario.getSenha_usuario());
            pstm.setString(3, usuario.getEmail_usuario());
            pstm.setInt(4, usuario.getInstituicao_id());
            bRet = pstm.execute();
            ConnectionFactory.closeConnection(ConnectionFactory.Con, pstm);
        }catch(Exception e){
            throw new UsuarioDAOException(e.getMessage());
        }
        return bRet;   
    }
    
    @Override
    public ArrayList<Usuario> retrieveAll(int type) throws UsuarioDAOException {
        ArrayList<Usuario> arRet = new ArrayList<>();
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from usuario");
            
            while(rs.next()){
                if(rs.getInt("tipo_usuario")==type){
                    Usuario usuario = new Usuario(rs.getInt("id_usuario"),rs.getInt("instituicao_id"), rs.getInt("tipo_usuario"),rs.getString("email_usuario"),rs.getString("nom_usuario"), rs.getString("txt_senha"));
                    arRet.add(usuario);
                }
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
        }catch(Exception e){
            throw new UsuarioDAOException(e.getMessage());
        }
        return arRet;    
    }

    @Override
    public Usuario retrieveByEmailLike(String email) throws UsuarioDAOException {
        Usuario usuario;
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from usuario where email_usuario like '%" + email + "%'");
            rs.next();
            usuario = new Usuario(rs.getInt("id_usuario"),rs.getInt("instituicao_id"), rs.getInt("tipo_usuario"),rs.getString("email_usuario"),rs.getString("nom_usuario"), rs.getString("txt_senha"));
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
        
        } catch(Exception e){
            throw new UsuarioDAOException(e.getMessage());
        }
        return usuario;
    }

    @Override
    public Usuario retrieveByIdLike(int id) throws UsuarioDAOException {
        Usuario usuario = null;
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from usuario where id_usuario like '%" + id + "%'");
            rs.next();
            usuario = new Usuario(rs.getInt("id_usuario"),rs.getInt("instituicao_id"), rs.getInt("tipo_usuario"),rs.getString("email_usuario"),rs.getString("nom_usuario"), rs.getString("txt_senha"));
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
        }catch(Exception e){
            throw new UsuarioDAOException(e.getMessage());
        }   
        return usuario;
    }

    @Override
    public boolean userExists(String email) throws UsuarioDAOException {
        boolean exist = false;
        try{
            Statement stm = ConnectionFactory.getConnection().createStatement();
            ResultSet rs = stm.executeQuery("select * from usuario");
            
            while(rs.next()){
                if(rs.getString("email_usuario").equals(email)){
                    exist = true;
                    break;
                }
            }
            
            ConnectionFactory.closeConnection(ConnectionFactory.Con, stm, rs);
        }catch(Exception e){
            throw new UsuarioDAOException(e.getMessage());
        }   
        return exist;    
    }
}