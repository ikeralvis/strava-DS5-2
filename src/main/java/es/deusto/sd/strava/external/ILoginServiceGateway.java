package es.deusto.sd.strava.external;

import es.deusto.sd.strava.entity.TipoLogin;

public interface ILoginServiceGateway {
    public boolean login(String email, String password);
    public TipoLogin getTipoLogin();
}
