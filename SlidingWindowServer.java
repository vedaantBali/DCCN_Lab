import java.io.*;
import java.net.*;

class SlidingWindowServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            Socket socket = serverSocket.accept();
            System.out.println(" Client connected to port " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            int size = Integer.parseInt(dataInputStream.readUTF());

            while(true) {
                String message = dataInputStream.readUTF();
                if(message.equals("end")) {
                    break;
                }
                System.out.println(" Received frame: " + message);
                if(Integer.valueOf(message)%size == 0) {
                    dataOutputStream.writeUTF("RR");
                }
                System.out.println(" session over...");
                dataInputStream.close();
                dataOutputStream.close();
                serverSocket.close();
                socket.close();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
