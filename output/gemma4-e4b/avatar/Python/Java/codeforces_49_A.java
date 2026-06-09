import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class codeforces_49_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        scanner.close();

        Set<Character> vo = new HashSet<>();
        vo.add('a'); vo.add('e'); vo.add('i'); vo.add('o'); vo.add('u'); vo.add('y');
        vo.add('A'); vo.add('E'); vo.add('I'); vo.add('O'); vo.add('U'); vo.add('Y');

        for (int i = a.length() - 1; i >= 0; i--) {
            char currentChar = a.charAt(i);

            if (currentChar == ' ' || currentChar == '?') {
                continue;
            } else {
                if (vo.contains(currentChar)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                break;
            }
        }
    }
}