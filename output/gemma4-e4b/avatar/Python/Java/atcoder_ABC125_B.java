import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC125_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();
        
        // Consume the rest of the line after N
        scanner.nextLine(); 

        // Read V (space-separated integers)
        String vLine = scanner.nextLine();
        String[] vTokens = vLine.trim().split("\\s+");
        int[] V = new int[N];
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(vTokens[i]);
        }

        // Read C (space-separated integers)
        String cLine = scanner.nextLine();
        String[] cTokens = cLine.trim().split("\\s+");
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(cTokens[i]);
        }
        
        // Calculate the sum (equivalent to the Python logic)
        // The initial list element 0 does not affect the sum.
        long totalSum = 0; 
        
        for (int i = 0; i < N; i++) {
            if (