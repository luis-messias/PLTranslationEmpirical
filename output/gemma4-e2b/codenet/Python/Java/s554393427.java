import java.util.Scanner;

public class s554393427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int N = scanner.nextInt();
        double okz = 0;
        
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNext()) break;
            String xStr = scanner.next();
            
            if (!scanner.hasNext()) break;
            String u = scanner.next();
            
            double x = Double.parseDouble(xStr);
            
            if (u.equals("JPY")) {
                okz += x;
            } else {
                okz += x * 380000.0;
            }
        }
        
        System.out.println(okz);
        scanner.close();
    }
}