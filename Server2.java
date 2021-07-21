import java.net.*;
import java.io.*;

public class Server2 {
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(2001);
            System.out.println("Server Active, Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client Accepted");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String clientMessage = "";
            String serverMessage = "";
            while(!clientMessage.equals("end")) {
                clientMessage = dataInputStream.readUTF();
                System.out.println("Client: " + clientMessage);
                serverMessage = clientMessage.toUpperCase();
                dataOutputStream.writeUTF(serverMessage);
                dataOutputStream.flush();
            }
            dataInputStream.close();
            serverSocket.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
