import java.io.*;
import java.net.*;


public class Client4 {
    public static void main(String args[]) throws Exception{
        try {
            InetAddress inetAddress = InetAddress.getByName("localhost");
            Socket socket = new Socket(inetAddress, 5056);
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
        } catch (Exception e) {

        }
    }
}
