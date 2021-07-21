import java.net.*;
import java.util.*;

class ServerRARP {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(1309);
            byte[] sendMessage = new byte[1024];
            byte[] receiveMessage = new byte[1024];
            DatagramPacket datagramReceivedPacket = new 
                DatagramPacket(receiveMessage, receiveMessage.length);
            
            datagramSocket.receive(datagramReceivedPacket);
            String message = new String(datagramReceivedPacket.getData()).trim();
            InetAddress inetAddress = datagramReceivedPacket.getAddress();
            int portNum = datagramReceivedPacket.getPort();

            Map<String, String> macAndIpMap = new HashMap<String, String>();
            macAndIpMap.put("6A:08:AA:C2", "167.167.90.90");
            macAndIpMap.put("8A:BC:E3:FA", "165.165.89.1");
            Boolean flag = true;

            for(Map.Entry<String, String> macIpSet:macAndIpMap.entrySet()) {
                if(message.equals(macIpSet.getKey())) {
                    sendMessage = macIpSet.getValue().getBytes();
                    DatagramPacket datagramSenderPacket = new   
                        DatagramPacket(sendMessage, sendMessage.length, inetAddress, portNum);
                    datagramSocket.send(datagramSenderPacket);
                    flag = false;
                    break;
                }
            }

            if(flag) {
                sendMessage = "Not Found".getBytes();
                DatagramPacket datagramSenderPacket = new
                    DatagramPacket(sendMessage, sendMessage.length, inetAddress, portNum);
                datagramSocket.send(datagramSenderPacket);
            }
            datagramSocket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
