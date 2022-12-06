package model.mascota;

public class mascotaVo {

    private int idMascota;
    private String nombreMascota;
    private String tipoMascota;
    private String razaMascota;
    private String pesoMascota;
    private String comportamientoMascota;
    private String idCliente;

    public mascotaVo() {
    }

    public mascotaVo(int idMascota, String nombreMascota, String tipoMascota, String razaMascota, String pesoMascota,
            String comportamientoMascota, String idCliente) {

        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.tipoMascota = tipoMascota;
        this.razaMascota = razaMascota;
        this.pesoMascota = pesoMascota;
        this.comportamientoMascota = comportamientoMascota;
        this.idCliente = idCliente;

    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }

    public String getPesoMascota() {
        return pesoMascota;
    }

    public void setPesoMascota(String pesoMascota) {
        this.pesoMascota = pesoMascota;
    }

    public String getComportamientoMascota() {
        return comportamientoMascota;
    }

    public void setComportamientoMascota(String comportamientoMascota) {
        this.comportamientoMascota = comportamientoMascota;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
}