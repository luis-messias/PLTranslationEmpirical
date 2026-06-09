import java.util.Scanner;

public class atcoder_ABC042_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextLine()) {
            System.out.println("NO");
            scanner.close();
            return;
        }
        
        String line = scanner.nextLine();
        
        // Split the input line by one or more whitespace characters
        String[] parts = line.trim().split("\\s+");
        
        if (parts.length == 0 || (parts.length == 1 && parts[0].isEmpty())) {
            System.out.println("NO");
            scanner.close();
            return;
        }
        
        int[] ABC = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            try {
                ABC[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                // Assuming valid integer input as per Python context
                return; 
            }
        }
        
        // Calculate count of 5 and sum
        int count5 = 0;
        long sum = 0;
        
        for (int num : ABC) {
            if (num == 5) {
                count5++;
            }
            sum += num;
        }
        
        // Apply the logic: if count is 2, check sum. Otherwise, print NO.
        if (count5 == 2) {
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