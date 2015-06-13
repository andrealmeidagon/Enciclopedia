/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CidadeDAO;
import DAO.CidadeDAOInterface;
import DAO.InstituicaoDAO;
import DAO.InstituicaoDAOInterface;
import DAO.UfDAO;
import DAO.UfDAOInterface;
import Exceptions.CidadeDAOException;
import Exceptions.InstituicaoDAOException;
import Exceptions.UfDAOException;
import Exceptions.VacinaDAOException;
import Model.Instituicao;
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
public class InstituicaoController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()){
            String ref = request.getParameter("ref");
            if(ref.equals("Cadastrar")){
                try{ 
                    InstituicaoDAOInterface dao = new InstituicaoDAO();
                    Instituicao instituicao = new Instituicao((Integer.parseInt(request.getParameter("cidade_id"))),request.getParameter("nome"), request.getParameter("sigla"));
                    dao.insert(instituicao);
                    RequestDispatcher r = request.getRequestDispatcher("InstituicaoController?ref=listarcidade");
                    
                    r.forward(request, response);
                }catch(InstituicaoDAOException e){
                    out.print(e.getMessage());
                }      
            }else if(ref.equals("listar")){
                try{
                    InstituicaoDAOInterface daoInst = new InstituicaoDAO();
                    request.setAttribute("bdInst", daoInst.retrieveAll());
                    
                    CidadeDAOInterface daoCidade = new CidadeDAO();
                    request.setAttribute("bdCidade", daoCidade.retrieveAll());
                    
                    UfDAOInterface daoUf = new UfDAO();
                    request.setAttribute("bdUf", daoUf.retrieveAll());
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("editarinstituicoes.jsp");
                    
                    r.forward(request, response);
                } catch (CidadeDAOException | UfDAOException | InstituicaoDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("listarcidade")){
                try{
                    CidadeDAOInterface daoCidade = new CidadeDAO();
                    request.setAttribute("bdCidade", daoCidade.retrieveAll());
                    
                    UfDAOInterface daoUf = new UfDAO();
                    request.setAttribute("bdUf", daoUf.retrieveAll());

                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("addinstituicao.jsp");
                    
                    r.forward(request, response);
                }catch(CidadeDAOException | UfDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("editar")){
                try{
                    CidadeDAOInterface daoCidade = new CidadeDAO();
                    request.setAttribute("bdCidade", daoCidade.retrieveAll());
                    
                    UfDAOInterface daoUf = new UfDAO();
                    request.setAttribute("bdUf", daoUf.retrieveAll());
                    
                    //mudar esta linha
                    RequestDispatcher r = request.getRequestDispatcher("Instituicao/InstituicaoEditarView.jsp");
                    
                    r.forward(request, response);
                } catch (CidadeDAOException | UfDAOException e) {
                    out.print(e.getMessage());
                }
            }else if(ref.equals("Alterar")){
                try{
                    InstituicaoDAOInterface dao = new InstituicaoDAO();
                    Instituicao instituicao = new Instituicao(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("cidade_id")),request.getParameter("nome"), request.getParameter("sigla"));
                    dao.update(instituicao);
                    
                    RequestDispatcher r = request.getRequestDispatcher("InstituicaoController?ref=listar"); 
                    r.forward(request, response);
                }catch(InstituicaoDAOException e){
                    out.print(e.getMessage());
                }
            }else if(ref.equals("excluir")){
                try{
                    InstituicaoDAOInterface dao = new InstituicaoDAO();
                    dao.delete(Integer.parseInt(request.getParameter("id")));
                    RequestDispatcher r = request.getRequestDispatcher("InstituicaoController?ref=listar");
                    r.forward(request, response);
                }catch(InstituicaoDAOException e){
                    out.print(e.getMessage());
                }
            }
            /*else if(ref.equals("Pesquisar")){
                try{
                    InstituicaoDAOInterface dao = new InstituicaoDAO();
                    
                    request.getSession().setAttribute("listar", dao.retrieveByNameLike(request.getParameter("nom_instituicao")));
                
                    RequestDispatcher r = request.getRequestDispatcher("Instituicao/InstituicaoPesquisaView.jsp");
                    r.forward(request, response);
                }catch(InstituicaoDAOException e){
                    out.print(e.getMessage());
                }
            }*/
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
