import java.net.*;
import java.io.*;

public class Server {
    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(2001);
        Socket socket = serverSocket.accept();
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("Server Active. Connection Established");
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String message = bufferedReader.readLine();
        System.out.println(message);
        socket.close();
        serverSocket.close();
    }
}


