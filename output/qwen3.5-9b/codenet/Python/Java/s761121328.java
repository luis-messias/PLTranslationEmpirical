import java.util.Scanner;

public class s761121328 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        int s = 0;
        for (int i = 0; i < N; i++) {
            s = s ^ A[i];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(s ^ A[i]);
            if (i < N - 1) {
                sb.append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
}