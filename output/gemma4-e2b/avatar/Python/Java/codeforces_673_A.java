import java.util.Scanner;

public class codeforces_673_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (first input)
        if (!scanner.hasNextInt()) {
            return; // Handle case where input might be missing
        }
        int n = scanner.nextInt();

        // Read the array elements (second input line)
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        
        // Parse the array elements
        String[] parts = line.trim().split("\\s+");
        int[] arr = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            try {
                arr[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                // Handle potential parsing errors if input is malformed
                return;
            }
        }

        if (arr.length == 0) {
            return;
        }

        if (arr[0] > 15) {
            System.out.println(15);
        } else {
            boolean found = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] > 15) {
                    System.out.println(arr[i - 1] + 15);
                    found = true;
                    break;
                }
            }

            if (!found) {
                // This corresponds to the else block of the for loop in Python
                int lastIndex = arr.length - 1;
                if (arr[lastIndex] == 90 || arr[lastIndex] + 15 >= 90) {
                    System.out.println(90);
                } else {
                    System.out.println(arr[lastIndex] + 15);
                }
            }
        }
        scanner.close();
    }
}