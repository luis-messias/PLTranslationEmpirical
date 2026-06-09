import java.util.Scanner;

public class codeforces_387_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] time1 = scanner.nextLine().split(":");
        int h1 = Integer.parseInt(time1[0]);
        int m1 = Integer.parseInt(time1[1]) + h1 * 60;
        
        String[] time2 = scanner.nextLine().split(":");
        int h2 = Integer.parseInt(time2[0]);
        int m2 = Integer.parseInt(time2[1]) + h2 * 60;
        
        int diff = Math.abs(m2 - m1);
        if (m2 < m1) {
            diff += 1440;
        }
        
        System.out.printf("%02d:%02d%n", diff / 60, diff % 60);
    }
}
