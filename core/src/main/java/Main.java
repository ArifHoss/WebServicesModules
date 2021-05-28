import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        //localhost 127.0.0.1
        //178.174.162.51

        try (ServerSocket serverSocket = new ServerSocket(80)) {

            while (true) {
                Socket client = serverSocket.accept();
                System.out.println(client.getInetAddress());

                var inputFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

                while (true) {
                    var line = inputFromClient.readLine();
                    if (line == null || line.isEmpty()) {
                        break;
                    }
                    System.out.println(line);
                }


                var outputToClient = new PrintWriter(client.getOutputStream());
                outputToClient.print("HTTP/1.1 404 Not Found\r\nContent-length: 0\r\n\r\n");

                outputToClient.flush();
                inputFromClient.close();
                outputToClient.close();
                client.close();
            }
//            String input = "";
//            while (input != null) {
//                input = inputFromClient.readLine();
//                System.out.println(input);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
