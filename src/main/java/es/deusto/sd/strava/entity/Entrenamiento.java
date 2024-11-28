package es.deusto.sd.strava.entity;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "entrenamiento")
public class Entrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String deporte;

    @Column(nullable = false)
    private float distancia;

    @Column(nullable = false)
    private int duracion;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private String horaInicio;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
