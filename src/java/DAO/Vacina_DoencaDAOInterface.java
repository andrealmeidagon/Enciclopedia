/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.Vacina_DoencaDAOException;
import Model.Vacina_Doenca;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public interface Vacina_DoencaDAOInterface {
    public boolean insert(Vacina_Doenca correspond) throws Vacina_DoencaDAOException;
    public boolean delete(Vacina_Doenca correspond) throws Vacina_DoencaDAOException;
    public boolean delete(int id_vacina, int id_doenca) throws Vacina_DoencaDAOException;
    public boolean update(Vacina_Doenca correspond, int id_vacina, int id_doenca) throws Vacina_DoencaDAOException;
    public ArrayList<Vacina_Doenca> retrieveAll() throws Vacina_DoencaDAOException;
    public ArrayList<Vacina_Doenca> retrieveByNameLike(String nome) throws Vacina_DoencaDAOException;
    public Vacina_Doenca retrieveByIdLike(int id) throws Vacina_DoencaDAOException;
}
