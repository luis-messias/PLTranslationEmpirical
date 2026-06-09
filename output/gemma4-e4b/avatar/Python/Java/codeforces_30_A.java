import java.util.Scanner;

public class codeforces_30_A {

    /**
     * Finds X such that A * (X^n) = B for X in [-1000, 1000].
     * Returns X if found, otherwise returns "No solution".
     * Note: Returns Object because the return type mixes Integer and String.
     */
    public static Object task4(int A, int B, int n) {
        for (int X = -1000; X <= 1000; X++) {
            // Calculate X^n. Math.pow returns double.
            double powerResult = Math.pow(X, n);
            
            // Calculate A * X^n.
            double product = A * powerResult;
            
            // Check if the product is equal to B. We use a small epsilon for double comparison 
            // since B is an integer.
            if (Math.abs(product - B) < 1e-9) {
                return X;
            }
        }
        return "No solution";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the three space-separated values (A, B, n)
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] inputs = line.split(" ");
            
            if (inputs.length == 3) {
                try {
                    int A = Integer.parseInt(inputs[0]);
                    int B = Integer.parseInt(inputs[1]);
                    int n = Integer.parseInt(inputs[2]);
                    
                    Object result = task4(A, B, n);
                    System.out.println(result);
                } catch (NumberFormatException e) {
                    // Handle case where input parts are not valid integers
                }
            }
        }
        scanner.close();
    }
}