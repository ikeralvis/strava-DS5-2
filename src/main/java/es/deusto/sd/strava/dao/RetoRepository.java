package es.deusto.sd.strava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.deusto.sd.strava.entity.Reto;

@Repository
public interface RetoRepository extends JpaRepository<Reto, Long> {
    List<Reto> findByUsuarioId(Long usuarioId);
    
    
}
