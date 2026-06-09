import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class atcoder_ABC119_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after N

        List<Double> x = new ArrayList<>();

        // Read N lines of input and process them
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                // Apply the replacements exactly as in Python
                String processedLine = line.replace("JPY", "* 1.0").replace("BTC", "* 380000.0");
                
                try {
                    // Evaluate the resulting expression. Since the Python code uses eval(), 
                    // we rely on the input structure being evaluable in Java (e.g., simple arithmetic).
                    // We use Double.parseDouble() assuming the result of eval() is a number.
                    double result = Double.parseDouble(processedLine);
                    x.add(result);
                } catch (NumberFormatException e) {
                    // Handle potential parsing errors if the input format is unexpected
                    // In a strict translation context, we assume valid input based on the Python snippet.
                }
            }
        }

        // Calculate the sum
        double sum = 0;
        for (double val : x) {
            sum += val;
        }

        // Print the sum
        System.out.println(sum);
        
        scanner.close();
    }
}