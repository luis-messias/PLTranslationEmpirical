import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC167_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int K = scanner.nextInt();

        // Read L
        List<Integer> L = new ArrayList<>();
        // Read the rest of the line for L
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    L.add(Integer.parseInt(part));
                }
            }
        }
        
        // The Python code modifies L: L.insert(0, -1)
        // We need to handle the case where L might be empty or input reading was tricky.
        if (L.isEmpty()) return;
        L.add(0, -1);

        // Initialization based on Python variables
        List<Integer> path = new ArrayList<>();
        // path starts with [1]
        path.add(1);
        
        int ind = 0;
        int x = 1;
        int t = -1;
        boolean flag = false;
        
        // Hash maps visited numbers to their index in path
        Map<Integer, Integer> Hash = new HashMap<>();
        
        // The loop runs for i in range(N + 1)
        for (int i = 0; i <= N; i++) {
            // ne = L[x]
            // We must ensure x is a valid index for L. Since L has size N+1, and x starts at 1, 
            // we need to check bounds if x can exceed N.
            if (x >= L.size()) break; // Safety break if x goes out of bounds unexpectedly
            
            int ne = L.get(x);
            
            if (Hash.containsKey(ne)) {
                flag = true;
                t = Hash.get(ne);
                break;
            }
            
            path.add(ne);
            ind++;
            Hash.put(ne, ind);
            x = ne;
        }

        if (flag) {
            // loop = path[t:]
            List<Integer> loop = path.subList(t, path.size());
            
            if (K < path.size())
