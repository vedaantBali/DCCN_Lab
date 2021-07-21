// program for address resolution protocol using 
// transmission control protocol

import java.io.*;
import java.net.*;

class ClientARP {
    public static void  main(String args[]) {
        try {
            //BufferedReader bufferedReader = 
            //    new BufferedReader(new InputStreamReader(System.in));

            Socket socket = new Socket("127.0.0.1", 3000);
DataInputStream dataInputStream = 
                new DataInputStream(socket.getInputStream());
            
            DataOutputStream dataOutputStream =
                new DataOutputStream(socket.getOutputStream());
            
            
            System.out.println(" Enter the logical address: ");
            String logicalAddress = dataInputStream.readUTF();

            dataOutputStream.writeUTF(logicalAddress + '\n');
            String physicalAddress = dataInputStream.readUTF();

            System.out.println(" The physical address is: " + physicalAddress);

            socket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}