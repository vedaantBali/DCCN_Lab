import java.net.*;
import java.io.*;

public class Client{
    public static void main(String args[]) {
        try{
            Socket socket = new Socket("127.0.0.1", 2001);
            InputStreamReader 
                inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String message = bufferedReader.readLine();
            System.out.println(message);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Client Active. Connection Established");
            socket.close();
        } catch(Exception exception) {
            System.out.println(exception);
        }
    }
}



