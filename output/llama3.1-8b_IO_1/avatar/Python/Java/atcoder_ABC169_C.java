import java.util.*;
import java.io.*;

public class atcoder_ABC169_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int P = (int) 1e9 + 7;
        long INF = (long) 1e9 + 10;
        
        String sa = br.readLine();
        String sb = br.readLine();
        int a = Integer.parseInt(sa);
        double b = Double.parseDouble(sb);
        out.println((int)(a * b / 100));
        
        out.close();
    }
}
