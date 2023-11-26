<%-- 
    Document   : consulta_notas_estudiante
    Created on : 18/11/2023, 10:10:40
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
                margin-left:30px ; /* Ajusta el margen exterior de la tabla */
                margin-right: 40px;
                margin-bottom: 120px;
                width: 90%;
            }
            #container{
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-content: center;
                margin: 30px 0;
            }
            
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notas</title>
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
                <h1>Notas</h1>
            </div>
            <div id="container">
                <table border="1" class="table table-dark table-striped-columns" id="container2">
                    <thead>
                        <tr>
                            <th>Curso</th>
                            <th>Primer Parcial</th>
                            <th>Segundo Parcial</th>
                            <th>Examen Final</th>
                            <th>Tareas</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Ejemplo</td>
                            <td>0.00</td>
                            <td>0.00</td>
                            <td>0.00</td>
                            <td>0.00</td>
                            <td>0.00</td>
                        </tr>
                        <tr>
                            <td>Ejemplo2</td>
                            <td>0.00</td>
                            <td>0.00</td>
                            <td>0.00</td>
                            <td>0.00</td>
                            <td>0.00</td>
                        </tr>
                        <tr>
                            <td>Ejemplo3</td>
                            <td>0.00</td>
                            <td>0.00</td>
                            <td>0.00</td>
                            <td>0.00</td>
                            <td>0.00</td>
                        </tr>
                        
                    </tbody>
                </table>


            </div>
            <!-- footer -->
            <div>
                <jsp:include page="footer.jsp" />
            </div>
            <!-- fin -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
