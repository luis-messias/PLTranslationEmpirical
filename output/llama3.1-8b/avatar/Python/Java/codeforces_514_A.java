import java.util.Scanner;

public class codeforces_514_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();

        if (input.length() != 1) {
            if (input.charAt(0) == '9') {
                result.append('9');
                input = input.substring(1);
            }
            for (char c : input.toCharArray()) {
                int digit = Character.getNumericValue(c);
                if (digit > 4) {
                    result.append(9 - digit);
                } else {
                    result.append(c);
                }
            }
        } else {
            result.append(input);
        }

        System.out.println(Integer.parseInt(result.toString()));
    }
}