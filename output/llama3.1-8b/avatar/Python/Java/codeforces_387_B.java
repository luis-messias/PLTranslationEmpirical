import java.util.Scanner;

public class codeforces_387_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] roundComplexityInput = scanner.nextLine().split(" ");
        int[] roundComplexity = new int[n];
        for (int i = 0; i < n; i++) {
            roundComplexity[i] = Integer.parseInt(roundComplexityInput[i]);
        }

        String[] georgeComplexityInput = scanner.nextLine().split(" ");
        int[] georgeComplexity = new int[m];
        for (int i = 0; i < m; i++) {
            georgeComplexity[i] = Integer.parseInt(georgeComplexityInput[i]);
        }

        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (roundComplexity[i] <= georgeComplexity[j]) {
                i++;
            }
            j++;
        }
        System.out.println(n - i);
    }
}