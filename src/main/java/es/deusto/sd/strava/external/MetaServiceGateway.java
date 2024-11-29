package es.deusto.sd.strava.external;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import es.deusto.sd.strava.entity.TipoLogin;

public class MetaServiceGateway implements ILoginServiceGateway  {

    @Override
    public boolean login(String email, String password) {
        
        /*try (Socket socket = new Socket("server_address", server_port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(email);
            out.println(password);

            String response = in.readLine();
            return "success".equals(response);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }*/
        return true;
    }

    @Override
    public TipoLogin getTipoLogin() {
        return TipoLogin.META;
    }
    
}
