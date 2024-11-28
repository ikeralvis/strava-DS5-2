package es.deusto.sd.strava.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.deusto.sd.strava.entity.Credenciales;

@Repository
public interface CredencialesRepository extends JpaRepository<Credenciales, String> {

    Optional<Credenciales> findByEmail(String email);
}