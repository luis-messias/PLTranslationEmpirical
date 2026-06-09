import java.util.Scanner;

public class codeforces_32_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                result.append('0');
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == '.') {
                    result.append('1');
                } else {
                    result.append('2');
                }
                i++;
            }
        }
        System.out.println(result.toString());
    }
}