/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Conexion.Conexion;
import dao.CursoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Curso;

/**
 *
 * @author jefry
 */
@WebServlet(name = "CursoServlet", urlPatterns = {"/cur"})
public class CursoServlet extends HttpServlet {

    Conexion conn = new Conexion();
    CursoDAO curd = new CursoDAO(conn);
    String msg;
    RequestDispatcher rd;
    List<Curso> lista;
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

        String carrera = request.getParameter("carre");
        int credito = Integer.parseInt(request.getParameter("credi"));

        Curso cur = new Curso(0);
        cur.setCarrera(carrera);
        cur.setCredito(credito);

        respuesta = curd.insertar(cur);
        lista = curd.consultarAll();
        request.setAttribute("lista", lista);
        if (respuesta) {
            msg = "Exito al registrar";
        } else {
            msg = "Error al registar";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/cursoregistro.jsp");
        rd.forward(request, response);

    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String carrera = request.getParameter("carre");
        int credito = Integer.parseInt(request.getParameter("credi"));

        Curso cur = new Curso(0);
        cur.setCarrera(carrera);
        cur.setCredito(credito);

        respuesta = curd.insertar(cur);
        lista = curd.consultarAll();
        request.setAttribute("lista", lista);
        if (respuesta) {
            msg = "Exito al registrar";
        } else {
            msg = "Error al registar";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/cursomostrar.jsp");
        rd.forward(request, response);

    }

    protected void borrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_curso"));

        respuesta = curd.borrar(id);
        if (respuesta) {
            msg = "Exito al borrar";
        } else {
            msg = "Error al borrar";
        }
        lista = curd.consultarAll();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/cursomostrar.jsp");
        rd.forward(request, response);
    }

    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_curso"));

        lista = curd.consultarById(id);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/cursoregistro.jsp");
        rd.forward(request, response);
    }

    protected void consultarAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = curd.consultarAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/cursomostrar.jsp");
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
