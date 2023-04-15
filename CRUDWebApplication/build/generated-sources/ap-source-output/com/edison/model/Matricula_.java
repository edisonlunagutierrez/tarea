package com.edison.model;

import com.edison.model.Curso;
import com.edison.model.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-04-13T20:39:52")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, String> estadoMatricula;
    public static volatile SingularAttribute<Matricula, Student> studentId;
    public static volatile SingularAttribute<Matricula, Integer> matriculaId;
    public static volatile SingularAttribute<Matricula, String> fechaMatricula;
    public static volatile SingularAttribute<Matricula, Curso> cursoId;

}