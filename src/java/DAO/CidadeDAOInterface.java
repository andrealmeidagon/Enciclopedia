/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.CidadeDAOException;
import Exceptions.VacinaDAOException;
import Model.Cidade;
import java.util.ArrayList;

/**
 *
 * @author Andr�
 */
public interface CidadeDAOInterface {
    public boolean insert(Cidade cidade) throws CidadeDAOException;
    public boolean delete(Cidade cidade) throws CidadeDAOException;
    public boolean delete(int id) throws CidadeDAOException;
    public boolean update(Cidade cidade) throws CidadeDAOException;
    public ArrayList<Cidade> retrieveAll() throws CidadeDAOException;
    public Cidade retrieveByIdLike(int id) throws CidadeDAOException;
}
