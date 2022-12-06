package model.semana;

public class semanaVo {
    public int idSemana;
    public String nombreSemana;
    public String fechaInicio;
    public String fechaFinalizacion;
    public String estadoSemana;

    public semanaVo(){}

    public semanaVo(int idSemana, String nombreSemana, String fechaInicio, String fechaFinalizacion, String estadoSemana) {

        this.idSemana = idSemana;
        this.nombreSemana = nombreSemana;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estadoSemana = estadoSemana;

    }

    public int getIdSemana() {
        return idSemana;
    }

    public void setIdSemana(int idSemana) {
        this.idSemana = idSemana;
    }

    public String getNombreSemana() {
        return nombreSemana;
    }

    public void setNombreSemana(String nombreSemana) {
        this.nombreSemana = nombreSemana;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getEstadoSemana() {
        return estadoSemana;
    }

    public void setEstadoSemana(String estadoSemana) {
        this.estadoSemana = estadoSemana;
    }

    

    
}
