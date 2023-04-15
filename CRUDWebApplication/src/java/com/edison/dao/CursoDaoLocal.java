/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edison.dao;

import com.edison.model.Curso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author EDISON
 */
@Local
public interface CursoDaoLocal {

    void addCurso(Curso curso);

    void editCurso(Curso curso);

    void deleteCurso(int cursoId);

    Curso getCurso(int cursoId);

    List<Curso> getAllCurso();
    
}
