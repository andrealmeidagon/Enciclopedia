/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Exceptions.InstituicaoDAOException;
import Model.Instituicao;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public interface InstituicaoDAOInterface {
    
    public boolean insert(Instituicao instituicao) throws InstituicaoDAOException;
    public boolean delete(Instituicao instituicao) throws InstituicaoDAOException;
    public boolean delete(int id) throws InstituicaoDAOException;
    public boolean update(Instituicao instituicao) throws InstituicaoDAOException;
    public ArrayList<Instituicao> retrieveAll() throws InstituicaoDAOException;
    public ArrayList<Instituicao> retrieveByNameLike(String nome) throws InstituicaoDAOException;
    public Instituicao retrieveByIdLike(int id) throws InstituicaoDAOException;
}
