import java.util.Arrays;
import java.util.Scanner;

public class s768331281 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N and L
        String[] nl = scanner.nextLine().split(" ");
        int N = Integer.parseInt(nl[0]);
        // int L = Integer.parseInt(nl[1]); // L is not used in the logic
        
        // Read N strings
        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = scanner.nextLine();
        }
        
        // Sort the array of strings
        Arrays.sort(S);
        
        // Join and print the sorted strings
        StringBuilder result = new StringBuilder();
        for (String s : S) {
            result.append(s);
        }
        System.out.println(result.toString());
        
        scanner.close();
    }
}