import java.util.Scanner;

public class s895229833 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            // Handle empty input case if necessary, though usually N is provided
            System.out.println(0);
            return;
        }
        int N = scanner.nextInt();

        // Read H array
        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                H[i] = scanner.nextInt();
            } else {
                // Handle case where not enough elements are provided
                // We break and proceed with the elements read so far, 
                // but for strict translation, we assume N elements are present.
                break; 
            }
        }
        
        scanner.close();

        if (N <= 1) {
            System.out.println(0);
            return;
        }

        int countBest = 0;
        int countTmp = 0;

        // Loop runs from i = 0 to N-2
        for (int i = 0; i < N - 1; i++) {
            if (H[i] >= H[i+1]) {
                countTmp++;
            } else {
                // Streak broken
                if (countTmp > countBest) {
                    countBest = countTmp;
                }
                countTmp = 0;
            }
        }

        // Check the final streak
        if (countTmp > countBest) {
            countBest = countTmp;
        }

        System.out.println(countBest);
    }
}