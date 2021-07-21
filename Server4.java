import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class Server4 {
    public static void main(String args[]) throws Exception{
        ServerSocket serverSocket = new ServerSocket(5056);
        while(true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("New client has connected : " + socket);
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("Assigning new thread for this client...");
                Thread thread = new ClientHandler(socket, dataInputStream, dataOutputStream);
                thread.start();
            } catch(Exception exception) {
                socket.close();
                serverSocket.close();
                exception.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {
    DateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream dataInputStream;
    final DataOutputStream dataOutputStream;
    final Socket socket;

    public ClientHandler(Socket socket, DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.socket = socket;
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void run() {
        String receivedMessage;
        String toReturn;
        while(true) {
            try{
                dataOutputStream.writeUTF("What do you want? Date|Time\n");
                receivedMessage = dataInputStream.readUTF();
                if(receivedMessage.equals("end")) {
                    System.out.println("Client " + this.socket + " closed the connection.");
                    this.socket.close();
                    break;
                }
                Date date = new Date();
                switch(receivedMessage) {
                    case "Date": toReturn = formatDate.format(date);
                    dataOutputStream.writeUTF(toReturn);
                    break;
                    case "Time": toReturn = formatTime.format(date);
                    dataOutputStream.writeUTF(toReturn);
                    break;
                    default:
                    dataOutputStream.writeUTF("Invalid Input.\n");
                    break;
                }
            } catch(Exception exception) {
                exception.printStackTrace();
            }
        }
        try {
            this.dataInputStream.close();
            this.dataOutputStream.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}