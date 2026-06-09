import java.util.*;

public class s043545989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        Map<Integer, Integer> B = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            B.put(a[i], B.getOrDefault(a[i], 0) + 1);
        }
        
        List<Integer> k = new ArrayList<>(B.keySet());
        List<Integer> v = new ArrayList<>(B.values());
        
        if (B.size() == 3 && (k.get(0) ^ k.get(1) ^ k.get(2)) == 0 && v.get(0) == v.get(1) && v.get(1) == v.get(2)) {
            System.out.println("Yes");
        } else if (B.size() == 2 && B.containsKey(0) && (v.get(0) == 2 * v.get(1) || v.get(1) == 2 * v.get(0))) {
            System.out.println("Yes");
        } else if (B.size() == 1 && B.containsKey(0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}