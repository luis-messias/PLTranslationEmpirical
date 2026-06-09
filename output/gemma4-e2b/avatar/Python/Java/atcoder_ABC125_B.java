import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class atcoder_ABC125_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();

        // Read V values
        List<Integer> V = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                V.add(scanner.nextInt());
            }
        }

        // Read C values
        List<Integer> C = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                C.add(scanner.nextInt());
            }
        }

        // Perform calculation
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            // Check if V[i] - C[i] > 0
            if (V.get(i) - C.get(i) > 0) {
                // The Python code sets X = V[i], Y = C[i], and appends X - Y (which is V[i] - C[i])
                list.add(V.get(i) - C.get(i));
            }
        }

        // Calculate and print the sum
        long sum = 0;
        for (int val : list) {
            sum += val;
        }
        
        System.out.println(sum);
        
        scanner.close();
    }
}