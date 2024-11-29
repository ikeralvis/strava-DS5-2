package es.deusto.sd.strava.external;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import org.springframework.data.jpa.repository.Meta;
import org.springframework.stereotype.Component;
 

@Component
public class MetaServiceGateway implements ILoginServiceGateway {
    private String serverIP;
    private int serverPort;
    private static String DELIMITER = "#";

    public MetaServiceGateway(String servIP, int servPort) {
        serverIP = servIP;
        serverPort = servPort;
    }

    public boolean login(String email, String password) {
        String mensaje = email + DELIMITER + password;
        String respuesta = "";
        StringTokenizer tokenizer;

        try (Socket socket = new Socket(serverIP, serverPort);
                // Streams to send and receive information are created from the Socket
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
            tokenizer = new StringTokenizer(respuesta, DELIMITER);

        } catch (UnknownHostException e) {
            System.err.println(" # SocketClient: Socket error: " + e.getMessage());
        } catch (EOFException e) {
            System.err.println(" # SocketClient: EOF error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println(" # SocketClient: IO error: " + e.getMessage());
        }
        // return translation;
        //return (tokenizer.nextToken().equals("OK")) ? tokenizer.nextToken() : "ERROR";
        return true;
    }

    @Override
    public boolean comprobarEmail(String email) {
        return true;
    }

    

    //ESTO LO TIENE QUE HACER EL SERVICE O EL FACTORIA
    
	/* public static void main(String args[]) {

		if (args.length < 2) {
			System.err.println(" # Usage: Trans. SocketClient [SERVER IP] [PORT] ");
			System.exit(1);
		}

		MetaServiceGateway client = new MetaServiceGateway(args[0], Integer.parseInt(args[1]));
		client.sendMessage("en", "es", "good morning");

		Scanner sc = new Scanner(System.in);
		String origin;
		String target;
		String message;

		while (true) {
			System.out.print(" - Type origin language (en, es, etc) or Q (to stop):\n - ");
			origin = sc.nextLine();

			if (origin.contains("Q")) {
				break;
			} else {
				origin = origin.substring(origin.indexOf(" ") + 1);
			}

			System.out.print(" - Type target language (en, es, etc):\n - ");
			target = sc.nextLine();
			target = target.substring(target.indexOf(" ") + 1);
			System.out.print(" - Enter the message to translate:\n - ");
			message = sc.nextLine();
			message = message.substring(message.indexOf(" ") + 1);
			client.sendMessage(origin, target, message);
		}

		sc.close();
	}
} */
}
