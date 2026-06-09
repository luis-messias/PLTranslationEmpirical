import java.util.Scanner;

public class codeforces_514_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        String st = "";

        if (ip.length() != 1) {
            if (ip.charAt(0) == '9') {
                st = "9";
                // ip = ip[1:] in Python
                ip = ip.substring(1);
            }
            for (int i = 0; i < ip.length(); i++) {
                char iChar = ip.charAt(i);
                int i = Character.getNumericValue(iChar);
                if (i > 4) {
                    int n = 9 - i;
                    st += n;
                } else {
                    st += iChar;
                }
            }
        } else {
            st = ip;
        }

        // The Python code implicitly assumes st contains only digits if the logic is followed.
        // Since the logic builds st by concatenating digits, we convert it to an integer.
        try {
            System.out.println(Integer.parseInt(st));
        } catch (NumberFormatException e) {
            // Handle case where st might not be a valid integer if the input handling was complex, 
            // but based on the logic, st should be a string of digits.
        }
    }
}