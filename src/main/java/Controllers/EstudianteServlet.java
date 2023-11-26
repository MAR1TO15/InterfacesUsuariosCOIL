package Controllers;

import Conexion.Conexion;
import dao.EstudianteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Estudiante;

@WebServlet(name = "EstudianteServlet", urlPatterns = {"/estu"})
public class EstudianteServlet extends HttpServlet {

    Conexion conn = new Conexion();
    EstudianteDAO estud = new EstudianteDAO(conn);
    String msg;
    RequestDispatcher rd;
    List<Estudiante> lista;
    boolean respuesta;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insert(request, response);
                break;
            case "actualizar":
                Actualizar(request, response);
                break;
            case "borrar":
                delete(request, response);
                break;

            case "consultarById":
                consultarById(request, response);
                break;

            case "consultarAll":
                consultarAll(request, response);
                break;
        }

    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usua");
        String password = request.getParameter("pass");
        String nombre = request.getParameter("nom");
        String apellido = request.getParameter("ape");
        String carrera = request.getParameter("carre");

        Estudiante estu = new Estudiante(0);
        estu.setUsuario(usuario);
        estu.setPassword(password);
        estu.setNombre(nombre);
        estu.setApellido(apellido);
        estu.setCarrera(carrera);

        respuesta = estud.insert(estu);
        lista = estud.consultarAll();
        request.setAttribute("lista", lista);
        if (respuesta) {
            msg = "Exito al registrar";
        } else {
            msg = "Error al registar";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/estudianteregistro.jsp");
        rd.forward(request, response);

    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usua");
        String password = request.getParameter("pass");
        String nombre = request.getParameter("nom");
        String apellido = request.getParameter("ape");
        String carrera = request.getParameter("carre");

        Estudiante estu = new Estudiante(0);
        estu.setUsuario(usuario);
        estu.setPassword(password);
        estu.setNombre(nombre);
        estu.setApellido(apellido);
        estu.setCarrera(carrera);

        respuesta = estud.insert(estu);
        lista = estud.consultarAll();
        request.setAttribute("lista", lista);
        if (respuesta) {
            msg = "Exito al registrar";
        } else {
            msg = "Error al registar";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/estudiantemostrar.jsp");
        rd.forward(request, response);

    }

    /* protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean res = userd.login(String email
        , String password;
        )

    }*/
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_estudiante"));

        respuesta = estud.borrar(id);
        if (respuesta) {
            msg = "Exito al borrar";
        } else {
            msg = "Error al borrar";
        }
        lista = estud.consultarAll();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/estudiantemostrar.jsp");
        rd.forward(request, response);
    }

    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_estudiante"));

        lista = estud.consultarById(id);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/estudianteregistro.jsp");
        rd.forward(request, response);
    }

    protected void consultarAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = estud.consultarAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/estudiantemostrar.jsp");
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
