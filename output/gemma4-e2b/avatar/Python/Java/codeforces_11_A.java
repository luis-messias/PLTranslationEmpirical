import java.util.Scanner;
import java.util.Arrays;

public class codeforces_11_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first line: n and d
        if (!scanner.hasNextLine()) {
            return;
        }
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(" ");
        
        if (parts1.length < 2) {
            return;
        }
        // n and d are read but n is not used in the subsequent logic, only d is used.
        // We read them just to consume the input line as per the Python structure.
        // int n = Integer.parseInt(parts1[0]); 
        int d = Integer.parseInt(parts1[1]);

        // Read the second line: the list x
        if (!scanner.hasNextLine()) {
            return;
        }
        String line2 = scanner.nextLine();
        String[] xStr = line2.split(" ");

        if (xStr.length == 0 || (xStr.length == 1 && xStr[0].isEmpty())) {
            System.out.println(0);
            return;
        }

        // Convert string array to integer array x
        int[] x = new int[xStr.length];
        for (int i = 0; i < xStr.length; i++) {
            x[i] = Integer.parseInt(xStr[i]);
        }

        long m = 0; // Use long for m just in case intermediate calculations get large, although the result is printed as an integer in Python context.
        
        // The Python code modifies x in place, so we use the array x directly.
        for (int a = 0; a < x.length - 1; a++) {
            if (x[a] >= x[a + 1]) {
                // q = int( (x[a] - x[a+1]) / d + 1 )
                // Since x[a] and x[a+1] are integers, the division is integer division.
                // Python's behavior for (A - B) / d is floor division.
                // We need to ensure the calculation matches Python's behavior.
                
                // (x[a] - x[a+1]) is the difference.
                // In Python: q = int((x[a] - x[a+1]) / d + 1)
                
                // Java integer division:
                long diff = (long)x[a] - x[a + 1];
                long q = (diff / d) + 1;
                
                m = m + q;
                
                // x[a + 1] = x[a + 1] + q * d
                x[a + 1] = x[a + 1] + (int)(q * d);
            }
        }

        System.out.println(m);
        
        scanner.close();
    }
}