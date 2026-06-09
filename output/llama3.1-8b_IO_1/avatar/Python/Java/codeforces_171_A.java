import java.util.Scanner;

public class codeforces_171_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        int x = Math.max(a.length(), b.length());
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        for (int i = 0; i < x - a.length(); i++) {
            ca[i] = '0';
        }
        for (int i = 0; i < x - b.length(); i++) {
            cb[x - i - 1] = '0';
        }

        StringBuilder s = new StringBuilder();
        int c = 0;
        for (int i = 0; i < x; i++) {
            int d = Character.getNumericValue(cb[i]) + Character.getNumericValue(ca[x - i - 1]) + c;
            if (d > 9) {
                s.append(d % 10);
                c = 1;
            } else {
                s.append(d);
                c = 0;
            }
        }
        if (c == 1) {
            s.append(1);
        }
        System.out.println(Integer.parseInt(s.reverse().toString()));
    }
}
