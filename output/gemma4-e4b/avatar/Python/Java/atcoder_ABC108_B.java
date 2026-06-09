import java.util.Scanner;

public class atcoder_ABC108_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the four space-separated integers
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        
        scanner.close();
        
        // Calculations
        int DIF1 = x2 - x1;
        int DIF2 = y2 - y1;
        
        int x3 = x2 - DIF2;
        int y3 = y2 + DIF1;
        
        int x4 = x1 - DIF2;
        int y4 = y1 + DIF1;
        
        // Output
        System.out.println(x3 + " " + y3 + " " + x4 + " " + y4);
    }
}