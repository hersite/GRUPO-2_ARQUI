package pe.edu.pe.grupo2.dtos;

public class CantidadNotiUsuarioDTO {
    private String nombres;
    private int cantidad_notif;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getCantidad_notif() {
        return cantidad_notif;
    }

    public void setCantidad_notif(int cantidad_notif) {
        this.cantidad_notif = cantidad_notif;
    }

}
