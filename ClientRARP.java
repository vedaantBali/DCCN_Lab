import java.net.*;
import java.io.*;

class ClientRARP {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            byte[] sendMessage = new byte[1024];
            byte[] receiveMessage = new byte[1024];
            BufferedReader bufferedReader = 
                new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println(" Enter the MAC address: ");
            String macAddress = bufferedReader.readLine();

            sendMessage = macAddress.getBytes();

            DatagramPacket datagramSenderPacket = new 
                DatagramPacket(sendMessage, sendMessage.length, inetAddress, 1309);
            datagramSocket.send(datagramSenderPacket);

            DatagramPacket datagramReceiverPacket = new 
                DatagramPacket(receiveMessage, receiveMessage.length);
            datagramSocket.receive(datagramReceiverPacket);

            String message = new String(datagramReceiverPacket.getData());

            System.out.println(" Logical address: " + message.trim());

            datagramSocket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
