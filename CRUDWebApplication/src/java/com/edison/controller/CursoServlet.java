package com.edison.controller;

import com.edison.dao.CursoDaoLocal;
import com.edison.model.Curso;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {
    @EJB
    private CursoDaoLocal cursoDao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //---------------------------------------------------------
        String action = request.getParameter("action");
        //---------------------------------------------------------
        String cursoIdStr = request.getParameter("cursoId");
        int cursoId=0;
        if(cursoIdStr!=null && !cursoIdStr.equals("")){
            cursoId=Integer.parseInt(cursoIdStr);    
        }
        //---------------------------------------------------------
        String cursoName = request.getParameter("cursoName");
        //---------------------------------------------------------
        String creditosStr = request.getParameter("cursoCreditos");
        int cursoCreditos=0;
        if(creditosStr!=null && !creditosStr.equals("")){
            cursoCreditos=Integer.parseInt(creditosStr);    
        }
        //---------------------------------------------------------
        String semestreStr = request.getParameter("cursoSemestres");
        int cursoSemestres=0;
        if(semestreStr!=null && !semestreStr.equals("")){
            cursoSemestres=Integer.parseInt(semestreStr);
        }
        //---------------------------------------------------------
        //---------------------------------------------------------
        String estudi_admiStr = request.getParameter("cursoEstudiantesAdmitidos");
        int cursoEstudiantesAdmitidos=0;
        if(estudi_admiStr!=null && !estudi_admiStr.equals("")){
            cursoEstudiantesAdmitidos=Integer.parseInt(estudi_admiStr);
        }
        //---------------------------------------------------------
        Curso curso = new Curso(cursoId, cursoName, cursoCreditos, cursoSemestres, cursoEstudiantesAdmitidos);
        
        if("Add".equalsIgnoreCase(action)){
            cursoDao.addCurso(curso);
        }else if("Edit".equalsIgnoreCase(action)){
            cursoDao.editCurso(curso);
        }else if("Delete".equalsIgnoreCase(action)){
            cursoDao.deleteCurso(cursoId);
        }else if("Search".equalsIgnoreCase(action)){
            curso = cursoDao.getCurso(cursoId);
        }
        request.setAttribute("curso", curso);
        request.setAttribute("allCurso", cursoDao.getAllCurso());
        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

