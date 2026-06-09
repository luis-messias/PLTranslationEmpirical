import java.util.Scanner;

public class codeforces_59_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int upperCaseCount = 0;
        int lowerCaseCount = 0;

        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            } else {
                upperCaseCount++;
            }
        }

        String output = (upperCaseCount > lowerCaseCount) ? input.toUpperCase() : input.toLowerCase();
        System.out.println(output);
    }
}