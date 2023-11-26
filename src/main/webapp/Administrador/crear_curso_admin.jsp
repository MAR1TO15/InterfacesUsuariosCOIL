<%-- 
    Document   : editar-info-profesor
    Created on : 18/11/2023, 10:05:31
    Author     : VICTUS
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
            #container{
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-content: center;
                margin: 30px 0;
            }
            #formulario-disable{
                margin-right: 10vh;
                width: 300px;
            }
            #formulario-active{
                margin-left: 10vh;
                width: 300px;
            }
            #boton-actualizar{
                margin-top: 5px;
                color: #ffffff;
                border: solid 3px #000000;
                border-radius: 5px;
                background-color: #333333;
                padding: 5px 7px;
            }
            #titulos{
                text-align: center;
            }
            input{
                text-align: center;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <!-- encabezado -->
        <div>
            <jsp:include page="header.jsp" />
        </div>
        <!-- fin -->
        <div>
            <div id="mensaje">
                <h1>Crear un Curso</h1>
            </div>
            <div id="container">
                <form id="formulario-crear" action="" autocomplete="off">
                    <h1 id="titulos">Datos del Curso</h1>
                    <div class="mb-3">
                        <label>Nombre del Curso:</label>
                        <input type="text" name="nombrecurso" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label>Número de Créditos:</label>
                        <input type="text" name="creditos" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label>Carrera:</label>
                        <input type="text" name="carrera" class="form-control" required>
                    </div>
                    <div id="botones">
                        <button type="submit" id="boton-crear" onclick="alert('Se ha creado el curso')">Crear</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- footer -->
        <div>
            <jsp:include page="footer.jsp" />
        </div>
        <!-- fin -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
