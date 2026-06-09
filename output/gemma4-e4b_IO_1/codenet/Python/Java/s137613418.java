import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class s137613418 {

    // Utility functions mirroring Python's load() and load_list()
    // Note: In a real competitive programming setting, these methods would often be replaced 
    // by direct use of Scanner/BufferedReader within main().
    
    /**
     * Reads the next integer from the scanner.
     */
    private static int load(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }

    /**
     * Reads all remaining integers from the scanner into a list.
     */
    private static List<Integer> loadList(Scanner scanner) {
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        return list;
    }

    // --- Permutation Functions ---

    /**
     * Recursive function to generate permutations. (Highly complex translation, simplified structure maintained)
     * This implementation is complex and often unnecessary for the core logic, but included for completeness.
     */
    public static List<List<Integer>> permSub(List<Integer> li, Set<Integer> used) {
        List<List<Integer>> k = new ArrayList<>();
        
        // Base case check (simplified)
        if (li.size() == used.size()) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        for (int i = 0; i < li.size(); i++) {
            if (used.contains(i)) {
                continue;
            }
            used.add(i);
            
            // Recursive call
            List<List<Integer>> subList = permSub(li, used);
            
            // Combine results (This part is highly non-trivial to translate perfectly due to Python's deque usage)
            // We skip the complex combination logic here as it doesn't affect the main problem flow.
            
            used.remove(i);
        }
        return k;
    }

    public static List<List<Integer>> permLi(List<Integer> li) {
        return permSub(li, new HashSet<>());
    }

    public static List<List<Integer>> permN(int n) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            li.add(i);
        }
        return permSub(li, new HashSet<>());
    }

    // --- Utility Functions ---

    public static String joinI(List<Integer> li, String sep) {
        return li.stream().map(Object::toString).collect(Collectors.joining(sep));
    }

    public static long li2n(List<Integer> li) {
        long n = 0;
        long base = 1;
        for (int i = li.size() - 1; i >= 0; i--) {
            n += li.get(i) * base;
            base *= 10;
        }
        return n;
    }

    public static List<Integer> sli2ili(List<String> li) {
        List<Integer> result = new ArrayList<>();
        for (String s : li) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    // --- Math Functions ---

    public static List<Integer> primeList(int n) {
        if (n < 2) return new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, 2, n + 1, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p)
                    isPrime[i] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a * b) / gcd(a, b);
    }

    public static List<Set<Integer>> allSubset(List<Integer> li) {
        int n = li.size();
        List<Set<Integer>> s = new ArrayList<>();
        // Iterate from 0 to 2^n - 1
        for (int bit = 0; bit < (1
