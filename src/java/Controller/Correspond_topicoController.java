/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Correspond_topicoDAO;
import DAO.Correspond_topicoDAOInterface;
import Exceptions.Correspond_topicoDAOException;
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
public class Correspond_topicoController extends HttpServlet {

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
                    Correspond_topicoDAOInterface dao = new Correspond_topicoDAO();
                    Model.Correspond_topico correspond_topico = new Model.Correspond_topico(Integer.parseInt(request.getParameter("doenca_id_doenca")), Integer.parseInt(request.getParameter("vacina_id_vacina")), Integer.parseInt(request.getParameter("topico_id_topico")));
                    dao.insert(correspond_topico);
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("CidadeController?ref=listaruf");
                    
                    r.forward(request, response);
                } catch (Correspond_topicoDAOException e) {
                    out.print(e.getMessage());
                }      
            }else if(ref.equals("Pesquisar")){
                    try{
                        Correspond_topicoDAOInterface dao = new Correspond_topicoDAO();
                        request.getSession().setAttribute("listar", dao.retrieveByIdLike(Integer.parseInt(request.getParameter("id_correspond_topico"))));
                        
                        //mudar esta linha
                        RequestDispatcher r = request.getRequestDispatcher("Cidade/CidadePesquisaView.jsp");
                        
                        r.forward(request, response);
                } catch (Correspond_topicoDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("excluir")){
                    try{
                        Correspond_topicoDAOInterface dao = new Correspond_topicoDAO();
                        dao.delete(Integer.parseInt(request.getParameter("id")));
                        
                        //mudar esta linha
                        RequestDispatcher r = request.getRequestDispatcher("CidadeController?ref=listar");
                        
                        r.forward(request, response);
                    } catch (Correspond_topicoDAOException e) {
                        out.print(e.getMessage());
                }
            } else if(ref.equals("listar")){
                try{
                    Correspond_topicoDAOInterface dao = new Correspond_topicoDAO();
                    request.setAttribute("bdCorrespondTopic", dao.retrieveAll());
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("Cidade/CidadeView.jsp");
                    r.forward(request, response);
                } catch (Correspond_topicoDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("editar")){
                try{
                    Correspond_topicoDAOInterface dao = new Correspond_topicoDAO();
                    request.setAttribute("listarCorrespondTopic", dao.retrieveAll());
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("Cidade/CidadeEditarView.jsp");
                    r.forward(request, response);
                } catch (Correspond_topicoDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("Alterar")){
                try{
                    Correspond_topicoDAOInterface dao = new Correspond_topicoDAO();
                    Model.Correspond_topico correspond_topico = new Model.Correspond_topico(Integer.parseInt(request.getParameter("doenca_id_doenca")), Integer.parseInt(request.getParameter("vacina_id_vacina")), Integer.parseInt(request.getParameter("topico_id_topico")));
                    dao.update(correspond_topico,Integer.parseInt(request.getParameter("id")));
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("CidadeController?ref=listar"); 
                    r.forward(request, response);
                }catch(Correspond_topicoDAOException e){
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
