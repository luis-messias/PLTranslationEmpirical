import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC042_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the line of input
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        
        // Parse the input into an array of integers (equivalent to tuple(map(int, input().split())))
        String[] parts = line.trim().split("\\s+");
        
        if (parts.length == 0) {
            System.out.println("NO");
            return;
        }
        
        int[] abc = new int[parts.length];
        try {
            for (int i = 0; i < parts.length; i++) {
                abc[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException e) {
            // Handle case where input is not purely integers, though assumed valid based on Python context
            System.out.println("NO");
            return;
        }

        // Check conditions
        int countOfFive = 0;
        long sum = 0;
        
        for (int x : abc) {
            sum += x;
            if (x == 5) {
                countOfFive++;
            }
        }

        if (countOfFive == 2) {
            if (sum == 17) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
}