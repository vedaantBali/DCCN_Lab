import java.net.InetAddress;

public class allIPFromHost {
    public static void main(String args[]) throws Exception {
        InetAddress[] inetAddresses = InetAddress.getAllByName("www.youtube.com");
        for (InetAddress ip : inetAddresses)
            System.out.println(ip.toString());
    }
}

