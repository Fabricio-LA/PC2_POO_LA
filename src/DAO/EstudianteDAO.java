package DAO;

import businessentity.Estudiante;
import conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO implements IBaseDAO<Estudiante> {

    @Override
    public void insertar(Estudiante e) {
        String sql = "INSERT INTO ESTUDIANTES VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getIdEstudiante());
            stmt.setString(2, e.getNombres());
            stmt.setString(3, e.getApellidos());
            stmt.setString(4, e.getDni());
            stmt.setString(5, e.getCorreo());
            stmt.setString(6, e.getCarrera());
            stmt.setString(7, e.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actualizar(Estudiante e) {
        String sql = "UPDATE ESTUDIANTES SET NOMBRES = ?, APELLIDOS = ?, DNI = ?, CORREO = ?, CARRERA = ?, TELEFONO = ? WHERE ID_ESTUDIANTE = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombres());
            stmt.setString(2, e.getApellidos());
            stmt.setString(3, e.getDni());
            stmt.setString(4, e.getCorreo());
            stmt.setString(5, e.getCarrera());
            stmt.setString(6, e.getTelefono());
            stmt.setString(7, e.getIdEstudiante());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM ESTUDIANTES WHERE ID_ESTUDIANTE = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Estudiante obtenerPorID(String id) {
        String sql = "SELECT * FROM ESTUDIANTES WHERE ID_ESTUDIANTE = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estudiante(
                    rs.getString("ID_ESTUDIANTE"),
                    rs.getString("NOMBRES"),
                    rs.getString("APELLIDOS"),
                    rs.getString("DNI"),
                    rs.getString("CORREO"),
                    rs.getString("CARRERA"),
                    rs.getString("TELEFONO")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM ESTUDIANTES";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Estudiante e = new Estudiante(
                    rs.getString("ID_ESTUDIANTE"),
                    rs.getString("NOMBRES"),
                    rs.getString("APELLIDOS"),
                    rs.getString("DNI"),
                    rs.getString("CORREO"),
                    rs.getString("CARRERA"),
                    rs.getString("TELEFONO")
                );
                lista.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
