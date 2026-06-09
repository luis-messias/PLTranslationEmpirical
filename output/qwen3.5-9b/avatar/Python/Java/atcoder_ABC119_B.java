import java.util.Scanner;

public class atcoder_ABC119_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double sum = 0;
        
        for (int i = 0; i < N; i++) {
            String line = scanner.next();
            String processed = line.replace("JPY", "* 1.0").replace("BTC", "* 380000.0");
            
            // Parse the expression and calculate the value
            double value = parseExpression(processed);
            sum += value;
        }
        
        System.out.println(sum);
    }
    
    private static double parseExpression(String expression) {
        String[] parts = expression.split("\\s+");
        double total = 0;
        
        for (String part : parts) {
            if (part.contains("JPY")) {
                String[] numParts = part.split("JPY");
                double num = Double.parseDouble(numParts[0]);
                total += num * 1.0;
            } else if (part.contains("BTC")) {
                String[] numParts = part.split("BTC");
                double num = Double.parseDouble(numParts[0]);
                total += num * 380000.0;
            }
        }
        
        return total;
    }
}