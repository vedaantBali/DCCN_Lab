import java.net.InetAddress;

public class ipFromHostName {
    public static void main(String args[]) throws Exception{
        InetAddress inetAddress = InetAddress.getByName("www.bitmesra.ac.in");
        System.out.println("Host Name: " + inetAddress.getHostName());
        System.out.println("IP Address: " + inetAddress.getHostAddress());
    }
}


