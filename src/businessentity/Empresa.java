package businessentity;

public class Empresa {
    private String idEmpresa;
    private String nombre;
    private String rubro;
    private String direccion;
    private String telefono;
    private String correo;

    public Empresa() {}

    public Empresa(String idEmpresa, String nombre, String rubro, String direccion, String telefono, String correo) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.rubro = rubro;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
