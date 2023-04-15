/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edison.dao;


import com.edison.model.Matricula;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class MatriculaDao implements MatriculaDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addMatricula(Matricula matricula) {
        em.persist(matricula);
    }

    @Override
    public void editMatricula(Matricula matricula) {
        em.merge(matricula);
    }

    @Override
    public void deleteMatricula(int matriculaId) {
        em.remove(getMatricula(matriculaId));
    }

    @Override
    public Matricula getMatricula(int matriculaId) {
        return em.find(Matricula.class, matriculaId);
    }

    @Override
    public List<Matricula> getAllMatricula() {
         return em.createNamedQuery("Matricula.getAll").getResultList();
    }
    
}
