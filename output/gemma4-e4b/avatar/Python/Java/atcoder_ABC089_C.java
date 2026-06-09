import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC089_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            // Handle case where N might not be provided
            return;
        }
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after N

        // Read S (N strings)
        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = scanner.nextLine();
        }
        
        scanner.close();

        // Define march
        String[] march = {"M", "A", "R", "C", "H"};
        
        // Initialize march_lis (counts)
        // We use long just in case the product exceeds Integer.MAX_VALUE, although int might suffice for counts.
        long[] march_lis = new long[5]; 

        // Count occurrences
        for (String s : S) {
            if (s.isEmpty()) continue;
            char firstChar = Character.toUpperCase(s.charAt(0));
            
            for (int i = 0; i < 5; i++) {
                if (march[i].charAt(0) == firstChar) {
                    march_lis[i]++;
                    break;
                }
            }
        }

        // Calculate ans: sum of products of all unique triplets of counts
        long ans = 0;
        
        // Equivalent to combinations(march_lis, 3)
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    // Calculate L_i * L_j * L_k
                    ans += march_lis[i] * march_lis[j] * march_lis[k];
                }
            }
        }

        System.out.println(ans);
    }
}