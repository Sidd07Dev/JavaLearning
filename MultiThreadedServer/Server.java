package MultiThreadedServer;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {
    public Consumer<Socket> getConsumer(){
        return (clientSocket)->{
            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from the server"+clientSocket.getPort());
                toClient.close();
                clientSocket.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
        };
    }
public static void main(String[] args) {
    Server server = new Server();
   int port = 8081;
   try {
    ServerSocket serverSocket = new ServerSocket(port);
    serverSocket.setSoTimeout(10000);
    System.out.println("Server is listening on port "+port);
    while (true) {
        Socket accepetedSocket = serverSocket.accept();
        Thread thread = new Thread(()->server.getConsumer().accept(accepetedSocket));
        thread.start();
    }
   } catch (Exception e) {
    e.printStackTrace();
   } 
}
    
}