import java.util.Scanner;

public class codeforces_665_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        int at = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        
        int b = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        int bt = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        
        String[] time1 = scanner.nextLine().split(":");
        int t2 = Integer.parseInt(time1[0]) - 5;
        int st = (t2 + Integer.parseInt(time1[1])) * 60;
        int fin = st + at;
        
        int now = 0;
        int ans = 0;
        
        while (now < fin && now < 1140) {
            if ((now / 60 + bt) > st) {
                ans++;
            }
            now += b;
        }
        
        System.out.println(ans);
    }
}