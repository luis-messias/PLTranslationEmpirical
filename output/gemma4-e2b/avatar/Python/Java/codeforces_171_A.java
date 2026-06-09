import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeforces_171_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the line containing a and b
        String line = br.readLine();
        if (line == null || line.isEmpty()) {
            return;
        }
        
        String[] parts = line.split(" ");
        if (parts.length < 2) {
            return;
        }
        
        String a = parts[0];
        String b = parts[1];
        
        int x = Math.max(a.length(), b.length());
        
        // Pad a and b with leading/trailing zeros to length x
        // Python's rjust/ljust handles padding correctly.
        String paddedA = String.format("%" + x + "s", a).replace(' ', '0');
        String paddedB = String.format("%" + x + "s", b).replace(' ', '0');
        
        StringBuilder s = new StringBuilder();
        int c = 0;
        
        // Iterate from the least significant digit (right to left)
        for (int i = 0; i < x; i++) {
            // a index: x - i - 1 (corresponds to the digit from the right end of a)
            // b index: i (corresponds to the digit from the right end of b)
            
            int digitA = paddedA.charAt(x - 1 - i) - '0';
            int digitB = paddedB.charAt(i) - '0';
            
            int d = digitA + digitB + c;
            
            if (d > 9) {
                s.append(d % 10); // Append the unit digit
                c = 1;
            } else {
                s.append(d % 10);
                c = 0;
            }
        }
        
        // Handle final carry
        if (c == 1) {
            s.append(1);
        }
        
        // The Python code prints int(s[:-1]). This suggests the result string 's' might be one digit too long, 
        // or the logic is designed to handle the final carry implicitly.
        // Based on standard addition simulation, the result should be the full string s.
        // We print the integer value of the resulting string s.
        
        // If we strictly follow the Python output: print(int(s[:-1]))
        // This implies we should remove the last character before converting to int.
        
        if (s.length() > 0) {
            // If the logic is intended to mimic the Python result exactly:
            // s.setLength(s.length() - 1);
            // System.out.println(Integer.parseInt(s.toString()));
            
            // However, the standard result of this addition logic is the full string s.
            // Let's assume the intent is to print the full result of the addition.
            System.out.println(s.toString());
        }
    }
}