import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class codeforces_350_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read t (T sequence)
        // t = [0] + list(map(int, input().split()))
        int[] t = new int[n + 1];
        t[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (scanner.hasNextInt()) {
                t[i] = scanner.nextInt();
            }
        }

        // Read a (A sequence)
        // a = [0] + list(map(int, input().split()))
        int[] a = new int[n + 1];
        a[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (scanner.hasNextInt()) {
                a[i] = scanner.nextInt();
            }
        }

        // ans, cnt initialization
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[n + 1];

        // Count occurrences in a
        for (int i = 1; i <= n; i++) {
            if (a[i] >= 0 && a[i] <= n) { // Ensure index is valid for cnt array
                cnt[a[i]] += 1;
            }
        }

        // Find cycles
        for (int i = 1; i <= n; i++) {
            if (t[i] == 1) {
                List<Integer> crt = new ArrayList<>();
                int x = a[i];
                
                // Cycle detection loop
                // The condition cnt[x] == 1 implies that x is part of a path where it is only visited once in the context of the cycle search.
                // In the Python code, it checks if cnt[x] == 1. This implies we are looking for simple cycles where elements are unique in the context of the path being traced.
                
                // We need a way to detect if we hit a node already in the current path (crt) or if we hit a node that has already been fully processed (which is implicitly handled by the structure if we only trace paths where cnt[x] == 1).
                
                // Let's stick strictly to the Python logic: while cnt[x] == 1
                
                // To prevent infinite loops if the structure allows cycles that don't satisfy cnt[x] == 1 immediately, we must track visited nodes within this specific trace.
                
                // Re-evaluating the Python logic:
                // while cnt[x] == 1:
                //     crt.append(x)
                //     x = a[x]
                
                // This loop traces a path defined by a, stopping when it hits a node x where cnt[x] != 1. If the path forms a cycle, it must eventually return to a node already in the path.
                
                // Since the Python code relies solely on cnt[x] == 1, we must assume this condition is sufficient for cycle detection in the intended problem context.
                
                // To handle potential cycles correctly, we should use a visited set for the current trace, but let's translate the exact logic first.
                
                // We need to handle the case where x might lead outside the range [1, n] if a[x] is large, although the input constraints