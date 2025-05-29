package DAO;

import businessentity.Empresa;
import conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO implements IBaseDAO<Empresa> {

    @Override
    public void insertar(Empresa e) {
        String sql = "INSERT INTO EMPRESAS VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getIdEmpresa());
            stmt.setString(2, e.getNombre());
            stmt.setString(3, e.getRubro());
            stmt.setString(4, e.getDireccion());
            stmt.setString(5, e.getTelefono());
            stmt.setString(6, e.getCorreo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actualizar(Empresa e) {
        String sql = "UPDATE EMPRESAS SET NOMBRE = ?, RUBRO = ?, DIRECCION = ?, TELEFONO = ?, CORREO = ? WHERE ID_EMPRESA = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getRubro());
            stmt.setString(3, e.getDireccion());
            stmt.setString(4, e.getTelefono());
            stmt.setString(5, e.getCorreo());
            stmt.setString(6, e.getIdEmpresa());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM EMPRESAS WHERE ID_EMPRESA = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Empresa obtenerPorID(String id) {
        String sql = "SELECT * FROM EMPRESAS WHERE ID_EMPRESA = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Empresa(
                    rs.getString("ID_EMPRESA"),
                    rs.getString("NOMBRE"),
                    rs.getString("RUBRO"),
                    rs.getString("DIRECCION"),
                    rs.getString("TELEFONO"),
                    rs.getString("CORREO")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Empresa> obtenerTodos() {
        List<Empresa> lista = new ArrayList<>();
        String sql = "SELECT * FROM EMPRESAS";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Empresa e = new Empresa(
                    rs.getString("ID_EMPRESA"),
                    rs.getString("NOMBRE"),
                    rs.getString("RUBRO"),
                    rs.getString("DIRECCION"),
                    rs.getString("TELEFONO"),
                    rs.getString("CORREO")
                );
                lista.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
