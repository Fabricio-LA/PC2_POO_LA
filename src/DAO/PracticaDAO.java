package DAO;

import businessentity.Practica;
import conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PracticaDAO implements IBaseDAO<Practica> {

    @Override
    public void insertar(Practica p) {
        String sql = "INSERT INTO PRACTICAS VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getIdPractica());
            stmt.setString(2, p.getIdEstudiante());
            stmt.setString(3, p.getIdEmpresa());
            stmt.setString(4, p.getIdTutor());
            stmt.setDate(5, p.getFechaInicio());
            stmt.setDate(6, p.getFechaFin());
            stmt.setString(7, p.getEstado());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actualizar(Practica p) {
        String sql = "UPDATE PRACTICAS SET ID_ESTUDIANTE = ?, ID_EMPRESA = ?, ID_TUTOR = ?, FECHA_INICIO = ?, FECHA_FIN = ?, ESTADO = ? WHERE ID_PRACTICA = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getIdEstudiante());
            stmt.setString(2, p.getIdEmpresa());
            stmt.setString(3, p.getIdTutor());
            stmt.setDate(4, p.getFechaInicio());
            stmt.setDate(5, p.getFechaFin());
            stmt.setString(6, p.getEstado());
            stmt.setString(7, p.getIdPractica());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM PRACTICAS WHERE ID_PRACTICA = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Practica obtenerPorID(String id) {
        String sql = "SELECT * FROM PRACTICAS WHERE ID_PRACTICA = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Practica(
                    rs.getString("ID_PRACTICA"),
                    rs.getString("ID_ESTUDIANTE"),
                    rs.getString("ID_EMPRESA"),
                    rs.getString("ID_TUTOR"),
                    rs.getDate("FECHA_INICIO"),
                    rs.getDate("FECHA_FIN"),
                    rs.getString("ESTADO")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Practica> obtenerTodos() {
        List<Practica> lista = new ArrayList<>();
        String sql = "SELECT * FROM PRACTICAS";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Practica p = new Practica(
                    rs.getString("ID_PRACTICA"),
                    rs.getString("ID_ESTUDIANTE"),
                    rs.getString("ID_EMPRESA"),
                    rs.getString("ID_TUTOR"),
                    rs.getDate("FECHA_INICIO"),
                    rs.getDate("FECHA_FIN"),
                    rs.getString("ESTADO")
                );
                lista.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
