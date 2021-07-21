import java.util.*;
// cyclic redundancy check
class CRC {
    static String xr(String a, String b) {
        String result = "";
        for(int i=0; i<b.length(); i++) {
            if(a.charAt(i) == b.charAt(i)) {
                result += '0';
            } else {
                result += '1';
            }
        }
        return result;
    }

    static String xrDiv(int n, String dividend, int m, String divisor) {
        int p = m;
        String temp = dividend.substring(0, p);
        while(p < n) {
            if(temp.charAt(0) == '1') {
                temp = xr(divisor, temp) + dividend.charAt(p);
            } else {
                temp = xr("0".repeat(p), temp) + dividend.charAt(p);
            }
            p++;
            temp = temp.substring(1);
        }
        if(temp.charAt(0) == '1') {
            temp = xr(divisor, temp);
        } else {
            temp = xr("0".repeat(p), temp);
        }
        return temp.substring(1);
    }

    static String encode(int n, String data, int m, String div) {
        String augmentedData = data + "0".repeat(m-1);
        String rem = xrDiv(n + m - 1, augmentedData, m, div);
        return data + rem;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print(" Enter size of data: ");
        int n = scanner.nextInt();
        
        System.out.print(" Enter data: ");
        String data = scanner.next();

        System.out.print(" Enter size of key: ");
        int m = scanner.nextInt();
        
        System.out.print(" Enter key: ");
        String div = scanner.next();

        String encodedData = encode(n, data, m, div);

        System.out.println(" Encoded data: " + encodedData);

        System.out.print(" Enter size of data to be sent: ");
        int l = scanner.nextInt();

        System.out.print(" Enter data to be sent: ");
        String dataToSend = scanner.next();

        String rem = xrDiv(l, dataToSend, m, div);

        if(rem.equals("0".repeat(m-1))) {
            System.out.println(" Data was received correctly.");
        } else {
            System.out.println(" Error detected in data.");
        }
        scanner.close();
    }
}