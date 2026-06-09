import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class atcoder_ABC178_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // The Python code reads input inside solve(tc).
        // The loop structure in Python runs only once (tc=1, tcs=1).
        String line = br.readLine();
        
        if (line != null) {
            try {
                // a = int ( stdin.readline ( ).strip ( ) )
                int a = Integer.parseInt(line.trim());
                
                // print ( 1 if a == 0 else 0 )
                System.out.println(a == 0 ? 1 : 0);
            } catch (NumberFormatException e) {
                // Handle potential parsing errors if input is malformed
            }
        }
    }
}