import java.util.Scanner;

public class codeforces_705_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n (first line)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        // Read the line containing w (second line)
        if (!scanner.hasNextLine()) {
            return;
        }
        String lineW = scanner.nextLine();
        
        // Parse w
        String[] parts = lineW.split("\\s+");
        
        // Initialize c
        int c = 2;

        // Iterate through the elements of w
        for (String part : parts) {
            if (part.isEmpty()) continue;
            int i = Integer.parseInt(part);

            if (i == 1) {
                System.out.println(c);
            } else if (i % 2 == 0) {
                c = 3 - c;
                System.out.println(c);
            } else {
                System.out.println(c);
            }
        }
        
        scanner.close();
    }
}
