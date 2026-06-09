import java.util.Scanner;

public class s838619850 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read S
        String S = scanner.nextLine();
        
        // Read T
        String T = scanner.nextLine();

        int N = S.length();
        int M = T.length();

        // If M is 0 or N < M, the loop condition handles it, but M must be positive for the initialization ans=M to make sense if M is the target length.
        if (M == 0) {
            System.out.println(0);
            return;
        }
        
        // Initialize ans to M (maximum possible difference)
        int ans = M;

        // Iterate through all possible starting positions i for a substring of length M in S
        for (int i = 0; i <= N - M; i++) {
            // Extract the substring S_2 = S[i:i+M]
            String S_2 = S.substring(i, i + M);
            
            int cnt = 0;
            // Compare S_2 with T character by character
            for (int j = 0; j < M; j++) {
                if (T.charAt(j) != S_2.charAt(j)) {
                    cnt++;
                }
            }
            
            // Update the minimum difference found
            ans = Math.min(ans, cnt);
        }

        System.out.println(ans);
        
        scanner.close();
    }
}