
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion del estudiante</title>

        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
            }

            .container {
                max-width: 800px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0,0,0,0.3);
                border-radius: 5px;
                box-sizing: border-box;
                overflow: hidden;
            }

            h1 {
                margin-top: 0;
            }

            form {
                margin-bottom: 20px;
            }

            table {
                border-collapse: collapse;
                width: 100%;
                margin-bottom: 20px;
            }

            table td, table th {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }

            table th {
                background-color: #f2f2f2;
            }

            input[type="text"] {
                padding: 8px;
                border-radius: 5px;
                border: 1px solid #ccc;
                width: 100%;
                box-sizing: border-box;
                margin-bottom: 10px;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: #fff;
                border: none;
                border-radius: 5px;
                padding: 8px 12px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #3e8e41;
            }
        </style>
    </head>
    <body>

        <h1>Informacion del estudiante</h1>
        <form action="./StudentServlet"  method="POST">
            <table>
                <tr>
                    <td>Estudiante id</td>
                    <td><input type="text" name="studentId" value="${student.studentId}" /></td>
                </tr>
                <tr>
                    <td>Primer nombre</td>
                    <td><input type="text" name="firstname" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Segundo apellido</td>
                    <td><input type="text" name="lastname" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Semestre cursado</td>
                    <td><input type="text" name="yearLevel" value="${student.yearLevel}" /></td>
                </tr>               
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>                
                </tr>            
            </table>

            <br>
            <table border="1">
                <th>ID</th>
                <th> NOMBRE</th>
                <th>APELLIDO</th>
                <th>SEMESTRE CURSADO</th>
                    <c:forEach items="${allStudents}" var="stud">
                    <tr>
                        <td>${stud.studentId}</td>
                        <td>${stud.firstname}</td>
                        <td>${stud.lastname}</td>
                        <td>${stud.yearLevel}</td>
                    </tr>
                </c:forEach>
            </table>  
            <br>
        </form>  
        <h1>Informacion del curso</h1>
        <form action="./CursoServlet"  method="POST">
            <table>
                <tr>
                    <td>Curso id</td>
                    <td><input type="text" name="cursoId" value="${curso.cursoId}" /></td>
                </tr>
                <tr>
                    <td>Curso nombre</td>
                    <td><input type="text" name="cursoName" value="${curso.cursoName}" /></td>
                </tr>
                <tr>
                    <td># de creditos</td>
                    <td><input type="text" name="cursoCreditos" value="${curso.cursoCreditos}" /></td>
                </tr>
                <tr>
                    <td>nivel de semestre</td>
                    <td><input type="text" name="cursoSemestres" value="${curso.cursoSemestres}" /></td>
                </tr>               
                <tr>
                    <td>estudiantes admitidos</td>
                    <td><input type="text" name="cursoEstudiantesAdmitidos" value="${curso.cursoEstudiantesAdmitidos}" /></td>
                </tr>               
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>                
                </tr>            
            </table>
            <br>
            <table border="1">
                <th>CURSO ID</th>
                <th> CURSO NOMBRE</th>
                <th># CREDITOS</th>
                <th>SEMESTRE</th>
                <th>ESTUDIANTES ADMITIDOS</th>
                    <c:forEach items="${allCurso}" var="curs">
                    <tr>
                        <td>${curs.cursoId}</td>
                        <td>${curs.cursoName}</td>
                        <td>${curs.cursoCreditos}</td>
                        <td>${curs.cursoSemestres}</td>
                        <td>${curs.cursoEstudiantesAdmitidos}</td>
                    </tr>
                </c:forEach>
            </table>  
            <br>
        </form>  
        <h1>MATRICULA</h1>      
        <form action="./MatriculaServlet"  method="POST">
            <table>
                <tr>
                    <td>Matricula id</td>
                    <td><input type="text" name="matriculaId" value="${matricula.matriculaId}" /></td>
                </tr>
                <tr>
                    <td>Estudiante id</td>
                    <td><input type="text" name="studentId" value="${matricula.studentId.studentId}" /></td>
                </tr>
                <tr>
                    <td>Curso id</td>
                    <td><input type="text" name="cursoId" value="${matricula.cursoId.cursoId}" /></td>
                </tr>
                <tr>
                    <td>Fecha matricula</td>
                    <td><input type="text" name="fechaMatricula" value="${matricula.fechaMatricula}" /></td>
                </tr>
                <tr>
                    <td>Estado de la matricula</td>
                    <td><input type="text" name="estadoMatricula" value="${matricula.estadoMatricula}" /></td>
                </tr>                             
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>                
                </tr>            
            </table>
            <br>
            <table border="1">
                <th>Matricula id</th>
                <th>Estudiante id</th>
                <th>Curso id</th>
                <th>Fecha matricula</th>
                <th>Estado de la matricula</th>

                <c:forEach items="${allMatricula}" var="matric">
                    <tr>
                        <td>${matric.matriculaId}</td>
                        <td>${matric.studentId.studentId}</td>
                        <td>${matric.cursoId.cursoId}</td>
                        <td>${matric.fechaMatricula}</td>
                        <td>${matric.estadoMatricula}</td>
                    </tr>
                </c:forEach>
            </table>  
            <br>
        </form> 


    <tr>

        <!--<a href="http://localhost:8080/CRUDWebApplication/matriculainfo.jsp">Matricula</a>-->

    </tr>

</body>
</html>
