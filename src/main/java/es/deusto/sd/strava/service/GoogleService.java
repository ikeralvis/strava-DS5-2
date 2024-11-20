package es.deusto.sd.strava.service;

import org.springframework.stereotype.Service;

@Service
public class GoogleService {

    // SIMULACION

        // REGISTRO: METODO QUE DEVUELVE UN BOOLEANO SI LA CONTRASEÑA DEL USUARIO ES CORRECTA
        public static Boolean comprobarEmailContrasena(String email, String password) {
            if (email != "" && password != "") {
                return true;
            } else {
                return false;
            }
        }

        // LOGIN :METODO QUE DEVUELVE UN TOKEN ALEATORIO SI EL CORREO Y EL EMAIL EXISTEN EN LA BD
        public static synchronized String loginToken(String email, String password) {
            return Long.toHexString(System.currentTimeMillis());
        }

}
