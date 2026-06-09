import java.util.Scanner;

public class atcoder_ABC124_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input line and split it into two integers a and b
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        if (parts.length < 2) {
            // Handle case where input is insufficient, though typically competitive programming assumes valid input
            return;
        }
        
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        
        int c = 0;
        
        // The loop runs for range(2), meaning i=0 and i=1 (2 iterations)
        for (int i = 0; i < 2; i++) {
            // c += max(a, b)
            int maxVal = Math.max(a, b);
            c += maxVal;
            
            // if a >= b: a -= 1 else: b -= 1
            if (a >= b) {
                a -= 1;
            } else {
                b -= 1;
            }
        }
        
        System.out.println(c);
        
        scanner.close();
    }
}