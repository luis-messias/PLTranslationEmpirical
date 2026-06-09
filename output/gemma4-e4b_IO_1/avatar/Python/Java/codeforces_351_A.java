import java.util.*;
import java.util.stream.Collectors;

public class codeforces_351_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Consume the rest of the line after reading N
        scanner.nextLine(); 

        // 2. Read the array line
        String arrayLine = scanner.nextLine();
        
        // 3. Parse the array elements
        List<Double> arrList = new ArrayList<>();
        String[] tokens = arrayLine.trim().split("\\s+");
        
        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    arrList.add(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    // Ignore invalid tokens
                }
            }
        }
        
        // 4. Filter and calculate fractional parts
        List<Double> filteredArr = new ArrayList<>();
        for (double x : arrList) {
            // Fractional part: x - floor(x
