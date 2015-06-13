/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UfDAO;
import DAO.UfDAOInterface;
import Exceptions.UfDAOException;
import Model.Uf;
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
public class UfController extends HttpServlet {

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
                    UfDAOInterface dao = new UfDAO();
                    Uf uf = new Uf(request.getParameter("nome"),request.getParameter("sigla"));
                    dao.insert(uf);
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("editarinstituicoes.jsp");
                    
                    r.forward(request, response);
                } catch (UfDAOException e) {
                    out.print(e.getMessage());
                }      
            }else if(ref.equals("adicionar")){
                
                RequestDispatcher r = request.getRequestDispatcher("addestado.jsp"); 
                r.forward(request, response);
                
            }else if(ref.equals("listar")){
                try{
                    UfDAOInterface dao = new UfDAO();
                    request.setAttribute("bdUf", dao.retrieveAll());
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("editarestados.jsp");
                    r.forward(request, response);
                } catch (UfDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("Alterar")){
                try{
                    UfDAOInterface dao = new UfDAO();
                    Uf uf = new Uf(Integer.parseInt(request.getParameter("id")),request.getParameter("nome"),request.getParameter("sigla"));
                    dao.update(uf);
                    
                    RequestDispatcher r = request.getRequestDispatcher("UfController?ref=listar"); 
                    r.forward(request, response);
                }catch(UfDAOException e){
                    out.print(e.getMessage());
                }
            }else if(ref.equals("editar")){
                RequestDispatcher r = request.getRequestDispatcher("editarestado.jsp"); 
                r.forward(request, response);
            }else if(ref.equals("excluir")){
                try{
                    UfDAOInterface dao = new UfDAO();
                    dao.delete(Integer.parseInt(request.getParameter("id")));
                     
                    RequestDispatcher r = request.getRequestDispatcher("UfController?ref=listar");
                       
                    r.forward(request, response);
                } catch (UfDAOException e) {
                    out.print(e.getMessage());
                }
            /*}else if(ref.equals("Pesquisar")){
                try{
                    UfDAOInterface dao = new UfDAO();
                    request.getSession().setAttribute("listar", dao.retrieveByNameLike(request.getParameter("nom_uf")));

                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("Uf/UfPesquisaView.jsp");

                    r.forward(request, response);
                } catch (UfDAOException e) {
                    out.print(e.getMessage());
                }
            */
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
