package Controllers;

import Conexion.Conexion;
import dao.CarreraDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import models.Carrera;

@WebServlet(name = "CarreraServlet", urlPatterns = {"/carre"})


    public class CarreraServlet extends HttpServlet {

        Conexion conn = new Conexion();
        CarreraDAO carred = new CarreraDAO(conn);
        String msg;
        RequestDispatcher rd;
        List<Carrera> lista;
        boolean respuesta;

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String action = request.getParameter("action");
            switch (action) {
                case "insertar":
                    insertar(request, response);
                    break;
                case "actualizar":
                    Actualizar(request, response);
                    break;
                case "borrar":
                    borrar(request, response);
                    break;
                case "consultarById":
                    consultarById(request, response);
                    break;
                case "consultarAll":
                    consultarAll(request, response);
                    break;
            }

        }

        protected void insertar(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String nombre = request.getParameter("nom");

            Carrera carre = new Carrera(0);
            carre.setNombre(nombre);

            respuesta = carred.insertar(carre);
            lista = carred.consultarAll();
            request.setAttribute("lista", lista);
            if (respuesta) {
                msg = "Exito al registrar";
            } else {
                msg = "Error al registar";
            }
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("/registroc.jsp");
            rd.forward(request, response);

        }

        protected void Actualizar(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String nombre = request.getParameter("nomb");

            Carrera carre = new Carrera(0);
            carre.setNombre(nombre);

            respuesta = carred.Actualizar(carre);
            lista = carred.consultarAll();
            request.setAttribute("lista", lista);
            if (respuesta) {
                msg = "Exito al Actualizar";
            } else {
                msg = "Error al Actualizar";
            }
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("/mostrarc.jsp");
            rd.forward(request, response);

        }

        protected void borrar(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id_carrera"));

            respuesta = carred.borrar(id);
            if (respuesta) {
                msg = "Exito al borrar";
            } else {
                msg = "Error al borrar";
            }
            lista = carred.consultarAll();
            request.setAttribute("lista", lista);
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("/mostrarc.jsp");
            rd.forward(request, response);
        }

        protected void consultarById(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id_carrera"));

            lista = carred.consultarById(id);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/registroc.jsp");
            rd.forward(request, response);
        }

        protected void consultarAll(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            lista = carred.consultarAll();
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/mostrarc.jsp");
            rd.forward(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

    }
