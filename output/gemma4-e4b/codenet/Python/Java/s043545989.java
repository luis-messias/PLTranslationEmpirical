import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class s043545989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N
        String lineN = br.readLine();
        if (lineN == null || lineN.isEmpty()) return;
        int N = Integer.parseInt(lineN.trim());

        // Read array a
        String lineA = br.readLine();
        if (lineA == null || lineA.isEmpty()) return;
        
        String[] parts = lineA.trim().split("\\s+");
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }

        // B = collections.Counter(a)
        Map<Integer, Integer> counts = new HashMap<>();
        for (int x : a) {
            counts.put(x, counts.getOrDefault(x, 0) + 1);
        }

        // k = list(B.keys()), v = list(B.values())
        List<Integer> k = new ArrayList<>(counts.keySet());
        List<Integer> v = new ArrayList<>();
        for (int key : k) {
            v.add(counts.get(key));
        }

        int lenB = counts.size();
        boolean result = false;

        // Case 1: len(B) == 3
        if (lenB == 3) {
            int k0 = k.get(0);
            int k1 = k.get(1);
            int k2 = k.get(2);
            int v0 = v.get(0);
            int v1 = v.get(1);
            int v2 = v.get(2);

            // k[0]^k[1]^k[2] == 0 and v[0] == v[1] == v[2]
            if ((k0 ^ k1 ^ k2) == 0 && v0 == v1 && v1 == v2) {
                result = true;
            }
        } 
        // Case 2: len(B) == 2
        else if (lenB == 2) {
            // Check if 0 is in k
            boolean zeroInK = k.contains(0);
            
            if (zeroInK) {
                int v0 = v.get(0);
                int v1 = v.get(1);
                
                // v[0] == 2*v[1] or v[1] == 2*v[0]
                if (v0 == 2 * v1 || v1 == 2 * v0) {
                    result = true;
                }
            }
        } 
        // Case 3: len(B) == 1
        else if (lenB == 1) {
            // 0 in k
            if (k.get(0) == 0) {
                result = true;
            }
        }

        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}