<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion matricula</title>
    </head>
    <body>
        <h1>Informacion matricula</h1>
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
    </tr>

</body>
</html>
