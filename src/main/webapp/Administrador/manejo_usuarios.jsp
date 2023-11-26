<%-- 
    Document   : manejo_usuarios
    Created on : 21 nov 2023, 10:45:13
    Author     : Mario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            #mensaje{
                display: flex;
                justify-content: center;
                align-content: center;
                background-color: #cccccc;
                width: 95%;
                margin: 20px 20px;
                padding: 2.5vh 0;
                border-radius: 8px;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registros</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <div>
            <jsp:include page="header.jsp" />
        </div>
        <div id="mensaje">
            <h1>Usuarios</h1>
        </div>
        <div class = "row justify-content-md-center">
            <div class="card w-25" style="width: 18rem;">
                <form action=""> 
                    <div class="form-group"> 
                        <label for="Carne">Carne:</label> 
                        <input type="text" class="form-control" id="carneB" name="nombre"> 
                    </div> 
                    <br>
                    <button type="submit" class="btn btn-primary" name="" value="">Buscar</button> 
                </form>
                <br>
                <a href="lista_Usuarios.jsp" class="btn btn-primary">Lista de Usuarios</a> 
                 <br>
            </div>
        </div>
        <div>
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
