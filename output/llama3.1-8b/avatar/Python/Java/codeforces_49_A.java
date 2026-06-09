import java.util.Scanner;

public class codeforces_49_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        char[] vo = {'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'};

        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == ' ' || a.charAt(i) == '?') {
                continue;
            } else {
                boolean found = false;
                for (char c : vo) {
                    if (c == a.charAt(i)) {
                        System.out.println("YES");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("NO");
                }
                break;
            }
        }
    }
}