import java.util.Scanner;

public class codeforces_387_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] h1m1 = scanner.nextLine().split(":");
        int h1 = Integer.parseInt(h1m1[0]);
        int m1 = Integer.parseInt(h1m1[1]);
        
        String[] h2m2 = scanner.nextLine().split(":");
        int h2 = Integer.parseInt(h2m2[0]);
        int m2 = Integer.parseInt(h2m2[1]);
        
        m1 += h1 * 60;
        m2 += h2 * 60;
        
        m2 = m1 - m2;
        m2 %= 1440;
        
        if (m2 < 0) {
            m2 += 1440;
        }
        
        System.out.printf("%02d:%02d%n", m2 / 60, m2 % 60);
    }
}
