import java.util.Scanner;

public class s642705424 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        int N = scanner.nextInt();
        
        // Read S
        String S = scanner.next();
        
        int x = 1;
        
        // The loop iterates N-1 times, checking adjacent characters
        for (int i = 0; i < N - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                x = x + 1;
            }
        }
        
        System.out.println(x);
    }
}