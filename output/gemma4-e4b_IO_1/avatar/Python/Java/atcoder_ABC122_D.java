import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC122_D {

    private static int N;
    private static final long MOD = 1_000_000_007L;
    // memo[cur] maps last3 (String) -> count (Long)
    private static Map<String, Long>[] memo;

    /**
     * Checks if the 4-character string 'last4' is "okay".
     * It checks the original string and the strings resulting from swapping (i, i-1) for i=1, 2, 3.
     * Returns false if ANY of the 4 arrangements contain "AGC".
     */
    private static boolean ok(String last4) {
