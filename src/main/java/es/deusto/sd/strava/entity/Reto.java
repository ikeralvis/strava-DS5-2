package es.deusto.sd.strava.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Reto {
    private String nombre;
    private String deporte;
    private float objetivoDistancia;
    private int objetivoTiempo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reto() {
    }

    public Reto(String nombre, String deporte, float objetivoDistancia, int objetivoTiempo,
    LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.objetivoDistancia = objetivoDistancia;
        this.objetivoTiempo = objetivoTiempo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Reto reto = (Reto) o;
        return Float.compare(reto.objetivoDistancia, objetivoDistancia) == 0 && objetivoTiempo == reto.objetivoTiempo
                && Objects.equals(nombre, reto.nombre) && Objects.equals(deporte, reto.deporte)
                && Objects.equals(fechaInicio, reto.fechaInicio) && Objects.equals(fechaFin, reto.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, deporte);
    }

    @Override
    public String toString() {
        return "Reto{" +
                "nombre='" + nombre + '\'' +
                ", deporte='" + deporte + '\'' +
                ", objetivoDistancia=" + objetivoDistancia +
                ", objetivoTiempo=" + objetivoTiempo +
                '}';
    }
}
