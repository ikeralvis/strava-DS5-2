package es.deusto.sd.strava.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Reto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String deporte;

    @Column(nullable = false)
    private float objetivoDistancia;

    @Column(nullable = false)
    private int objetivoTiempo;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaInicio;

    @Temporal(TemporalType.TIMESTAMP)
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
