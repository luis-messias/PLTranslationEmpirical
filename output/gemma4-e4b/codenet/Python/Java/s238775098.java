import java.util.Scanner;

public class s238775098 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int n = scanner.nextInt();
        double res = 0.0;
        
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) {
                break;
            }
            
            String x = scanner.next();
            String u = scanner.next();
            
            if (u.equals("BTC")) {
                double x_float = Double.parseDouble(x);
                res += x_float * 380000.0;
            } else {
                // Since the result is double, we parse x as double
                double x_int = Double.parseDouble(x);
                res += x_int;
            }
        }
        
        System.out.println(res);
        scanner.close();
    }
}