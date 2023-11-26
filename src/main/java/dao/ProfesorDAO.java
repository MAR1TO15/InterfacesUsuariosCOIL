
package dao;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import model.Profesor;

public class ProfesorDAO {
Conexion conn;
    
   public ProfesorDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Profesor prof) {

        String sql = "insert into profesor values(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, prof.getId_profesor());
            ps.setString(2,prof.getUsuario());
            ps.setString(3, prof.getPassword());
            ps.setString(4, prof.getNombre());
            ps.setString(5,prof.getApellido());
            ps.setString(6, prof.getCarrera());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean Actualizar(Profesor prof) {

        String sql = "Update profesor set usuario = ?, password = ?, nombre = ?, apellido = ?, carrera = ? where id_profesor = ?";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, prof.getId_profesor());
            ps.setString(2,prof.getUsuario());
            ps.setString(3, prof.getPassword());
            ps.setString(4, prof.getNombre());
            ps.setString(5,prof.getApellido());
            ps.setString(6, prof.getCarrera());


            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public List<Profesor> consultarAll() {
        String sql = "SELECT * FROM profesor";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Profesor prof;
            List<Profesor> lista = new LinkedList<>();
            while (rs.next()) {
               prof = new Profesor(rs.getInt("id_profesor"));
                prof.setUsuario(rs.getString("usuario"));
                prof.setPassword(rs.getString("password"));
                prof.setNombre(rs.getString("nombre"));
                prof.setApellido(rs.getString("apellido"));
                prof.setCarrera(rs.getString("carrera"));

                lista.add(prof);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }
    }

    public List<Profesor> consultarById(int id) {
        String sql = "SELECT * FROM profesor where id_profesor = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Profesor prof;
            List<Profesor> lista = new LinkedList<>();
            while (rs.next()) {
               prof = new Profesor(rs.getInt("id_profesor"));
                prof.setUsuario(rs.getString("usuario"));
                prof.setPassword(rs.getString("password"));
                prof.setNombre(rs.getString("nombre"));
                prof.setApellido(rs.getString("apellido"));
                prof.setCarrera(rs.getString("carrera"));

                lista.add(prof);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }
    }

    public boolean borrar(int id) {
        String sql = "DELETE  FROM profesor where id_profesor = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean login(String usuario, String password) {

        String sql = "SELECT usuario, password FROM profesor where usuario = ? and password = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                 return true;
            }

        } catch (Exception e) {
            
            return false;
        }
         return false;

    }
}
