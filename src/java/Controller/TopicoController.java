/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TopicoDAO;
import DAO.TopicoDAOInterface;
import Exceptions.TopicoDAOException;
import Model.Topico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author André
 */
public class TopicoController extends HttpServlet {

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
            out.print(ref);
            HttpSession session = request.getSession();
            if(ref.equals("Cadastrar")){
                try{ 
                    TopicoDAOInterface dao = new TopicoDAO();
                    int secao = 0, id;
                   
                    if(session.getAttribute("id")!=null){
                        id = Integer.parseInt((String)session.getAttribute("id"));
                    }else{
                        id = dao.newId();
                    }
                    
                    String desc = "", titulo = "";
                    
                    if(request.getParameter("especific")!=null){
                        desc = request.getParameter("especific");
                    }
                    
                    if(request.getParameter("titulo")!=null){
                        titulo = request.getParameter("titulo");
                    }
                    
                    String nvl = (String) session.getAttribute("nvlTopico");
                    if(Integer.parseInt(nvl)!=1){
                        secao = dao.tamSectionsByTopic(id)+1;
                    }
                    Topico topico = new Topico(id,secao,Integer.parseInt(nvl),desc,titulo);
                    dao.insert(topico);
                    
                    RequestDispatcher r = null;
                    if(Integer.parseInt(nvl)==1){
                        r = request.getRequestDispatcher("TopicoController?ref=listar");
                    }else{
                        r = request.getRequestDispatcher("TopicoController?ref=listarsecao");
                    }
                    
                    r.forward(request, response);
                } catch (TopicoDAOException e) {
                    out.print(e.getMessage());
                }      
            }else if(ref.equals("excluir")){
                    try{
                        TopicoDAOInterface dao = new TopicoDAO();
                        String nvl = (String) session.getAttribute("nvlTopico");
                        RequestDispatcher r = null;
                        if(Integer.parseInt(nvl)==1){
                            dao.delete(Integer.parseInt(request.getParameter("id")));
                            r = request.getRequestDispatcher("TopicoController?ref=listar");
                        }else{
                            dao.deleteBySectionAndLvl(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("secao")),Integer.parseInt(nvl));
                            r = request.getRequestDispatcher("TopicoController?ref=listarsecao");
                        }
                        
                        r.forward(request, response);
                    } catch (TopicoDAOException e) {
                        out.print(e.getMessage());
                }
            }else if(ref.equals("listar")){
                try{
                    session.removeAttribute("id");
                    
                    TopicoDAOInterface dao = new TopicoDAO();
                    request.setAttribute("bdTopico", dao.retrieveAllTopics());
                    String nvl = "1";
                    session.setAttribute("nvlTopico", nvl);
                    
                    RequestDispatcher r = request.getRequestDispatcher("topicos.jsp");
                    r.forward(request, response);
                } catch (TopicoDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("editar")){
                try{
                    TopicoDAOInterface dao = new TopicoDAO();
                    request.setAttribute("listaruf", dao.retrieveAll());
                     
                    //mudar linha
                    RequestDispatcher r = request.getRequestDispatcher("Topico/TopicoEditarView.jsp");
                    r.forward(request, response);
                } catch (TopicoDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("Alterar")){
                try{
                    TopicoDAOInterface dao = new TopicoDAO();
                    int secao = Integer.parseInt(request.getParameter("secao"));
                    String desc = "", titulo = "";

                    if(request.getParameter("especific")!=null){
                        desc = request.getParameter("especific");
                    }
                    
                    if(request.getParameter("titulo")!=null){
                        desc = request.getParameter("titulo");
                    }
                    
                    String nvl = (String) session.getAttribute("nvlTopico");
                    
                    Topico topico = new Topico(secao,Integer.parseInt(nvl),desc,titulo);
                    dao.update(topico,Integer.parseInt(request.getParameter("id")));
                     
                    //mudar linha
                    RequestDispatcher r = request.getRequestDispatcher("TopicoController?ref=listar"); 
                    r.forward(request, response);
                }catch(TopicoDAOException e){
                    out.print(e.getMessage());
                }
            }else if(ref.equals("edit") || ref.equals("add")){
                String value;
                if(ref.equals("edit")){
                    value = "Alterar";
                }else{
                    value = "Cadastrar";
                }
                request.setAttribute("value", value);
                    
                RequestDispatcher r = request.getRequestDispatcher("TopicoAdicionarView.jsp"); 
                r.forward(request, response);
            }else if(ref.equals("listarsecao")){
                try{
                    String id;
                    if(request.getParameter("id")!=null){
                        id = (String) request.getParameter("id");
                        session.setAttribute("id", id);
                    }else{
                        id = (String) session.getAttribute("id");
                    }
                    
                    TopicoDAOInterface dao = new TopicoDAO();
                    String strNvl = (String) session.getAttribute("nvlTopico");
                    int nvl = Integer.parseInt(strNvl);
                    
                    if(request.getParameter("tipo")!=null){
                        nvl += 1;
                    }
                    strNvl =""+nvl+"";
                    
                    request.setAttribute("bdTopico", dao.retrieveSectionByIdLike(Integer.parseInt(id), nvl));
                    session.setAttribute("nvlTopico", strNvl);
                    RequestDispatcher r = request.getRequestDispatcher("topicos.jsp");
                    r.forward(request, response);
                } catch (TopicoDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("voltar")){
                int nvl = Integer.parseInt((String) session.getAttribute("nvlTopico"))-1;
                String strNvl = ""+nvl+"";
                session.setAttribute("nvlTopico", strNvl); 
                
                RequestDispatcher r = null;
                if(nvl==1){
                    r = request.getRequestDispatcher("TopicoController?ref=listar");
                }else{
                    r = request.getRequestDispatcher("TopicoController?ref=listarsecao");
                }
                
                r.forward(request, response);
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
