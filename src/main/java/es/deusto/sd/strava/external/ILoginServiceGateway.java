package es.deusto.sd.strava.external;



public interface ILoginServiceGateway {
    public boolean login(String email, String password);
    public boolean comprobarEmail(String email);
}
