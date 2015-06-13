/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.TopicoDAOException;
import Model.Topico;
import java.util.ArrayList;

/**
 *
 * @author Andr�
 */
public interface TopicoDAOInterface {
    public boolean insert(Topico topico) throws TopicoDAOException;
    public boolean delete(Topico topico) throws TopicoDAOException;
    public boolean delete(int id) throws TopicoDAOException;
    public boolean update(Topico topico, int id) throws TopicoDAOException;
    public ArrayList<Topico> retrieveAll() throws TopicoDAOException;
    
    //extras
    public ArrayList<Topico> retrieveByTitleLike(String nome) throws TopicoDAOException;
    public ArrayList<Topico> retrieveSectionByIdLike(int id, int nvl) throws TopicoDAOException;
    public int tamSectionsByTopic(int id) throws TopicoDAOException;
    public int newId() throws TopicoDAOException;
    public ArrayList<Topico> retrieveAllTopics() throws TopicoDAOException;
    public boolean deleteBySectionAndLvl(int id, int secao, int lvl) throws TopicoDAOException;
}
