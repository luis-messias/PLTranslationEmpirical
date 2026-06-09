import java.util.Scanner;

public class s251858505 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the two input strings
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        
        scanner.close();

        int count = 0;
        // Determine the length to iterate over (the minimum length)
        int length = Math.min(s1.length(), s2.length());

        // Compare characters at each index
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }

        System.out.println(count);
    }
}