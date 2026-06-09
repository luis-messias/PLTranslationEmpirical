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
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = (Integer.parseInt(br.readLine()) % K) - 1;
        }

        int[] sum_A = new int[N + 1];
        HashMap<Integer, Integer> modK = new HashMap<>();
        modK.put(0, 0);
        for (int i = 0; i < N; i++) {
            sum_A[i + 1] = (sum_A[i] + A[i]) % K;
            if (!modK.containsKey(sum_A[i+1])) modK.put(sum_A[i+1], i + 1);
            else modK.put(sum_A[i+1], modK.get(sum_A[i+1]) + 1);
        }

        int count = 0;
        for (int key : modK.keySet()) {
            int lenK = modK.get(key);
            for (int i = 0; i < lenK; i++) {
                count += bisectLeft(modK, key, i, lenK) - i - 1;
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
        return low;
    }
}