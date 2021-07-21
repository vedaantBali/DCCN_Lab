import java.net.*;
import java.io.*;

public class Server1 {
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(2001);
            System.out.println("Server Active, Waiting for Client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client is here");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage = "";
            String serverMessage = "";
            while(!clientMessage.equals("end!")) {
                clientMessage = dataInputStream.readUTF();
                System.out.println("Client\'s Message: " + clientMessage);
                serverMessage = bufferedReader.readLine();
                dataOutputStream.writeUTF(serverMessage);
                dataOutputStream.flush();
            }
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
            serverSocket.close();
        } catch(Exception exception) {
            System.out.println(exception);
        }
    }
}
