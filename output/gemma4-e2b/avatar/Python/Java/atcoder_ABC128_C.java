import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class atcoder_ABC128_C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read N and M
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        // 2. Read li (M lists)
        List<List<Integer>> li = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            List<Integer> currentList = new ArrayList<>();
            for (String s : line) {
                currentList.add(Integer.parseInt(s));
            }
            li.add(currentList);
        }

        // 3. Read p (tuple/list)
        String[] lineP = br.readLine().split(" ");
        List<Integer> p = new ArrayList<>();
        for (String s : lineP) {
            p.add(Integer.parseInt(s));
        }

        // 4. Calculate q (Union of all elements in li)
        Set<Integer> q = new HashSet<>();
        for (List<Integer> list : li) {
            q.addAll(list);
        }

        // 5. Calculate r
        Set<Integer> r = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            r.add(i);
        }

        // 6. Calculate v = r - q
        Set<Integer> v = new HashSet<>(r);
        v.removeAll(q);

        long ans = 0;
        
        // Convert q to an array/list for easier combination generation
        List<Integer> qList = new ArrayList<>(q);
        int qSize = qList.size();

        // Iterate over combinations of q (subsets of q)
        // We iterate from i = 0 to len(q)
        for (int i = 0; i <= qSize; i++) {
            // Generate combinations of size i from q
            List<List<Integer>> combinations = generateCombinations(qList, i);

            for (List<Integer> s : combinations) {
                // Check the condition for this combination s
                boolean conditionMet = true;

                // Iterate over li and p simultaneously (zip equivalent)
                for (int j = 0; j < m; j++) {
                    List<Integer> u = li.get(j);
                    int w = p.get(j);
                    
                    // s is already a set (from the combination list)
                    Set<Integer> sSet = new HashSet<>(s);
                    Set<Integer> uSet = new HashSet<>(u);
                    
                    // Calculate intersection size: len(s & u)
                    int intersectionSize = 0;
                    for (int element : sSet) {