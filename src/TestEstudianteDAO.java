import businessentity.Estudiante;
import DAO.EstudianteDAO;
import java.util.List;

/*public class TestEstudianteDAO {
    public static void main(String[] args) {
        EstudianteDAO dao = new EstudianteDAO();

        Estudiante nuevo = new Estudiante(
            "U88887777", // ID_ESTUDIANTE
            "Valeria Andrea", // NOMBRES
            "Lopez Gutierrez", // APELLIDOS
            "88887777", // DNI
            "u88887777@uni.edu.pe", // CORREO
            "Ingeniería de Software", // CARRERA
            "+51987654321" // TELEFONO
        );

        dao.insertar(nuevo);
        System.out.println("✅ Estudiante insertado correctamente.");
    }
}*/

public class TestEstudianteDAO {
    public static void main(String[] args) {
        EstudianteDAO DAO = new EstudianteDAO();

        // Obtener todos los estudiantes
        List<Estudiante> lista = DAO.obtenerTodos();

        System.out.println("Lista de estudiantes:");
        for (Estudiante e : lista) {
            System.out.println(
                e.getIdEstudiante() + " | " +
                e.getNombres() + " " + e.getApellidos() + " | " +
                e.getCarrera() + " | " +
                e.getCorreo()
            );
        }
    }
}

