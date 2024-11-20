package es.deusto.sd.strava.dto;

import java.time.LocalDate;

public class RetoDTO {
    private String nombre;
    private String deporte;
    private float objetivoDistancia;
    private int objetivoTiempo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int Progreso;

    public RetoDTO() {
    }

    public RetoDTO(String nombre, String deporte, float objetivoDistancia, int objetivoTiempo,
    LocalDate fechaInicio, LocalDate fechaFin, int Progreso) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.objetivoDistancia = objetivoDistancia;
        this.objetivoTiempo = objetivoTiempo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.Progreso = Progreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public float getObjetivoDistancia() {
        return objetivoDistancia;
    }

    public void setObjetivoDistancia(float objetivoDistancia) {
        this.objetivoDistancia = objetivoDistancia;
    }

    public int getObjetivoTiempo() {
        return objetivoTiempo;
    }

    public void setObjetivoTiempo(int objetivoTiempo) {
        this.objetivoTiempo = objetivoTiempo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getProgreso() {
        return Progreso;
    }

    public void setProgreso(int Progreso) {
        this.Progreso = Progreso;
    }
}
