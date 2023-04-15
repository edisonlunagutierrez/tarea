package com.edison.dao;

import com.edison.model.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CursoDao implements CursoDaoLocal {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addCurso(Curso curso) {
        em.persist(curso);
    }

    @Override
    public void editCurso(Curso curso) {
        em.merge(curso);
    }

    @Override
    public void deleteCurso(int cursoId) {
        em.remove(getCurso(cursoId));
    }

    @Override
    public Curso getCurso(int cursoId) {
        return em.find(Curso.class, cursoId);
    }

    @Override
    public List<Curso> getAllCurso() {
        return em.createNamedQuery("Curso.getAll").getResultList();
    }

}

