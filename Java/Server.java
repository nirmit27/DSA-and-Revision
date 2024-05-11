
import java.io.*;
import java.net.*;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private BufferedReader input = null;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println(String.format("\nServer listening on port %d", port));

            System.out.println("\nWaiting for a client ...");

            socket = server.accept();
            System.out.println("\nClient accepted!");

            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while ((line = input.readLine()) != null) {
                if (line.equals("Over")) {
                    break;
                }
                System.out.println(line);
            }

            System.out.println("\nClosing the connection ...");

            socket.close();
            input.close();

        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Server(5000);
    }
}