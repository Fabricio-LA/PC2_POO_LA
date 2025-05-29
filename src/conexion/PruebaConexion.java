package conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) {
        try {
            Connection conn = Conexion.getConnection();
            if (conn != null) {
                System.out.println("Conexion exitosa a la base de datos.");
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
    }
}
