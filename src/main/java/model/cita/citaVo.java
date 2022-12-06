package model.cita;

public class citaVo {
    public int idCita;
    public String tipoServicio;
    public String idCliente;
    public String idMascota;
    public String idBloque;
    public String idUsuario;
    public String nombreMascota;
    public String nombreCliente;
    public String apellidoCliente;
    public String diaBloque;
    public String horaInicioBloque;
    public String horaFinalizacionBloque;
    


    public citaVo(){}

    public citaVo( int idCita ,String tipoServicio,  String idCliente, String idMascota ,String idBloque , String idUsuario, String nombreMascota, String nombreCliente, String apellidoCliente, String diaBloque, String horaInicioBloque, String horaFinalizacionBloque){

        this.idCita = idCita;
        this.tipoServicio = tipoServicio;
        this.idCliente = idCliente;
        this.idMascota = idMascota;
        this.idBloque = idBloque;
        this.idUsuario = idUsuario;
        this.nombreMascota = nombreMascota;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.diaBloque = diaBloque;
        this.horaInicioBloque = horaInicioBloque;
        this.horaFinalizacionBloque = horaFinalizacionBloque;
     }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getIdBloque() {
        return idBloque;
    }

    public void setIdBloque(String idBloque) {
        this.idBloque = idBloque;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
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

    public String getDiaBloque() {
        return diaBloque;
    }

    public void setDiaBloque(String diaBloque) {
        this.diaBloque = diaBloque;
    }

    public String getHoraInicioBloque() {
        return horaInicioBloque;
    }

    public void setHoraInicioBloque(String horaInicioBloque) {
        this.horaInicioBloque = horaInicioBloque;
    }

    public String getHoraFinalizacionBloque() {
        return horaFinalizacionBloque;
    }

    public void setHoraFinalizacionBloque(String horaFinalizacionBloque) {
        this.horaFinalizacionBloque = horaFinalizacionBloque;
    }

   

    
  
}