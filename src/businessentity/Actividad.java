package businessentity;

import java.sql.Date;

public class Actividad {
    private String idActividad;
    private String idPractica;
    private Date fecha;
    private String descripcion;
    private double horas;
    private String estado;

    public Actividad() {}

    public Actividad(String idActividad, String idPractica, Date fecha, String descripcion, double horas, String estado) {
        this.idActividad = idActividad;
        this.idPractica = idPractica;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.horas = horas;
        this.estado = estado;
    }

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public String getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(String idPractica) {
        this.idPractica = idPractica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
