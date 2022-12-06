package model.cliente;

public class clienteVo {
    
    public int idCliente;
    public String nombreCliente;
    public String apellidoCliente;
    public String tipoIdentificacion;
    public String identificacionCliente;
    public String direccionCliente;
    public String correoCliente;
    public String telefonoCliente;
    private String idCita;
    private String tipoServicio;
    private String horaCita;
    private String fechaCita;
    private String nombreMascota;
    private String idMascota;


    public clienteVo(){}

    public clienteVo(int idCliente, String nombreCliente, String apellidoCliente, String tipoIdentificacion,
    String identificacionCliente, String direccionCliente, String correoCliente, String telefonoCliente, String idCita,
    String tipoServicio, String horaCita, String fechaCita, String nombreMascota, String idMascota){

        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacionCliente = identificacionCliente;
        this.direccionCliente = direccionCliente;
        this.correoCliente = correoCliente;
        this.idCita = idCita;
        this.tipoServicio = tipoServicio;
        this.horaCita = horaCita;
        this.fechaCita = fechaCita;
        this.nombreMascota = nombreMascota;
        this.idMascota = idMascota;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    

   

    
}

