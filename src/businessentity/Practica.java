package businessentity;

import java.sql.Date;

public class Practica {
    private String idPractica;
    private String idEstudiante;
    private String idEmpresa;
    private String idTutor;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;

    public Practica() {}

    public Practica(String idPractica, String idEstudiante, String idEmpresa, String idTutor, Date fechaInicio, Date fechaFin, String estado) {
        this.idPractica = idPractica;
        this.idEstudiante = idEstudiante;
        this.idEmpresa = idEmpresa;
        this.idTutor = idTutor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public String getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(String idPractica) {
        this.idPractica = idPractica;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(String idTutor) {
        this.idTutor = idTutor;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
