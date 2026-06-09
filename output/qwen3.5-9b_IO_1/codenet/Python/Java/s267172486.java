import java.util.Scanner;

public class s267172486 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int a = scanner.nextInt();
        
        int ans = h / a;
        int ama = h % a;
        
        if (ama != 0) {
            ans += 1;
        }
        
        System.out.println(ans);
    }
}
