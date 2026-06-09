import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class s546174362 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M from the first line
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int M = scanner.nextInt();

        // Read array A from the second line
        if (!scanner.hasNextLine()) return;
        String lineA = scanner.nextLine();
        
        // Parse A elements
        String[] aTokens = lineA.trim().split("\\s+");
        
        if (aTokens.length == 0) {
            return;
        }
        
        int[] A = new int[aTokens.length];
        for (int i = 0; i < aTokens.length; i++) {
            A[i] = Integer.parseInt(aTokens[i]);
        }

        // The Python code sorts A initially, but the loop structure implies sorting happens inside.
        // Let's follow the Python structure exactly: A=sorted(A) happens before the loop.
        Arrays.sort(A);

        // Core Logic Translation
        
        // We use a mutable copy for the operations, although the Python code modifies A directly.
        // Since the sorting happens inside the loop, we must operate on the array that is being modified.
        
        while (M > 0) {
            // A[-1] //= 2
            // A.length - 1 is the index of the last element
            A[A.length - 1] /= 2;
            M--;
            
            int i = -2; // Index relative to the end (A[-2])
            
            // Inner loop: while M and (-N<=i and A[i]>=A[-1]):
            // Note: Java array indexing requires positive indices. We must translate the negative indexing logic carefully.
            // If i = -k, then A[i] corresponds to A[A.length - k].
            
            // Since the Python code uses negative indices relative to the end, we translate them to positive indices:
            // A[-1] is A[L-1]
            // A[-2] is A[L-2]
            // A[i] where i is negative means A[A.length + i]
            
            // Let L = A.length.
            // A[-1] is A[L-1]
            // A[i] where i is negative means A[L+i]
            
            // The condition is: (-N <= i) AND (A[i] >= A[-1])
            
            // We need to ensure i is a valid index for A.
            // Since i starts at -2 and decreases, we check the bounds.
            
            while (M > 0 && i >= -N && A[A.length + i] >= A[A.length - 1]) {
                // A[i] //= 2
                A[A.length + i] /= 2;
                M--;
                i--;
            }
            
            // A.sort()
            Arrays.sort(A);
        }

        // print(sum(A))
        long sum = 0;
        for (int x : A) {
            sum += x;
        }
        System.out.println(sum);
    }
}
