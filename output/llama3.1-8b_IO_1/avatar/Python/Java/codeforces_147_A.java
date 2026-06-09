import java.util.Scanner;
import java.util.ArrayList;

public class codeforces_147_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayList<String> res = new ArrayList<>();
        char[] punctuation = { ',', '.', '!', '?' };

        for (int i = 0; i < s.length(); i++) {
            if (i >= 1) {
                if (s.charAt(i) == ' ') {
                    if (!res.isEmpty() && !res.get(res.size() - 1).isEmpty()) {
                        res.add(" ");
                    } else {
                        continue;
                    }
                } else {
                    if (isPunctuation(s.charAt(i))) {
                        if (res.isEmpty() || res.get(res.size() - 1).isEmpty()) {
                            if (!res.isEmpty()) {
                                res.remove(res.size() - 1);
                            }
                        }
                        res.add(String.valueOf(s.charAt(i)));
                        res.add(" ");
                    } else {
                        res.add(String.valueOf(s.charAt(i)));
                    }
                }
            } else {
                if (s.charAt(i) == ' ') {
                    continue;
                }
                if (isPunctuation(s.charAt(i))) {
                    continue;
                } else {
                    res.add(String.valueOf(s.charAt(i)));
                }
            }
        }

        System.out.println(String.join("", res));
    }

    public static boolean isPunctuation(char c) {
        for (char p : new char[] { ',', '.', '!', '?' }) {
            if (p == c) return true;
        }
        return false;
    }
}
