package model.bloque;

public class bloqueVo {
    public int idBloque;
    public String diaBloque;
    public String horaInicioBloque;
    public String horaFinalizacionBloque;
    public String estadoBloque;
    public String idSemana;

    public bloqueVo() {
    }

    public bloqueVo(int idBloque, String diaBloque, String horaInicioBloque, String horaFinalizacionBloque,
            String estadoBloque, String idSemana) {

        this.idBloque = idBloque;
        this.diaBloque = diaBloque;
        this.horaInicioBloque = horaInicioBloque;
        this.horaFinalizacionBloque = horaFinalizacionBloque;
        this.estadoBloque = estadoBloque;
        this.idSemana = idSemana;
    }

    public int getIdBloque() {
        return idBloque;
    }

    public void setIdBloque(int idBloque) {
        this.idBloque = idBloque;
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

    public String getEstadoBloque() {
        return estadoBloque;
    }

    public void setEstadoBloque(String estadoBloque) {
        this.estadoBloque = estadoBloque;
    }

    public String getIdSemana() {
        return idSemana;
    }

    public void setIdSemana(String idSemana) {
        this.idSemana = idSemana;
    }


}