/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edison.dao;

import com.edison.model.Matricula;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author EDISON
 */
@Local
public interface MatriculaDaoLocal {

    void addMatricula(Matricula matricula);

    void editMatricula(Matricula matricula);

    void deleteMatricula(int matriculaId);

    Matricula getMatricula(int matriculaId);

    List<Matricula> getAllMatricula();
    
}
