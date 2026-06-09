import java.util.Scanner;

public class s357377130 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read A, B, K from a single line of input
        if (scanner.hasNextInt()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int K = scanner.nextInt();

            if (A + K - 1 >= B - K + 1) {
                // Case 1: A + K - 1 >= B - K + 1
                // Print numbers from A to B
                int currentA = A;
                while (currentA <= B) {
                    System.out.println(currentA);
                    currentA++;
                }
            } else {
                // Case 2: else block
                
                // First loop: Print A, A+1, ..., A+K-1
                int i = 0;
                while (i <= K - 1) {
                    System.out.println(A + i);
                    i++;
                }

                // Second loop: Print B-K+1 repeatedly while K is decremented
                // Note: The condition B-K+1 <= B is equivalent to K >= 1.
                // Since K is modified inside the loop, we must re-evaluate the condition based on the current K.
                // The Python code structure implies that the loop condition checks the state of K relative to B.
                
                // We need to use the original K value for the initial check, but the loop modifies K.
                // Let's follow the Python structure exactly:
                
                // The Python code uses K in the condition B-K+1 <= B and modifies K inside.
                // Since K is modified, the loop condition B-K+1 <= B changes dynamically.
                
                // Re-implementing the second loop based on the Python structure:
                // The loop condition B-K+1 <= B is equivalent to K >= 1.
                
                // We must use the current value of K for the loop condition check.
                // Since K was used in the first loop, we use the current K value for the second loop.
                
                // The Python code uses K in the condition B-K+1 <= B, and K is modified.
                // Let's assume the intent is to iterate while the calculated value is <= B.
                
                // We need to re-read K if we want to strictly follow the Python flow where K is modified.
                // Since we read A, B, K once, we use the initial K for the logic flow.
                
                // Let's stick to the direct translation of the loop structure:
                
                int K_temp = K; // Use a temporary variable if we need to preserve the original K for context, but the Python code modifies K directly.
                
                // Since we are inside the else block, we use the input K.
                
                // The Python code modifies K directly:
                // while B-K+1<=B:
                //     print(B-K+1)
                //     K-=1
                
                // We must use the variable K from the input scope.
                
                while (B - K + 1 <= B) {
                    System.out.println(B - K + 1);
                    K--;
                }
            }
        }
        scanner.close();
    }
}