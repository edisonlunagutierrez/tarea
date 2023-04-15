/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edison.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "Matricula.getAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.getByStudentId", query = "SELECT m FROM Matricula m WHERE m.studentId.studentId = :studentId"),
    @NamedQuery(name = "Matricula.getByCursoId", query = "SELECT m FROM Matricula m WHERE m.cursoId.cursoId = :cursoId")
})
public class Matricula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int matriculaId;

    @Column
    private String fechaMatricula;

    @Column
    private String estadoMatricula;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;

    @ManyToOne
    @JoinColumn(name = "cursoId")
    private Curso cursoId;

    public Matricula() {
    }

    public Matricula(int matriculaId, String fechaMatricula, String estadoMatricula, Student studentId, Curso cursoId) {
        this.matriculaId = matriculaId;
        this.fechaMatricula = fechaMatricula;
        this.estadoMatricula = estadoMatricula;
        this.studentId = studentId;
        this.cursoId = cursoId;
    }

    public int getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(int matriculaId) {
        this.matriculaId = matriculaId;
    }

    public String getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(String fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getEstadoMatricula() {
        return estadoMatricula;
    }

    public void setEstadoMatricula(String estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Curso getCursoId() {
        return cursoId;
    }

    public void setCursoId(Curso cursoId) {
        this.cursoId = cursoId;
    }
    
}

