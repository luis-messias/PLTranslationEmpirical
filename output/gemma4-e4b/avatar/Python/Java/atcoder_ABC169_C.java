import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC169_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the two space-separated values (sa and sb)
        if (!scanner.hasNext()) {
            return;
        }
        
        String sa = scanner.next();
        String sb = scanner.next();
        
        scanner.close();

        // a = int(sa)
        long a = Long.parseLong(sa);

        // b = int(float(sb) * 100 + 0.1)
        // Parse sb as double. Multiply by 100 and round to the nearest long integer.
        double val = Double.parseDouble(sb);
        
        // Math.round handles the conversion and ensures accuracy similar to the Python logic.
        long b = Math.round(val * 100.0);

        // print(a * b // 100)
        // Use long for the final calculation to prevent potential overflow.
        long result = (a * b) / 100;

        System.out.println(result);
    }
}