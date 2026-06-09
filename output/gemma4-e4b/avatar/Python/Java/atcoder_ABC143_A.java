import java.util.Scanner;

public class atcoder_ABC143_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        int A = Integer.parseInt(parts[0]);
        int B = Integer.parseInt(parts[1]);
        
        int ans = A - 2 * B;
        
        if (ans < 0) {
            ans = 0;
        }
        
        System.out.println(ans);
        
        scanner.close();
    }
}