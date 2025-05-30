import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    void run() throws IOException{
        try {
            int port = 8081;
            InetAddress address = InetAddress.getByName("localhost");
            Socket socket = new Socket(address,port);
            PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
            BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toSocket.println("Hello from the client");
            String line = fromSocket.readLine();
            System.out.println("From socket response is: "+ line);
            toSocket.close();
            fromSocket.close();
            socket.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public static void main(String[] args) {
       Client client = new Client();
       try {
        client.run();
       } catch (Exception e) {
        // TODO: handle exception
        e.getStackTrace();
       } 
    }
}
