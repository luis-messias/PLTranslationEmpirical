import java.util.Scanner;

public class s357377130 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read A, B, K from standard input
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int K = scanner.nextInt();
        
        scanner.close();

        // if A+K-1>=B-K+1:
        if (A + K - 1 >= B - K + 1) {
            // while A<=B: print(A); A+=1
            while (A <= B) {
                System.out.println(A);
                A++;
            }
        } else {
            // i=0
            int i = 0;
            // while i<=K-1: print(A+i); i+=1
            while (i <= K - 1) {
                System.out.println(A + i);
                i++;
            }
            
            // while B-K+1<=B: print(B-K+1); K-=1
            while (B - K + 1 <= B) {
                System.out.println(B - K + 1);
                K--;
            }
        }
    }
