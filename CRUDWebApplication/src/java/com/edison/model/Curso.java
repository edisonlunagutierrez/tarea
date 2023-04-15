
package com.edison.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({@NamedQuery(name="Curso.getAll",query="SELECT e FROM Curso e")})
public class Curso implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int cursoId;
    @Column
    private String cursoName;
    @Column
    private int cursoCreditos;
    @Column
    private int cursoSemestres;
    @Column
    private int cursoEstudiantesAdmitidos;

//-----------------------------------
    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }
//-----------------------------------
    public String getCursoName() {
        return cursoName;
    }

    public void setCursoName(String cursoName) {
        this.cursoName = cursoName;
    }
//-----------------------------------
    public int getCursoCreditos() {
        return cursoCreditos;
    }

    public void setCursoCreditos(int cursoCreditos) {
        this.cursoCreditos = cursoCreditos;
    }
//-----------------------------------
    public int getCursoSemestres() {
        return cursoSemestres;
    }

    public void setCursoSemestres(int cursoSemestres) {
        this.cursoSemestres = cursoSemestres;
    }
//-----------------------------------
    public int getCursoEstudiantesAdmitidos() {
        return cursoEstudiantesAdmitidos;
    }

    public void setCursoEstudiantesAdmitidos(int cursoEstudiantesAdmitidos) {
        this.cursoEstudiantesAdmitidos = cursoEstudiantesAdmitidos;
    }

    public Curso(int cursoId, String cursoName, int cursoCreditos, int cursoSemestres,int cursoEstudiantesAdmitidos) {
        this.cursoId = cursoId;
        this.cursoName = cursoName;
        this.cursoCreditos = cursoCreditos;
        this.cursoSemestres = cursoSemestres;
        this.cursoEstudiantesAdmitidos = cursoEstudiantesAdmitidos;
    }
    
    public Curso(){}
}

