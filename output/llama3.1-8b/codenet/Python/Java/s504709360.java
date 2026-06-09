import java.util.Scanner;

public class s504709360 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.length() < 26) {
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                if (!s.contains(String.valueOf(c))) {
                    System.out.println(s + c);
                    return;
                }
            }
        } else {
            boolean swapped = false;
            for (int i = s.length() - 2; i >= 0; i--) {
                if (s.charAt(i) < s.charAt(i + 1)) {
                    String s1 = s.substring(0, i);
                    for (int j = 0; j < 26; j++) {
                        char c = (char) ('a' + j);
                        if (c > s.charAt(i) && !s1.contains(String.valueOf(c))) {
                            System.out.println(s1 + c);
                            return;
                        }
                    }
                } else {
                    swapped = true;
                    break;
                }
            }
            if (!swapped) {
                System.out.println(-1);
            }
        }
    }
}