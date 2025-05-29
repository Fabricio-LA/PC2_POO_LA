package DAO;

import businessentity.Actividad;
import conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActividadDAO implements IBaseDAO<Actividad> {

    @Override
    public void insertar(Actividad a) {
        String sql = "INSERT INTO ACTIVIDADES VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getIdActividad());
            stmt.setString(2, a.getIdPractica());
            stmt.setDate(3, a.getFecha());
            stmt.setString(4, a.getDescripcion());
            stmt.setDouble(5, a.getHoras());
            stmt.setString(6, a.getEstado());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actualizar(Actividad a) {
        String sql = "UPDATE ACTIVIDADES SET ID_PRACTICA = ?, FECHA = ?, DESCRIPCION = ?, HORAS = ?, ESTADO = ? WHERE ID_ACTIVIDAD = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getIdPractica());
            stmt.setDate(2, a.getFecha());
            stmt.setString(3, a.getDescripcion());
            stmt.setDouble(4, a.getHoras());
            stmt.setString(5, a.getEstado());
            stmt.setString(6, a.getIdActividad());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM ACTIVIDADES WHERE ID_ACTIVIDAD = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Actividad obtenerPorID(String id) {
        String sql = "SELECT * FROM ACTIVIDADES WHERE ID_ACTIVIDAD = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Actividad(
                    rs.getString("ID_ACTIVIDAD"),
                    rs.getString("ID_PRACTICA"),
                    rs.getDate("FECHA"),
                    rs.getString("DESCRIPCION"),
                    rs.getDouble("HORAS"),
                    rs.getString("ESTADO")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Actividad> obtenerTodos() {
        List<Actividad> lista = new ArrayList<>();
        String sql = "SELECT * FROM ACTIVIDADES";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Actividad a = new Actividad(
                    rs.getString("ID_ACTIVIDAD"),
                    rs.getString("ID_PRACTICA"),
                    rs.getDate("FECHA"),
                    rs.getString("DESCRIPCION"),
                    rs.getDouble("HORAS"),
                    rs.getString("ESTADO")
                );
                lista.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
