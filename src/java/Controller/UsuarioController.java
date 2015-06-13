/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InstituicaoDAO;
import DAO.InstituicaoDAOInterface;
import DAO.UsuarioDAO;
import DAO.UsuarioDAOInterface;
import Exceptions.InstituicaoDAOException;
import Exceptions.UsuarioDAOException;
import Model.Usuario;
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
public class UsuarioController extends HttpServlet {

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try (PrintWriter out = response.getWriter()){
            String ref = request.getParameter("ref");
            if(ref.equals("Cadastrar")){
                try{
                    Usuario novo = new Usuario(Integer.parseInt(request.getParameter("instituicao_id")), Integer.parseInt(request.getParameter("type")),request.getParameter("email"), request.getParameter("nome"), request.getParameter("senha"));
                    UsuarioDAOInterface dao = new UsuarioDAO();
                    dao.insert(novo);
                    
                    RequestDispatcher r = request.getRequestDispatcher("UsuarioController?ref=listarinst");
                    
                    r.forward(request, response);
                }catch(UsuarioDAOException e){
                    out.print(e.getMessage());
                }
            }else if(ref.equals("listar")){
                try{
                    UsuarioDAOInterface daoUser = new UsuarioDAO();
                    request.setAttribute("bdUsuario", daoUser.retrieveAll(Integer.parseInt(request.getParameter("type"))));
                    
                    InstituicaoDAOInterface daoInst = new InstituicaoDAO();
                    request.setAttribute("bdInst", daoInst.retrieveAll());
                    
                    RequestDispatcher r = null;
                    if(Integer.parseInt(request.getParameter("type"))==1)
                        r = request.getRequestDispatcher("editar.jsp"); 
                    else
                        r = request.getRequestDispatcher("editaraluno.jsp"); 
                    
                    r.forward(request, response);
                } catch (UsuarioDAOException | InstituicaoDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("listarinst")){
                try{
                    InstituicaoDAOInterface dao = new InstituicaoDAO();
                    request.setAttribute("listarinst", dao.retrieveAll());
                    
                    RequestDispatcher r = null;
                    if(Integer.parseInt(request.getParameter("type"))==1)
                        r = request.getRequestDispatcher("addadm.jsp"); 
                    else
                        r = request.getRequestDispatcher("addaluno.jsp"); 
                    
                    r.forward(request, response);
                }catch(InstituicaoDAOException e){
                    out.print(e.getMessage());
                }
            }else if(ref.equals("editar")){
                try{
                    InstituicaoDAOInterface dao = new InstituicaoDAO();
                    request.setAttribute("bdInst", dao.retrieveAll());
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("editaradm.jsp"); 
                    
                    r.forward(request, response);
                }catch(InstituicaoDAOException e){
                    out.print(e.getMessage());
                }
            }else if(ref.equals("Alterar")){
                try{
                    UsuarioDAOInterface dao = new UsuarioDAO();
                    Usuario usuario = new Usuario(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("instituicao_id")), Integer.parseInt(request.getParameter("type")), request.getParameter("email"), request.getParameter("nome"), request.getParameter("senha"));
                    dao.update(usuario);
                    
                    RequestDispatcher r = request.getRequestDispatcher("UsuarioController?ref=listar");
                    
                    r.forward(request, response);
                }catch(UsuarioDAOException e){
                    out.print(e.getMessage());
                }
            }else if(ref.equals("excluir")){
                try{
                    UsuarioDAOInterface dao = new UsuarioDAO();
                    dao.delete(Integer.parseInt(request.getParameter("id")));
                    
                    RequestDispatcher r = request.getRequestDispatcher("UsuarioController?ref=listar");
                    
                    r.forward(request, response);
                }catch(UsuarioDAOException e){
                    out.print(e.getMessage());
                }
            }else if(ref.equals("Entrar")){
                try{
                    UsuarioDAOInterface dao = new UsuarioDAO();
                    RequestDispatcher r = null;
                    
                    if(dao.userExists(request.getParameter("login"))){
                        Usuario usuario = dao.retrieveByEmailLike(request.getParameter("login"));
                        if(usuario.getSenha_usuario().equals(request.getParameter("senha"))){
                            session.setAttribute("admin",usuario);
                            r = request.getRequestDispatcher("adm.jsp");
                        }else{
                            r = request.getRequestDispatcher("login.jsp?ref=senhaerrada");
                        }
                    }else{
                        r = request.getRequestDispatcher("enciclopedia.jsp");
                    }
                    r.forward(request, response);
                } catch (UsuarioDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("sair")){
                session.invalidate();
                RequestDispatcher r = request.getRequestDispatcher("index.jsp");
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
