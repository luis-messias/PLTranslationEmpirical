import java.util.Scanner;

public class atcoder_AGC025_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String[] a = {"10", "100", "1000", "10000", "100000"};
        int new = 0;
        for (char c : n.toCharArray()) {
            new += c - '0';
        }
        if (a.contains(n)) {
            System.out.println(10);
        } else {
            System.out.println(new);
        }
    }
}
