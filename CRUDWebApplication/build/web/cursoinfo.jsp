
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion del curso</title>
    </head>
    <body>
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

    <tr>
    </tr>

</body>
</html>