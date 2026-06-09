import java.util.Scanner;

public class atcoder_ABC106_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Equivalent to s = S()
        String s = scanner.nextLine();

        // Equivalent to k = I()
        int k = scanner.nextInt();

        // Calculate l
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '1') {
                break;
            }
            l++;
        }

        // Determine the return value and print it
        if (l >= k) {
            // Python returns 1 (integer)
            System.out.println(1);
        } else {
            // Python returns s[l] (character)
            // We print the character at index l.
            System.out.println(s.charAt(l));
        }

        scanner.close();
    }
}