import java.net.*;
import java.io.*;

class SlideReceiver {
    public static void main(String a[]) throws Exception {
        Socket s=new Socket("127.0.0.0",10);
        DataInputStream in=new DataInputStream(s.getInputStream());
        PrintStream p=new PrintStream(s.getOutputStream());
        int i=0,rptr=-1,nf,rws=8;
        String rbuf[]=new String[8];
        String ch; System.out.println();
        do {
            nf=Integer.parseInt(in.readUTF());
            if(nf<=rws-1) {
                for(i=1;i<=nf;i++) {
                    rptr=++rptr%8;
                    rbuf[rptr]=in.readUTF();
                    System.out.println("The received Frame " +rptr+" is : "+rbuf[rptr]);
                }
                rws-=nf;
                System.out.println("\nAcknowledgment sent\n");
                p.println(rptr+1); rws+=nf; 
            } else break;
            ch=in.readUTF();
        } while(ch.equals("yes"));
    }
}
