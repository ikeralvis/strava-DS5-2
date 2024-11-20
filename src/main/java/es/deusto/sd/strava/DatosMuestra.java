package es.deusto.sd.strava;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.deusto.sd.strava.entity.Entrenamiento;
import es.deusto.sd.strava.entity.Reto;
import es.deusto.sd.strava.entity.Usuario;
import es.deusto.sd.strava.entity.TipoLogin;
import es.deusto.sd.strava.service.StravaService;
import es.deusto.sd.strava.service.UsuarioService;

@Configuration
public class DatosMuestra {

	private static final Logger logger = LoggerFactory.getLogger(DatosMuestra.class);
	
    @Bean
    CommandLineRunner initData(StravaService stravaService, UsuarioService UsuarioService) {
		return args -> {			

			// Entrenamientos de muestra
			Entrenamiento carreraMañana = new Entrenamiento("Carrera Matutina", "Correr", 5.0f, 30, LocalDate.of(2024, 1, 2), "08:00");
			Entrenamiento ciclismoRuta = new Entrenamiento("Ruta en Bicicleta", "Ciclismo", 20.0f, 60, LocalDate.of(2024, 1, 3), "10:00");
			List<Entrenamiento> entrenamientos = new ArrayList<Entrenamiento>();

			// Retos de muestra
			Reto maraton = new Reto("Maratón Ciudad", "Correr", 42.195f, 300, LocalDate.of(2024,01,01), LocalDate.of(2024,01,31));
			Reto triatlon = new Reto("Triatlón Olímpico", "Nadar-Correr-Ciclismo", 51.5f, 240, LocalDate.of(2024,02,01), LocalDate.of(2024,02,28));
			List<Reto> retos = new ArrayList<Reto>();
			retos.add(maraton);
			retos.add(triatlon);

			stravaService.crearReto(maraton);
			stravaService.crearReto(triatlon);
			logger.info("Retos registrados!");

			// Usuarios de muestra
			Usuario usainBolt = new Usuario("UsainBolt", "usain.bolt@athletics.com", "12-13-1978", TipoLogin.GOOGLE);
			Usuario michaelPhelps = new Usuario("MichaelPhelps", "michael.phelps@swimming.com", "06-30-1985", TipoLogin.META);
			Usuario serenaWilliams = new Usuario("SerenaWilliams", "serena.williams@tennis.com", "09-26-1981", TipoLogin.GOOGLE);
			Usuario lionelMessi = new Usuario("LionelMessi", "lionel.messi@soccer.com", "06-24-1987", TipoLogin.META);
			Usuario lebronJames = new Usuario("LeBronJames", "lebron.james@basketball.com", "12-30-1984", TipoLogin.GOOGLE);
			Usuario cristianoRonaldo = new Usuario("CristianoRonaldo", "cristiano.ronald@soccer.com", 80.0f, 1.87f, "02-05-1985", 220, 60, TipoLogin.META);	
			cristianoRonaldo.setEntrenamientos(entrenamientos);
			cristianoRonaldo.setRetosAceptados(retos);

			UsuarioService.añadirUsuario(usainBolt);
			UsuarioService.añadirUsuario(michaelPhelps);
			UsuarioService.añadirUsuario(serenaWilliams);
			UsuarioService.añadirUsuario(lionelMessi);
			UsuarioService.añadirUsuario(lebronJames);
			UsuarioService.añadirUsuario(cristianoRonaldo);
			logger.info("Usuarios registrados!");

			stravaService.crearEntrenamiento(carreraMañana,cristianoRonaldo);
			stravaService.crearEntrenamiento(ciclismoRuta,cristianoRonaldo);
			logger.info("Entrenamientos registrados!");

		};
	};
}