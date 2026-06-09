import java.util.Scanner;

public class s486032847 {
    public static int keta(String s) {
        if (s.length() < 2) {
            return Integer.parseInt(s);
        }
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n += s.charAt(i) - '0';
        }
        return keta(String.valueOf(n));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        
        if (keta(N) % 9 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
