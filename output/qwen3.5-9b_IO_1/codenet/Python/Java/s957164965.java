import java.util.*;

public class s957164965 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int X = scanner.nextInt();
        int N = scanner.nextInt();
        
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = scanner.nextInt();
        }
        
        Arrays.sort(p);
        
        Map<Integer, List<Integer>> candidates = new HashMap<>();
        
        for (int i = -1; i <= 101; i++) {
            if (Arrays.binarySearch(p, i) >= 0) {
                continue;
            }
            
            int key = Math.abs(X - i);
            if (!candidates.containsKey(key)) {
                candidates.put(key, new ArrayList<>());
            }
            candidates.get(key).add(i);
        }
        
        int smallest = Collections.min(candidates.keySet());
        int minNum = Collections.min(candidates.get(smallest));
        
        System.out.println(minNum);
    }
}
