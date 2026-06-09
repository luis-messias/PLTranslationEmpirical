import java.util.Scanner;

public class s251858505 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            String input1 = scanner.nextLine();

            if (scanner.hasNextLine()) {
                String input2 = scanner.nextLine();

                int sum = 0;
                int len1 = input1.length();
                int len2 = input2.length();
                int minLen = Math.min(len1, len2);

                // Equivalent to sum(map(lambda x, y: x==y, input(), input()))
                // Compares characters at corresponding positions and sums the matches.
                for (int i = 0; i < minLen; i++) {
                    if (input1.charAt(i) == input2.charAt(i)) {
                        sum++;
                    }
                }
                System.out.println(sum);
            }
        }
    }
}
