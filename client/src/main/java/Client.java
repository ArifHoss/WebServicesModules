import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",80);

            var output = new PrintWriter(socket.getOutputStream());
            output.println("Hello from client(Arif)!\r\n\r\n");

            var inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output.flush();

            while (true) {
                var line = inputFromServer.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }
                System.out.println(line);
            }

            inputFromServer.close();
            socket.close();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
