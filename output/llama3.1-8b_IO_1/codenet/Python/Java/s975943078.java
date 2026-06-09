import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class s975943078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solve(br);
    }

    public static void solve(BufferedReader br) throws IOException {
        String input = br.readLine();
        String[] parts = input.split(" ");
        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            parts = input.split(" ");
            A[i] = (Integer.parseInt(parts[0]) % K) - 1;
        }

        int[] sum_A = new int[N + 1];
        HashMap<Integer, Integer> modK = new HashMap<>();
        modK.put(0, 0);
        for (int i = 0; i < N; i++) {
            sum_A[i + 1] = (sum_A[i] + A[i]) % K;
            if (!modK.containsKey(sum_A[i+1])) modK.put(sum_A[i+1], 1);
            else modK.put(sum_A[i+1], modK.get(sum_A[i+1]) + 1);
        }

        int count = 0;
        for (int key : modK.keySet()) {
            int lenK = modK.get(key);
            for (int i = 0; i < lenK; i++) {
                if(i == lenK - 1) {
                    count += bisectLeft(modK, key, i + 1, lenK);
                } else {
                    count += bisectLeft(modK, key, i + 1, lenK) - (i + 1) - 1;
                }
            }
        }

        System.out.println(count);
    }

    public static int bisectLeft(HashMap<Integer, Integer> modK, int key, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (modK.get(key) <= mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return modK.getOrDefault(key, 0);
    }
}
