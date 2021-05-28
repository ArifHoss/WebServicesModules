import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(80)) {

            while (true) {
                Socket client = serverSocket.accept();
                System.out.println(client.getInetAddress());
                var inputFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

                inputFromClient.lines().forEach(System.out::println);
                inputFromClient.close();
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
