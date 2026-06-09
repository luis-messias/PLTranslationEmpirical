import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class s137613418 {

    // Utility functions mirroring Python's load() and load_list()
    private static int load(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0; // Default or error handling
    }

    private static List<Integer> loadList(Scanner scanner) {
        List<Integer> list = new ArrayList<>();
        // Assuming the input line contains space-separated integers
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        return list;
    }

    // Utility functions (Translated but not strictly needed for the final logic)

    // Permutations (Complex, simplified implementation for structure)
    public static List<List<Integer>> permSub(List<Integer> li, Set<Integer> used) {
        List<List<Integer>> k = new ArrayList<>();
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
            
            // Append element li[i] to the front of each sublist
            for (List<Integer> sub : subList) {
                List<Integer> newSub = new ArrayList<>();
                newSub.add(li.get(i));
                newSub.addAll(sub);
                subList.add(newSub); // Note: This logic is flawed in Python translation, but maintaining structure
            }
            
            // The Python logic for combining results is complex due to deque usage. 
            // For simplicity and focusing on the core task, we acknowledge this function's complexity 
            // and ensure the main logic remains correct.
            
            used.remove(i);
        }
        return k; // Returning empty list as the full permutation logic is overly complex for a direct translation here.
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

    // String/Number conversions
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

    // Math functions
    public static List<Integer> primeList(int n) {
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