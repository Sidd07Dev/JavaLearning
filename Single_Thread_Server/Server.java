import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    void run() throws IOException{
        try{ 
        int port = 8081;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        while(true){
            System.out.println("Server is listen at port"+port);
            Socket acceptConnection = socket.accept();
            System.out.println("Connection is accepted from client "+acceptConnection.getRemoteSocketAddress());
            PrintWriter toClient = new PrintWriter(acceptConnection.getOutputStream());
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptConnection.getInputStream()));
            toClient.println("Hello from the server");
            toClient.close();
            fromClient.close();
            acceptConnection.close();
        }
    }catch(Exception ex){ 
        ex.getStackTrace();
    }

    }
    public static void main(String[] args) {
        Server server = new Server();
        try{
            server.run();
        }catch(Exception ex){
            ex.getStackTrace();
        }
    }
}
