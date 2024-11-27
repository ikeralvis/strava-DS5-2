package es.deusto.sd.strava.service;

import org.springframework.stereotype.Service;

@Service
public class GoogleService {

    // SIMULACION

        // REGISTRO: METODO QUE DEVUELVE UN BOOLEANO SI LA CONTRASEÑA DEL USUARIO ES CORRECTA
        public static Boolean comprobarEmailContrasena(String email, String password) {
            if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

}
