import java.util.Scanner;

public class codeforces_445_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m from the first line
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        StringBuilder result = new StringBuilder();

        // Loop n times to read n subsequent lines
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String s = scanner.nextLine();
            
            // Convert string to char array for modification
            char[] sArray = s.toCharArray();

            // Loop m times for each character in the row
            for (int j = 0; j < m; j++) {
                if (sArray[j] == '.') {
                    // Check if (i + j) is odd: (i + j) & 1 == 1
                    if ((i + j) & 1 == 1) {
                        sArray[j] = 'W';
                    } else {
                        sArray[j] = 'B';
                    }
                }
            }
            
            // Append the resulting string to the output
            result.append(new String(sArray)).append("\n");
        }

        System.out.print(result.toString());
        
        scanner.close();
    }
}