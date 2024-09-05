package pe.edu.pe.grupo2.dtos;

import java.time.LocalTime;

public class NotificacionesDTO {
    private int idNotificacion;
    private String tituloNotificacion;
    private String descripcionNotificacion;
    private LocalTime fechaNotificacion;

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getTituloNotificacion() {
        return tituloNotificacion;
    }

    public void setTituloNotificacion(String tituloNotificacion) {
        this.tituloNotificacion = tituloNotificacion;
    }

    public String getDescripcionNotificacion() {
        return descripcionNotificacion;
    }

    public void setDescripcionNotificacion(String descripcionNotificacion) {
        this.descripcionNotificacion = descripcionNotificacion;
    }

    public LocalTime getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(LocalTime fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }
}
