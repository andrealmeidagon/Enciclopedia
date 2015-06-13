/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Vacina_DoencaDAO;
import DAO.Vacina_DoencaDAOInterface;
import Exceptions.Vacina_DoencaDAOException;
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
public class Vacina_DoencaController extends HttpServlet {

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
                    Vacina_DoencaDAOInterface dao = new Vacina_DoencaDAO();
                    Model.Vacina_Doenca correspond = new Model.Vacina_Doenca(Integer.parseInt(request.getParameter("doenca_id_doenca")), Integer.parseInt(request.getParameter("vacina_id_vacina")));
                    dao.insert(correspond);
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("Vacina_DoencaController?ref=listaruf");
                    
                    r.forward(request, response);
                } catch (Vacina_DoencaDAOException e) {
                    out.print(e.getMessage());
                }      
            }else if(ref.equals("Pesquisar")){
                    try{
                        Vacina_DoencaDAOInterface dao = new Vacina_DoencaDAO();
                        request.getSession().setAttribute("listar", dao.retrieveByIdLike(Integer.parseInt(request.getParameter("id_correspond_topico"))));
                        
                        //mudar esta linha
                        RequestDispatcher r = request.getRequestDispatcher("Vacina_Doenca/Vacina_DoencaPesquisaView.jsp");
                        
                        r.forward(request, response);
                } catch (Vacina_DoencaDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("excluir")){
                    try{
                        Vacina_DoencaDAOInterface dao = new Vacina_DoencaDAO();
                        dao.delete(Integer.parseInt(request.getParameter("id_doenca")),Integer.parseInt(request.getParameter("id_vacina")));
                        
                        //mudar esta linha
                        RequestDispatcher r = request.getRequestDispatcher("Vacina_DoencaController?ref=listar");
                        
                        r.forward(request, response);
                    } catch (Vacina_DoencaDAOException e) {
                        out.print(e.getMessage());
                }
            } else if(ref.equals("listar")){
                try{
                    Vacina_DoencaDAOInterface dao = new Vacina_DoencaDAO();
                    request.setAttribute("bdVacina_Doenca", dao.retrieveAll());
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("Vacina_Doenca/Vacina_DoencaView.jsp");
                    r.forward(request, response);
                } catch (Vacina_DoencaDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("editar")){
                try{
                    Vacina_DoencaDAOInterface dao = new Vacina_DoencaDAO();
                    request.setAttribute("listarCorrespondTopic", dao.retrieveAll());
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("Vacina_Doenca/Vacina_DoencaEditarView.jsp");
                    r.forward(request, response);
                } catch (Vacina_DoencaDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("Alterar")){
                try{
                    Vacina_DoencaDAOInterface dao = new Vacina_DoencaDAO();
                    Model.Vacina_Doenca correspond = new Model.Vacina_Doenca(Integer.parseInt(request.getParameter("doenca_id_doenca")), Integer.parseInt(request.getParameter("vacina_id_vacina")));
                    dao.update(correspond,Integer.parseInt(request.getParameter("id_doenca")),Integer.parseInt(request.getParameter("id_vacina")));
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("Vacina_DoencaController?ref=listar"); 
                    r.forward(request, response);
                }catch(Vacina_DoencaDAOException e){
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
