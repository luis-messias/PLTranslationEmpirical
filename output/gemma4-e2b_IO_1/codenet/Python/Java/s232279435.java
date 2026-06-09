import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class s232279435 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        // Read s
        if (!scanner.hasNext()) return;
        String s = scanner.next();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            // x = set(s[:i+1])
            String prefix = s.substring(0, i + 1);
            Set<Character> x = new HashSet<>();
            for (char c : prefix.toCharArray
