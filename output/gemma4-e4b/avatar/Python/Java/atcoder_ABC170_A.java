import java.util.Scanner;

public class atcoder_ABC170_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextLine()) {
            return;
        }
        
        String line = scanner.nextLine();
        
        // Split the input line by one or more whitespace characters
        String[] tokens = line.trim().split("\\s+");
        
        if (tokens.length == 0 || (tokens.length == 1 && tokens[0].isEmpty())) {
            scanner.close();
            return;
        }

        int[] a = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }
        
        // Iterate through the array (e is the index, i is the value)
        for (int e = 0; e < a.length; e++) {
            int i = a[e];
            if (i == 0) {
                // Print index + 1
                System.out.println(e + 1);
                break;
            }
        }
        
        scanner.close();
    }
}