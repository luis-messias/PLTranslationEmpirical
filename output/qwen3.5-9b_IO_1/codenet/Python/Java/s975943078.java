import java.util.*;
import java.io.*;

public class s975943078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = (sc.nextInt() % K) - 1;
        }
        
        int[] sum_A = new int[N + 1];
        Map<Integer, List<Integer>> modK = new HashMap<>();
        modK.put(0, new ArrayList<>());
        modK.get(0).add(0);
        
        for (int i = 0; i < N; i++) {
            sum_A[i + 1] = (sum_A[i] + A[i]) % K;
            if (!modK.containsKey(sum_A[i + 1])) {
                modK.put(sum_A[i + 1], new ArrayList<>());
            }
            modK.get(sum_A[i + 1]).add(i + 1);
        }
        
        long count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : modK.entrySet()) {
            List<Integer> indices = entry.getValue();
            int lenK = indices.size();
            for (int i = 0; i < lenK; i++) {
                int a = indices.get(i);
                int target = a + K;
                int left = binarySearchLeft(indices, target, i, lenK);
                count += left - i - 1;
            }
        }
        
        System.out.println(count);
    }
    
    private static int binarySearchLeft(List<Integer> list, int target, int fromIndex, int toIndex) {
        int left = fromIndex;
        int right = toIndex - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
