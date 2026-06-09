import java.util.*;
import java.io.*;

public class s043545989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        Map<Integer, Integer> B = new HashMap<>();
        for (int num : a) {
            B.put(num, B.getOrDefault(num, 0) + 1);
        }
        int[] k = B.keySet().toArray(new Integer[0]);
        int[] v = B.values().stream().mapToInt(Integer::intValue).toArray();
        
        if (B.size() == 3 && (k[0] ^ k[1] ^ k[2]) == 0 && v[0] == v[1] && v[1] == v[2]) {
            System.out.println("Yes");
        } else if (B.size() == 2 && Arrays.asList(k).contains(0) && (v[0] == 2 * v[1] || v[1] == 2 * v[0])) {
            System.out.println("Yes");
        } else if (B.size() == 1 && Arrays.asList(k).contains(0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}