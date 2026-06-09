import java.util.Scanner;

public class s504709360 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        
        if (s.length() < 26) {
            for (int i = 0; i < 26; i++) {
                char c = (char)('a' + i);
                if (s.indexOf(c) == -1) {
                    System.out.println(s + c);
                    return;
                }
            }
        } else {
            for (int i = 25; i >= 1; i--) {
                if (s.charAt(i - 1) < s.charAt(i)) {
                    String s1 = s.substring(0, i - 1);
                    for (int j = 0; j < 26; j++) {
                        char c = (char)('a' + j);
                        if (c > s.charAt(i - 1) && s1.indexOf(c) == -1) {
                            System.out.println(s1 + c);
                            return;
                        }
                    }
                }
            }
            System.out.println(-1);
        }
    }
}
