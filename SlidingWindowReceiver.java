import java.io.*;
import java.net.*;
import java.util.Scanner;

class SlidingWindowReceiver {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            Scanner scanner = new Scanner(System.in);
            DataInputStream dataInputStream = new 
                DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new
                DataOutputStream(socket.getOutputStream());
            
            System.out.print(" Enter window size: ");
            int size = scanner.nextInt();

            System.out.print(" Enter number of frames: ");
            int frames = scanner.nextInt();

            dataOutputStream.writeUTF(size + "");

            for(int i=0, j=1; i<frames; i++, j++) {
                System.out.println(" frame " + i + " sent.");
                dataOutputStream.writeUTF(i + "");
                if(j < size || i == frames-1) {
                    continue ;
                }
                if(dataInputStream.readUTF() != null) {
                    System.out.println(" RR frame " + (i+1));
                } else {
                    System.out.println(" Frame lost. Retransmitting...");
                    i--;
                }
                j = 0;
            }
            dataOutputStream.writeUTF("Exit");
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();;
            scanner.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
