import java.util.Scanner;

public class s013976107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String S = sc.next();
        
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-') {
                count++;
            }
        }
        
        if (S.charAt(A) == '-' && count == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}