import java.io.*;
import java.net.*;

class ServerARP {
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            Socket socket = serverSocket.accept();

            while(true) {
                DataInputStream dataInputStream = 
                    new DataInputStream(socket.getInputStream());
            
                DataOutputStream dataOutputStream =
                    new DataOutputStream(socket.getOutputStream());
                
                String str = dataInputStream.readUTF();
                String ipAddresses[] = {
                    "165.165.80.80",
                    "165.165.79.1"
                };
                String macAddresses[] = {
                    "6A:08:AA:C2",
                    "8A:BC:E3:FA"
                };
                
                for(int i=0; i < ipAddresses.length; i++) {
                    if(str.equals(ipAddresses[i])) {
                        dataOutputStream.writeUTF(macAddresses[i] + '\n');
                        break ;
                    }
                }
                socket.close();
                serverSocket.close();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}