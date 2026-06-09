import java.util.Scanner;

public class codeforces_665_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read a and at
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(" ");
        int a = Integer.parseInt(parts1[0]);
        int at = Integer.parseInt(parts1[1]);

        // Read b and bt
        String line2 = scanner.nextLine();
        String[] parts2 = line2.split(" ");
        int b = Integer.parseInt(parts2[0]);
        int bt = Integer.parseInt(parts2[1]);

        // Read t1 and t2 (separated by ':')
        String line3 = scanner.nextLine();
        String[] parts3 = line3.split(":");
        int t1 = Integer.parseInt(parts3[0]);
        int t2 = Integer.parseInt(parts3[1]);

        // Calculations
        int st = t2 + (t1 - 5) * 60;
        int fin = st + at;

        int now = 0;
        int ans = 0;

        // Loop
        while (now < fin && now < 1140) {
            if (now + bt > st) {
                ans += 1;
            }
            now += b;
        }

        System.out.println(ans);
        
        scanner.close();
    }
}