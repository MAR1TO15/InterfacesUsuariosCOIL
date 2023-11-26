package Controllers;

import Conexion.Conexion;
import dao.ProfesorDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Profesor;

@WebServlet(name = "ProfesorServlet", urlPatterns = {"/prof"})
public class ProfesorServlet extends HttpServlet {

    Conexion conn = new Conexion();
    ProfesorDAO profd = new ProfesorDAO(conn);
    String msg;
    RequestDispatcher rd;
    List<Profesor> lista;
    boolean respuesta;
    boolean res;

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

            case "login":
                login(request, response);
                break;

            case "logout":
                logout(request, response);
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

        Profesor prof = new Profesor(0);
        prof.setUsuario(usuario);
        prof.setPassword(password);
        prof.setNombre(nombre);
        prof.setApellido(apellido);
        prof.setCarrera(carrera);

        respuesta = profd.insert(prof);
        lista = profd.consultarAll();
        request.setAttribute("lista", lista);
        if (respuesta) {
            msg = "Exito al registrar";
        } else {
            msg = "Error al registar";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/profesorregistro.jsp");
        rd.forward(request, response);

    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usua");
        String password = request.getParameter("pass");
        String nombre = request.getParameter("nom");
        String apellido = request.getParameter("ape");
        String carrera = request.getParameter("carre");

        Profesor prof = new Profesor(0);
        prof.setUsuario(usuario);
        prof.setPassword(password);
        prof.setNombre(nombre);
        prof.setApellido(apellido);
        prof.setCarrera(carrera);

        respuesta = profd.insert(prof);
        lista = profd.consultarAll();
        request.setAttribute("lista", lista);
        if (respuesta) {
            msg = "Exito al registrar";
        } else {
            msg = "Error al registar";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/profesormostrar.jsp");
        rd.forward(request, response);

    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usua");
        String password = request.getParameter("pass");

        res = profd.login(usuario, password);

        if (res) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            response.sendRedirect("index.jsp");

        } else {
            msg = "Usuario no existe o pass";
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        sesion.invalidate();
        response.sendRedirect("login.jsp");

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_profesor"));

        respuesta = profd.borrar(id);
        if (respuesta) {
            msg = "Exito al borrar";
        } else {
            msg = "Error al borrar";
        }
        lista = profd.consultarAll();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/profesormostrar.jsp");
        rd.forward(request, response);
    }

    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_profesor"));

        lista = profd.consultarById(id);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/profesorregistro.jsp");
        rd.forward(request, response);
    }

    protected void consultarAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = profd.consultarAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/profesormostrar.jsp");
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
