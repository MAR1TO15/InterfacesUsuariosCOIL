package dao;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import model.Curso;

public class CursoDAO {

    Conexion conn;

    public CursoDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(Curso cur) {

        String sql = "insert into curso values(?,?,?)";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cur.getId_curso());
            ps.setString(2, cur.getCarrera());
            ps.setInt(3, cur.getCredito());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean Actualizar(Curso cur) {

        String sql = "Update curso set credito = ?, Carrera = ?  where id_curso = ?";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cur.getId_curso());
            ps.setString(2, cur.getCarrera());
            ps.setInt(3, cur.getCredito());

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public List<Curso> consultarAll() {
        String sql = "SELECT * FROM curso";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Curso cur;
            List<Curso> lista = new LinkedList<>();
            while (rs.next()) {
                cur = new Curso(rs.getInt("id_curso"));
                cur.setCarrera(rs.getString("carrera"));
                cur.setCredito(rs.getInt("credito"));

                lista.add(cur);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }
    }

    public List<Curso> consultarById(int id) {
        String sql = "SELECT * FROM curso where id_curso = ?";
          try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Curso cur;
            List<Curso> lista = new LinkedList<>();
            while (rs.next()) {
                cur = new Curso(rs.getInt("id_curso"));
                cur.setCarrera(rs.getString("carrera"));
                cur.setCredito(rs.getInt("credito"));

                lista.add(cur);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }
    }

    public boolean borrar(int id) {
        String sql = "DELETE  FROM curso where id_curso = ?";
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
