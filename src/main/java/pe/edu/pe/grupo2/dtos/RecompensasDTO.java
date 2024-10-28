package pe.edu.pe.grupo2.dtos;

import pe.edu.pe.grupo2.entities.Actividad;

import java.time.LocalDate;

public class RecompensasDTO {
    private int idRecompensas;
    private String nombreRecompensa;
    private String codigoQR;
    private LocalDate fechaVencimiento;
    private String descripcionRecompensa;

    private Actividad ac;

    public int getIdRecompensas() {
        return idRecompensas;
    }

    public void setIdRecompensas(int idRecompensas) {
        this.idRecompensas = idRecompensas;
    }

    public String getNombreRecompensa() {
        return nombreRecompensa;
    }

    public void setNombreRecompensa(String nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }

    public String getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Actividad getAc() {
        return ac;
    }

    public void setAc(Actividad ac) {
        this.ac = ac;
    }

    public String getDescripcionRecompensa() {
        return descripcionRecompensa;
    }

    public void setDescripcionRecompensa(String descripcionRecompensa) {
        this.descripcionRecompensa = descripcionRecompensa;
    }
}
