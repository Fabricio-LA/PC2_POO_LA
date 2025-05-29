package DAO;

import businessentity.Tutor;
import conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TutorDAO implements IBaseDAO<Tutor> {

    @Override
    public void insertar(Tutor t) {
        String sql = "INSERT INTO TUTORES VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, t.getIdTutor());
            stmt.setString(2, t.getNombres());
            stmt.setString(3, t.getApellidos());
            stmt.setString(4, t.getDni());
            stmt.setString(5, t.getCorreo());
            stmt.setString(6, t.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actualizar(Tutor t) {
        String sql = "UPDATE TUTORES SET NOMBRES = ?, APELLIDOS = ?, DNI = ?, CORREO = ?, TELEFONO = ? WHERE ID_TUTOR = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, t.getNombres());
            stmt.setString(2, t.getApellidos());
            stmt.setString(3, t.getDni());
            stmt.setString(4, t.getCorreo());
            stmt.setString(5, t.getTelefono());
            stmt.setString(6, t.getIdTutor());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM TUTORES WHERE ID_TUTOR = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Tutor obtenerPorID(String id) {
        String sql = "SELECT * FROM TUTORES WHERE ID_TUTOR = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Tutor(
                    rs.getString("ID_TUTOR"),
                    rs.getString("NOMBRES"),
                    rs.getString("APELLIDOS"),
                    rs.getString("DNI"),
                    rs.getString("CORREO"),
                    rs.getString("TELEFONO")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tutor> obtenerTodos() {
        List<Tutor> lista = new ArrayList<>();
        String sql = "SELECT * FROM TUTORES";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tutor t = new Tutor(
                    rs.getString("ID_TUTOR"),
                    rs.getString("NOMBRES"),
                    rs.getString("APELLIDOS"),
                    rs.getString("DNI"),
                    rs.getString("CORREO"),
                    rs.getString("TELEFONO")
                );
                lista.add(t);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
