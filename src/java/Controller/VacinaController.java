/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VacinaDAO;
import DAO.VacinaDAOInterface;
import Exceptions.VacinaDAOException;
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
public class VacinaController extends HttpServlet {

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
            if(ref.equals("Inserir")){
                try{ 
                    VacinaDAOInterface dao = new VacinaDAO();
                    Model.Vacina vacina = new Model.Vacina(Integer.parseInt(request.getParameter("vacina_id_vacina")),request.getParameter("nome"));
                    dao.insert(vacina);
                    
                    RequestDispatcher r = request.getRequestDispatcher("VacinaController?ref=listar");
                    
                    r.forward(request, response);
                } catch (VacinaDAOException e) {
                    out.print(e.getMessage());
                }      
            }else if(ref.equals("Pesquisar")){
                    try{
                        VacinaDAOInterface dao = new VacinaDAO();
                        request.getSession().setAttribute("listar", dao.retrieveByIdLike(Integer.parseInt(request.getParameter("id_cidade"))));
                    
                        RequestDispatcher r = request.getRequestDispatcher("Vacina/VacinaPesquisaView.jsp");
                        
                        r.forward(request, response);
                } catch (VacinaDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("excluir")){
                    try{
                        VacinaDAOInterface dao = new VacinaDAO();
                        dao.delete(Integer.parseInt(request.getParameter("id")));
                        
                        RequestDispatcher r = request.getRequestDispatcher("VacinaController?ref=listar");
                        
                        r.forward(request, response);
                    } catch (VacinaDAOException e) {
                        out.print(e.getMessage());
                }
            } else if(ref.equals("listar")){
                try{
                    VacinaDAOInterface dao = new VacinaDAO();
                    request.setAttribute("bdVacina", dao.retrieveAll());
                    RequestDispatcher r = request.getRequestDispatcher("vacinas.jsp");
                    r.forward(request, response);
                } catch (VacinaDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("Alterar")){
                try{
                    VacinaDAOInterface dao = new VacinaDAO();
                    Model.Vacina vacina = new Model.Vacina(Integer.parseInt(request.getParameter("vacina_id_vacina")),request.getParameter("nome"));
                    dao.update(vacina,Integer.parseInt(request.getParameter("id")));
                    
                    RequestDispatcher r = request.getRequestDispatcher("VacinaController?ref=listar"); 
                    r.forward(request, response);
                }catch(VacinaDAOException e){
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
