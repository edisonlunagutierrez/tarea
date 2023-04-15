/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edison.controller;

import com.edison.dao.MatriculaDaoLocal;
import com.edison.model.Curso;
import com.edison.model.Matricula;
import com.edison.model.Student;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MatriculaServlet", urlPatterns = {"/MatriculaServlet"})
public class MatriculaServlet extends HttpServlet {
    @EJB
    private MatriculaDaoLocal matriculaDao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        //---------------------------------------------------------
        String action = request.getParameter("action");
        //---------------------------------------------------------
        String matriculaIdStr = request.getParameter("matriculaId");
        int matriculaId=0;
        if(matriculaIdStr!=null && !matriculaIdStr.equals("")){
            matriculaId= Integer.parseInt(matriculaIdStr);    
        }
        //---------------------------------------------------------
        String studentIdStr = request.getParameter("studentId");
        Integer studentId=0;
        if(studentIdStr!=null && !studentIdStr.equals("")){
            studentId=Integer.parseInt(studentIdStr);    
        }
        Student student = new Student(studentId, "", "", 0);
        //---------------------------------------------------------
        String cursoIdStr = request.getParameter("cursoId");
        Integer cursoId=0;
        if(cursoIdStr!=null && !cursoIdStr.equals("")){
            cursoId=Integer.parseInt(cursoIdStr);    
        }
        Curso curso = new Curso(cursoId,"", 0, 0, 0);
        //---------------------------------------------------------
        String fechaMatriculaStr =  request.getParameter("fechaMatricula");
       
        //---------------------------------------------------------
        String estadoMatricula = request.getParameter("estadoMatricula");
        //---------------------------------------------------------

        Matricula matricula = new Matricula(matriculaId, fechaMatriculaStr, estadoMatricula, student, curso);
        
        if("Add".equalsIgnoreCase(action)){
            matriculaDao.addMatricula(matricula);
        }else if("Edit".equalsIgnoreCase(action)){
            matriculaDao.editMatricula(matricula);
        }else if("Delete".equalsIgnoreCase(action)){
            matriculaDao.deleteMatricula(matriculaId);
        }else if("Search".equalsIgnoreCase(action)){
            matricula = matriculaDao.getMatricula(matriculaId);
        }
        request.setAttribute("matricula", matricula);
        request.setAttribute("allMatricula", matriculaDao.getAllMatricula());
        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(MatriculaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(MatriculaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
