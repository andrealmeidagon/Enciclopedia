/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.VacinaDAOException;
import Model.Vacina;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public interface VacinaDAOInterface {
    public boolean insert(Vacina vacina) throws VacinaDAOException;
    public boolean delete(Vacina vacina) throws VacinaDAOException;
    public boolean delete(int id) throws VacinaDAOException;
    public boolean update(Vacina doenca, int id) throws VacinaDAOException;
    public ArrayList<Vacina> retrieveAll() throws VacinaDAOException;
    public ArrayList<Vacina> retrieveByNameLike(String nome) throws VacinaDAOException;
    public Vacina retrieveByIdLike(int id) throws VacinaDAOException;
}
