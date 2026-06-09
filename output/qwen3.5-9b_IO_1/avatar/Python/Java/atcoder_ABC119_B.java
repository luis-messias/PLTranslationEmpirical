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
        // Find the numeric value before JPY or BTC
        double total = 0;
        
        // Check for JPY
        int jpyIndex = expression.indexOf("JPY");
        if (jpyIndex != -1) {
            String numPart = expression.substring(0, jpyIndex);
            total += Double.parseDouble(numPart) * 1.0;
        }
        
        // Check for BTC
        int btcIndex = expression.indexOf("BTC");
        if (btcIndex != -1) {
            String numPart = expression.substring(0, btcIndex);
            total += Double.parseDouble(numPart) * 380000.0;
        }
        
        return total;
    }
}
