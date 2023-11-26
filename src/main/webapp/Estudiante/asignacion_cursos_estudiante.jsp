<%-- 
    Document   : asignacion_cursos_estudiante
    Created on : 18/11/2023, 13:14:46
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
                margin-left:35px ;
                margin-right: 30px;
                padding: 2.5vh 0;
                border-radius: 8px;
            }
            #container2 {
                margin-left:250px ;
                margin-right: 40px;
                margin-bottom: 150px;
                width: 70%;
            }
            #container{
                display: flex;
                flex-direction: row;
                justify-content: center;
                margin-left: 40px;
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
                margin-top: 20px;
                margin-left: 20px;
                color: #ffffff;
                border: solid 3px #000000;
                border-radius: 5px;
                background-color: #333333;
                padding: 5px 7px;
            }
            #titulo{
                text-align: center;
            }
            input{
                text-align: center;
            }
            td{
                text-align: center;
            }
            tr{
                text-align: center;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asignación de Cursos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <!-- encabezado -->
        <div>
            <jsp:include page="header.jsp" />
        </div>
        <!-- Fin encabezado -->

        <div>
            <div id="mensaje">
                <h1>Asignación de Cursos</h1>
            </div>

            <div id="container">
                <!-- Formualario de los datos actuales del usuario -->
                <form id="formulario-disable">
                    <div class="mb-3">
                        <label>Carrera:</label>
                        <input type="text" name="nombre" class="form-control">
                    </div>
                </form>
                <!-- Inicio del formulario de actualizacion de datos -->
                <form id="formulario-active" action="" autocomplete="off">

                    <div class="mb-3">
                        <label>Semestre:</label>
                        <input type="text" name="nombre" class="form-control" required>

                    </div>
                </form>
                <div id="botones">
                    <button type="submit" id="boton-actualizar" onclick="alert('Datos actualizados')">Buscar</button>
                </div>
            </div>
            <div id="container2" >
                <table border="1" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Cursos</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Ejemplo1</td>
                            <td><a class="btn btn-secondary">Asignar</a></td>
                        </tr>
                        <tr>
                            <td>Ejemplo2</td>
                            <td><a class="btn btn-secondary">Asignar</a></td>
                        </tr>
                        <tr>
                            <td>Ejemplo3</td>
                            <td><a class="btn btn-secondary">Asignar</a></td>
                        </tr>
                        <tr>
                            <td>Ejemplo4</td>
                            <td><a class="btn btn-secondary">Asignar</a></td>
                        </tr>
                        
                    </tbody>
                </table>

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


