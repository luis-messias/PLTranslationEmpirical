import java.util.Scanner;

public class codeforces_148_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading inputs
        // Assuming inputs are provided in order: princess, dragon, t, f, c
        if (!scanner.hasNextInt()) return;
        int princess = scanner.nextInt();
        
        if (!scanner.hasNextInt()) return;
        int dragon = scanner.nextInt();
        
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        
        if (!scanner.hasNextInt()) return;
        int f = scanner.nextInt();
        
        if (!scanner.hasNextInt()) return;
        int c = scanner.nextInt();

        scanner.close();

        // Initial check
        if (dragon <= princess) {
            System.out.println(0);
            return;
        }

        // Use double for position to maintain precision during division
        double position = (double) t * princess;

        // Initial calculation for position
        // position += princess * position / (dragon - princess)
        position += (double) princess * position / (dragon - princess);

        int result = 0;

        // Loop condition
        while (position < c) {
            result++;
            
            // position += princess * position / dragon
            position += (double) princess * position / dragon;
            
            // position += princess * f
            position += (double) princess * f;
            
            // position += princess * position / (dragon - princess)
            position += (double) princess * position / (dragon - princess);
        }

        System.out.println(result);
    }
}