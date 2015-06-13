/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.Correspond_topicoDAOException;
import Model.Correspond_topico;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public interface Correspond_topicoDAOInterface {
    public boolean insert(Correspond_topico correspond_topico) throws Correspond_topicoDAOException;
    public boolean delete(Correspond_topico correspond_topico) throws Correspond_topicoDAOException;
    public boolean delete(int id) throws Correspond_topicoDAOException;
    public boolean update(Correspond_topico correspond_topico, int id) throws Correspond_topicoDAOException;
    public ArrayList<Correspond_topico> retrieveAll() throws Correspond_topicoDAOException;
    public Correspond_topico retrieveByIdLike(int id) throws Correspond_topicoDAOException;
}
