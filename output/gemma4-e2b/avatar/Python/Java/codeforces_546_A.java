import java.util.Scanner;

public class codeforces_546_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input line and split it into k, n, w
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            
            if (parts.length == 3) {
                try {
                    int k = Integer.parseInt(parts[0]);
                    int n = Integer.parseInt(parts[1]);
                    int w = Integer.parseInt(parts[2]);

                    if (1 <= k && w <= 1000) {
                        long total = 0;
                        // Calculate total = sum(i * k) for i from 1 to w
                        for (int i = 1; i <= w; i++) {
                            total += (long)i * k;
                        }

                        if (total > n) {
                            System.out.println(total - n);
                        } else {
                            System.out.println(0);
                        }
                    }
                } catch (NumberFormatException e) {
                    // Handle case where input parts are not valid integers
                }
            }
        }
        scanner.close();
    }
}