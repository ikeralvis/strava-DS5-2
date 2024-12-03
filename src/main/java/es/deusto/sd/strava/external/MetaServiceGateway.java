package es.deusto.sd.strava.external;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import org.springframework.stereotype.Component;

import es.deusto.sd.strava.entity.TipoLogin;

import java.util.Scanner;

@Component
public class MetaServiceGateway implements ILoginServiceGateway {
    private String serverIP;
    private int serverPort;
    private static String DELIMITER = "#";
    private static String login = "LGIN";
    private static String comprobarEmail = "CMPE";

    public MetaServiceGateway(String servIP, int servPort) {
        serverIP = servIP;
        serverPort = servPort;
    }

    public MetaServiceGateway() {
        serverIP = "localhost";
        serverPort = 8083;
    }

    public boolean login(String email, String password) {
        String mensaje = login + DELIMITER + email + DELIMITER + password;
        String respuesta = "";

        try (Socket socket = new Socket(serverIP, serverPort);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            // Send request (one String) to the server
            out.writeUTF(mensaje);
            System.out.println(" - Enviando credenciales a '" + socket.getInetAddress().getHostAddress() + ":"
                    + socket.getPort() + "' -> '" + mensaje + "'");

            // Read response (one String) from the server
            respuesta = in.readUTF();
            System.out.println(" - Obteniendo respuesta '" + socket.getInetAddress().getHostAddress() + ":"
                    + socket.getPort() + "' -> '" + respuesta + "'");

        } catch (UnknownHostException e) {
            System.err.println(" # SocketClient: Socket error: " + e.getMessage());
        } catch (EOFException e) {
            System.err.println(" # SocketClient: EOF error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println(" # SocketClient: IO error: " + e.getMessage());
        }
        return respuesta.equalsIgnoreCase("TRUE");
    }

    @Override
    public boolean comprobarEmail(String email) {
        String mensaje = comprobarEmail + DELIMITER + email;
        String respuesta = "";

        try (Socket socket = new Socket(serverIP, serverPort);
            // Streams to send and receive information are created from the Socket
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            // Send request (one String) to the server
            out.writeUTF(mensaje);
            System.out.println(" - Enviando email a '" + socket.getInetAddress().getHostAddress() + ":"
                + socket.getPort() + "' -> '" + mensaje + "'");

            // Read response (one String) from the server
            respuesta = in.readUTF();
            System.out.println(" - Obteniendo respuesta '" + socket.getInetAddress().getHostAddress() + ":"
                + socket.getPort() + "' -> '" + respuesta + "'");

        } catch (UnknownHostException e) {
            System.err.println(" # SocketClient: Socket error: " + e.getMessage());
        } catch (EOFException e) {
            System.err.println(" # SocketClient: EOF error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println(" # SocketClient: IO error: " + e.getMessage());
        }
        
        return respuesta.equalsIgnoreCase("TRUE");
    }
}
