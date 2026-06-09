import java.util.*;
import java.io.*;

public class s441329208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String line2 = br.readLine();
        
        if (line1 == null) line1 = "";
        if (line2 == null) line2 = "";
        
        char[] sChars = line1.trim().toCharArray();
        char[] tChars = line2.trim().toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        String s = new String(sChars);
        String t = new StringBuilder(new String(tChars)).reverse().toString();
        
        if (s.compareTo(t) < 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
