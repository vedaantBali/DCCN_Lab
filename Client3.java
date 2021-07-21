import java.net.*;
import java.io.*;

public class Client3 {
    public static void main(String args[]) {
        try {
            Socket socket = new Socket("127.0.0.1", 2001);
            System.out.println("Connection Established");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage = "";
            String serverMessage = "";
            while(!clientMessage.equals("end")) {
                clientMessage = bufferedReader.readLine();
                dataOutputStream.writeUTF(clientMessage);
                dataOutputStream.flush();
                serverMessage = dataInputStream.readUTF();
                System.out.println("Server\'s message: " + serverMessage);
            }
            dataOutputStream.close();
            socket.close();
        } catch(Exception exception) {
            System.out.println(exception);
        }
    }
}
