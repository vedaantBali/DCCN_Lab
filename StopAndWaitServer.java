import java.io.*;
import java.net.*;

public class StopAndWaitServer {
    public static void main(String args[]) {
        int i;
        try
        {
            ServerSocket ss2;
            ss2 = new ServerSocket(8000);
            Socket s1 = ss2.accept();
            DataInputStream dd1 = new DataInputStream(s1.getInputStream());
            Integer i1 = dd1.read();
            ss2.close();
            for (i = 0; i < i1; i++)
            {
                ServerSocket ss1;
                ss1 = new ServerSocket(9000 + i);
                Socket s = ss1.accept();
                DataInputStream dd = new DataInputStream(s.getInputStream());
                String sss1 = dd.readUTF();
                System.out.println(sss1);
                System.out.println("Frame " + i + " received");
                DataOutputStream d1 = new DataOutputStream(s.getOutputStream());
                d1.write(i);
                System.out.println("ACK sent for " + i);
                ss1.close();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error" + ex);
        }
    }
}