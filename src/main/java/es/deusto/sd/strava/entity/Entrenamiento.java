package es.deusto.sd.strava.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Entrenamiento {
    private String titulo;
    private String deporte;
    private float distancia;
    private int duracion;
    private LocalDate fechaInicio;
    private String horaInicio;

    public Entrenamiento() {
    }

    public Entrenamiento(String titulo, String deporte, float distancia, int duracion, LocalDate fechaInicio,
            String horaInicio) {
        this.titulo = titulo;
        this.deporte = deporte;
        this.distancia = distancia;
        this.duracion = duracion;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public String toString() {
        return "Entrenamiento [deporte=" + deporte + ", distancia=" + distancia + ", duracion=" + duracion
                + ", fechaInicio=" + fechaInicio + ", horaInicio=" + horaInicio + ", titulo=" + titulo + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Entrenamiento entrenamiento = (Entrenamiento) o;
        return Float.compare(entrenamiento.distancia, distancia) == 0 && duracion == entrenamiento.duracion
                && titulo.equals(entrenamiento.titulo) && deporte.equals(entrenamiento.deporte)
                && fechaInicio.equals(entrenamiento.fechaInicio) && horaInicio.equals(entrenamiento.horaInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, horaInicio);
    }



}
