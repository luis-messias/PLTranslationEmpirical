import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC169_E {

    public static void resolve() {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int n = scanner.nextInt();
        
        int[] low = new int[n];
        int[] high = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                // Handle unexpected end of input if necessary
                return;
            }
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            low[i] = a;
            high[i] = b;
        }
        
        scanner.close();
        
        Arrays.sort(low);
        Arrays.sort(high);
        
        if (n % 2 != 0) {
            // Odd n case
            // Index: (n + 1) / 2 - 1
            int index = (n + 1) / 2 - 1;
            long result = (long)high[index] - low[index] + 1;
            System.out.println(result);
        } else {
            // Even n case
            // Indices: n/2 - 1 and n/2
            
            int k1 = n / 2 - 1;
            int k2 = n / 2;
            
            // Calculate averages using double precision
            double hh = (high[k1] + high[k2]) / 2.0;
            double ll = (low[k1] + low[k2]) / 2.0;
            
            // Calculate result: int((hh - ll) * 2) + 1
            // We use Math.round to handle potential floating point inaccuracies 
            // before casting to int, although simple casting might suffice given the problem context.
            // Since the Python code uses int() which truncates, we stick to casting.
            int result = (int)((hh - ll) * 2) + 1;
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        resolve();
    }
}