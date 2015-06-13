/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.DoencaDAOException;
import Model.Doenca;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public interface DoencaDAOInterface {
    public boolean insert(Doenca doenca) throws DoencaDAOException;
    public boolean delete(Doenca doenca) throws DoencaDAOException;
    public boolean delete(int id) throws DoencaDAOException;
    public boolean update(Doenca doenca, int id) throws DoencaDAOException;
    public ArrayList<Doenca> retrieveAll() throws DoencaDAOException;
    public ArrayList<Doenca> retrieveByNameLike(String nome) throws DoencaDAOException;
    public Doenca retrieveByIdLike(int id) throws DoencaDAOException;
}
