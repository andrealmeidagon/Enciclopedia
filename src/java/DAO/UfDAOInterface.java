/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Exceptions.UfDAOException;
import Model.Uf;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public interface UfDAOInterface {
    public boolean insert(Uf uf) throws UfDAOException;
    public boolean delete(Uf uf) throws UfDAOException;
    public boolean update(Uf uf) throws UfDAOException;
    public boolean delete(int id) throws UfDAOException;
    public ArrayList<Uf> retrieveAll() throws UfDAOException;
    public ArrayList<Uf> retrieveByNameLike(String nome) throws UfDAOException;
    public Uf retrieveByIdLike(int id) throws UfDAOException;
}
