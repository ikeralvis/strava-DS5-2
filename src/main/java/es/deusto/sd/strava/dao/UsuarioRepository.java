package es.deusto.sd.strava.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import es.deusto.sd.strava.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {


}
