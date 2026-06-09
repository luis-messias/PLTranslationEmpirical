import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class atcoder_ABC128_C {

    // Global variables to store input data
    static int N, M;
    static List<List<Integer>> li = new ArrayList<>();
    static List<Integer> p = new ArrayList<>();
    static Set<Integer> q = new HashSet<>();
    static Set<Integer> v = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read N and M
        if (!scanner.hasNextInt()) {
            // Handle case where input might be empty
            System.out.println(0);
            return;
        }
        N = scanner.nextInt();
        M = scanner.nextInt();
        
        // Consume the rest of the line after N and M
        scanner.nextLine(); 

        // 2. Read li (M lists, discarding the first element)
        for (int i = 0; i < M; i++) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                // Handle empty lines if M is large
                li.add(new ArrayList<>());
                continue;
            }
            String[] parts = line.trim().split("\\s+");
            List<Integer> currentList = new ArrayList<>();
            for (int j = 0; j < parts.length; j++) {
                try {
                    int val = Integer.parseInt(parts[j]);
                    // Python logic: discard the first element (index 0)
                    if (j > 0) {
                        currentList.add(val);
                    }
                } catch (NumberFormatException e) {
                    // Skip non-integer parts
                }
            }
            li.add(currentList);
        }

        // 3. Read p (M integers)
        String pLine = scanner.nextLine();
        if (!pLine.trim().isEmpty()) {
            String[] pParts = pLine.trim().split("\\s+");
            for (String part : pParts) {
                try {
                    p.add(Integer
