import java.util.*;
import java.io.*;

public class atcoder_ABC169_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] parts = br.readLine().split(" ");
        int a = Integer.parseInt(parts[0]);
        double bDouble = Double.parseDouble(parts[1]) * 100 + 0.1;
        int b = (int) Math.floor(bDouble);
        
        System.out.println(a * b / 100);
    }
}
