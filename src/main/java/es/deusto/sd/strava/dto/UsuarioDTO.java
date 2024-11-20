package es.deusto.sd.strava.dto;

import es.deusto.sd.strava.entity.TipoLogin;

public class UsuarioDTO {
    String contrasenya;
    String email;
    TipoLogin tipoLogin;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String contrasenya, String email, TipoLogin tipoLogin) {
        this.contrasenya = contrasenya;
        this.email = email;
        this.tipoLogin = tipoLogin;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoLogin getTipoLogin() {
        return tipoLogin;
    }

    public void setTipoLogin(TipoLogin tipoLogin) {
        this.tipoLogin = tipoLogin;
    }
}
