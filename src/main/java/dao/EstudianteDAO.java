/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import model.Estudiante;


public class EstudianteDAO {

 Conexion conn;
    
   public EstudianteDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Estudiante estu) {

        String sql = "insert into estudiante values(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, estu.getId_estudiante());
            ps.setString(2,estu.getUsuario());
            ps.setString(3, estu.getPassword());
            ps.setString(4, estu.getNombre());
            ps.setString(5,estu.getApellido());
            ps.setString(6, estu.getCarrera());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean Actualizar(Estudiante estu) {

        String sql = "Update estudiante set usuario = ?, password = ?, nombre = ?, apellido = ?, carrera = ? where id_estudiante = ?";

        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, estu.getId_estudiante());
            ps.setString(2,estu.getUsuario());
            ps.setString(3, estu.getPassword());
            ps.setString(4, estu.getNombre());
            ps.setString(5,estu.getApellido());
            ps.setString(6, estu.getCarrera());
            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public List<Estudiante> consultarAll() {
        String sql = "SELECT * FROM estudiante";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Estudiante estu;
            List<Estudiante> lista = new LinkedList<>();
            while (rs.next()) {
               estu = new Estudiante(rs.getInt("id_estudiante"));
                estu.setUsuario(rs.getString("usuario"));
                estu.setPassword(rs.getString("password"));
                estu.setNombre(rs.getString("nombre"));
                estu.setApellido(rs.getString("apellido"));
                estu.setCarrera(rs.getString("carrera"));

                lista.add(estu);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }
    }

    public List<Estudiante> consultarById(int id) {
        String sql = "SELECT * FROM estudiante where id_estudiante = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
           Estudiante estu;
            List<Estudiante> lista = new LinkedList<>();
            while (rs.next()) {
               estu = new Estudiante(rs.getInt("id_estudiante"));
                estu.setUsuario(rs.getString("usuario"));
                estu.setPassword(rs.getString("password"));
                estu.setNombre(rs.getString("nombre"));
                estu.setApellido(rs.getString("apellido"));
                estu.setCarrera(rs.getString("carrera"));

                lista.add(estu);
            }
            return lista;

        } catch (Exception e) {
            return null;
        }
    }

    public boolean borrar(int id) {
        String sql = "DELETE  FROM estudiante where id_estudiante = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean login(String email, String password) {

        String sql = "SELECT email, password FROM usuario where email = ? and password = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
        } catch (Exception e) {

        }
        return true;

    }
}
