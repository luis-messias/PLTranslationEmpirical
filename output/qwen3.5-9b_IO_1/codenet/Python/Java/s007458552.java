import java.util.Scanner;

public class s007458552 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String S = sc.next();
        
        int rCount = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'R') {
                rCount++;
            }
        }
        
        if (rCount > n - rCount) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        sc.close();
    }
}
