/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CidadeDAO;
import DAO.CidadeDAOInterface;
import DAO.UfDAO;
import DAO.UfDAOInterface;
import Exceptions.CidadeDAOException;
import Exceptions.UfDAOException;
import Model.Cidade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author André
 */
public class CidadeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String ref = request.getParameter("ref");
            if(ref.equals("Cadastrar")){
                try{ 
                    CidadeDAOInterface dao = new CidadeDAO();
                    Cidade cidade = new Cidade(Integer.parseInt(request.getParameter("uf_id")),request.getParameter("nome"));
                    dao.insert(cidade);
                    
                    RequestDispatcher r = request.getRequestDispatcher("CidadeController?ref=listaruf");
                    
                    r.forward(request, response);
                } catch (CidadeDAOException e) {
                    out.print(e.getMessage());
                }      
            }else if(ref.equals("listar")){
                try{
                    CidadeDAOInterface dao = new CidadeDAO();
                    request.setAttribute("bdCidade", dao.retrieveAll());
                    
                    UfDAOInterface daoUf = new UfDAO();
                    request.setAttribute("bdUf", daoUf.retrieveAll());
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("editarcidades.jsp");
                    
                    r.forward(request, response);
                } catch (CidadeDAOException | UfDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("listaruf")){
                try{
                    UfDAOInterface dao = new UfDAO();
                    request.setAttribute("bdUf", dao.retrieveAll());
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("Cidade/CidadeInserirView.jsp");
                    
                    r.forward(request, response);
                } catch (UfDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("editar")){
                try{
                    UfDAOInterface dao = new UfDAO();
                    request.setAttribute("bdUf", dao.retrieveAll());
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("editarcidade.jsp");
                    
                    r.forward(request, response);
                } catch (UfDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("Alterar")){
                try{
                    CidadeDAOInterface dao = new CidadeDAO();
                    Cidade cidade = new Cidade(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("uf_id")),request.getParameter("nome"));
                    dao.update(cidade);
                    
                    RequestDispatcher r = request.getRequestDispatcher("CidadeController?ref=listar"); 
                    r.forward(request, response);
                }catch(CidadeDAOException e){
                    out.print(e.getMessage());
                }
            } else if(ref.equals("excluir")){
                try{
                    CidadeDAOInterface dao = new CidadeDAO();
                    dao.delete(Integer.parseInt(request.getParameter("id")));
                        
                    RequestDispatcher r = request.getRequestDispatcher("CidadeController?ref=listar");
                        
                    r.forward(request, response);
                } catch (CidadeDAOException e) {
                    out.print(e.getMessage());
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
