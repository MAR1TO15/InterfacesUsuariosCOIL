
package dao;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import models.Carrera;


public class CarreraDAO {
    Conexion conn;

    public CarreraDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(Carrera carre) {

        String sql = "insert into carrera values(?,?)";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, carre.getId_carrera());
            ps.setString(2, carre.getNombre());
           

            ps.executeUpdate();
            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean Actualizar(Carrera carre) {

        String sql = "Update carrera set nombre = ? where id_carrera = ?";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setInt(1, carre.getId_carrera());
            ps.setString(2, carre.getNombre());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public List<Carrera> consultarAll() {
        String sql = "SELECT * FROM carrera";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Carrera carre;
            List<Carrera> lista = new LinkedList<>();
            while (rs.next()) {
                carre = new Carrera(rs.getInt("id_carrera"));
                carre.setNombre(rs.getString("nombre"));
               

                lista.add(carre);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }
    }

   public List<Carrera> consultarById(int id) {
        String sql = "SELECT * FROM carrera where id_carrera = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Carrera carre;
            List<Carrera> lista = new LinkedList<>();
            while (rs.next()) {
                carre = new Carrera(rs.getInt("id_carrera"));
                carre.setNombre(rs.getString("nombre"));
               

                lista.add(carre);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }
    }

    public boolean borrar(int id) {
        String sql = "DELETE  FROM carrera where id_carrera = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
