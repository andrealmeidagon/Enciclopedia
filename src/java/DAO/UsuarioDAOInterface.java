/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.UsuarioDAOException;
import Model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Andr�
 */
public interface UsuarioDAOInterface {
    public boolean insert(Usuario usuario) throws UsuarioDAOException;
    public boolean delete(Usuario usuario) throws UsuarioDAOException;
    public boolean delete(int id) throws UsuarioDAOException;
    public boolean update(Usuario usuario) throws UsuarioDAOException;
    public boolean userExists(String email) throws UsuarioDAOException;
    public ArrayList<Usuario> retrieveAll(int type) throws UsuarioDAOException;
    public Usuario retrieveByEmailLike(String email) throws UsuarioDAOException;
    public Usuario retrieveByIdLike(int id) throws UsuarioDAOException;
}
