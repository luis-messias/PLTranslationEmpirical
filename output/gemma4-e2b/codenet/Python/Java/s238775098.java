import java.util.Scanner;

public class s238775098 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        double res = 0.0;
        
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String x = scanner.next();
            
            if (!scanner.hasNext()) break;
            String u = scanner.next();
            
            if (u.equals("BTC")) { 
                // x is the amount, treat as float for calculation
                res += Double.parseDouble(x) * 380000.0;
            } else {
                // x is an integer
                res += Integer.parseInt(x);
            }
        }
        
        System.out.println(res);
        scanner.close();
    }
}