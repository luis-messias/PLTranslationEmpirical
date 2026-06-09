import java.util.Scanner;

public class atcoder_ABC129_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input string l
        if (!scanner.hasNext()) {
            return;
        }
        String l = scanner.next();
        
        int n = l.length();
        long mod = 1000000007L;
        
        // dp[i][0]: count of sequences of length i ending in state 0
        // dp[i][1]: count of sequences of length i ending in state 1
