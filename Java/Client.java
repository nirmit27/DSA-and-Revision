import java.io.*;
import java.net.*;

public class Client {
    private Socket socket = null;
    private BufferedReader input = null;
    private PrintWriter output = null;

    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("\nConnected!");

            input = new BufferedReader(new InputStreamReader(System.in));
            output = new PrintWriter(socket.getOutputStream(), true);

        } catch (UnknownHostException u) {
            System.out.println(u);
            return;
        } catch (IOException i) {
            System.out.println(i);
            return;
        }

        String line = "";

        try {
            while (!(line = input.readLine()).equals("Over")) {
                output.println(line);
            }
        } catch (IOException i) {
            System.out.println(i);
        }

        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Client("127.0.0.1", 5000);
    }
}