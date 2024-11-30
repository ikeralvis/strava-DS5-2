package es.deusto.sd.strava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.deusto.sd.strava.dao.UsuarioRepository;
import es.deusto.sd.strava.dao.RetoRepository;
import es.deusto.sd.strava.entity.Reto;
import es.deusto.sd.strava.entity.TipoLogin;
import es.deusto.sd.strava.entity.Usuario;

import es.deusto.sd.strava.external.LoginServiceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioService {

    LoginServiceFactory loginServiceFactory = new LoginServiceFactory();

    private final UsuarioRepository usuarioRepository;
    
    @Autowired
    private RetoRepository retoRepository;

    // REPOSITORIO DE USUARIOS Y TOKENS
    private static Map<String, Usuario> tokenes = new HashMap<>();

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    // LOGIN :METODO QUE DEVUELVE UN TOKEN ALEATORIO PARA EL USUARIO
    public static synchronized String loginToken(String email, String password) {
        return Long.toHexString(System.currentTimeMillis());
    }

    // COMPROBAR SI EL USUARIO ES REGISTRABLE
    public Boolean esRegistable(String email, String contraseña, TipoLogin tipoLogin) {
        loginServiceFactory.getLoginServiceGateway(tipoLogin).comprobarEmail(email);
        //if (tipoLogin == TipoLogin.GOOGLE) {
            return loginServiceFactory.getLoginServiceGateway(TipoLogin.GOOGLE).comprobarEmail(email);
        //} else {
           // return MetaService.comprobarEmailContrasena(email, contraseña);

        //}
    }

    // AÑADIR USUARIO
    public void añadirUsuario(Usuario user) {
    if (user != null) {
        // Guardar los retos del usuario si existen
        if (user.getRetosAceptados() != null) {
            for (Reto reto : user.getRetosAceptados()) {
                retoRepository.save(reto); // Guardar reto en la base de datos
            }
        }
        // Guardar el usuario después de los retos
        usuarioRepository.save(user);
    }
}

    // LOGIN Y GENERAR TOKEN
    public Optional<String> login(String email, String password, TipoLogin tipoLogin) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email); 

        if (usuarioOpt.isPresent() && loginServiceFactory.getLoginServiceGateway(usuarioOpt.get().getTipoLogin()).login(email, password)) {
			String token = loginToken(email, password);
			tokenes.put(token, usuarioOpt.get());   
			return Optional.of(token); 		
		}	
    	return Optional.empty();

        //boolean credencialesValidas;

        /*if (tipoLogin == TipoLogin.GOOGLE) {
            credencialesValidas = googleServiceGateway.login(email, password);
        } else if (tipoLogin == TipoLogin.META) {
            credencialesValidas = MetaService.comprobarEmailContrasena(email, password);
        } else {
            throw new IllegalArgumentException("Tipo de login no soportado: " + tipoLogin);
        }*/
            
            
    }

    // LOGOUT Y BORRAR TOKEN
    public Optional<Boolean> logout(String token) {
        if (tokenes.containsKey(token)) {
            tokenes.remove(token);
            return Optional.of(true);
        } else {
            return Optional.empty();
        }
    }

    // OBTENER USUARIO POR TOKEN
    public Usuario usuarioPorToken(String token) {
        return tokenes.get(token);
    }

    // OBTENER USUARIO POR EMAIL
    /*public Optional<Usuario> usuarioPorEmail(String email) {
        if (!usuarios.containsKey(email)) {
            return Optional.empty();
        } else {
            return Optional.of(usuarios.get(email));
        }
    }*/

    // EXISTE USUARIO
    public Boolean existeUsuario(String email) {
        //return usuarios.containsKey(email);
        return usuarioRepository.existsByEmail(email); 
    }

    // CONSEGUIR TODOS LOS USUARIOS
    public List<Usuario> consultarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios; 
    }

    public boolean tokenValido(String token) {
        return tokenes.containsKey(token);
    }

}