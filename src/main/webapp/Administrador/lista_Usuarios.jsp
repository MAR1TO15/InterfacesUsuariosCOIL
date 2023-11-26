<%-- 
   Document   : lista_Usuarios
   Created on : 21 nov 2023, 12:17:33
   Author     : Mario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Usuarios</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <div>
            <jsp:include page="header.jsp" />
        </div>
        <h1>Lista de Estudiantes</h1> 
        <table border="1" class="table"> 

            <th>Id</th> 
            <th>Nombre</th>
            <th>Carne</th> 
            <th>Carrera</th>
            <th>Administrar</th> 

            <c:forEach items="" var="p" varStatus="status"> 

                <td>${p.id}</td> 
                <td>${p.nombre}</td>
                <td>${p.carne}</td> 
                <td>${p.carrera}</td> 
                <td> 
                    <a href="" class="btn btn-primary">Editar</a> 
                    <a href="" class="btn btn-danger">Eliminar</a> 
                </td> 

            </c:forEach> 
        </table> 
        <div>
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
