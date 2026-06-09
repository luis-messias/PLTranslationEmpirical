import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class atcoder_ABC143_D {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("0"))) {
            String[] tokens = br.readLine().split("\\s+");
            int n = Integer.parseInt(tokens[0]);
            int[] l = new int[n];
            for (int i = 1; i <= n; i++) {
                l[i - 1] = Integer.parseInt(tokens[i]);
            }
            Arrays.sort(l);
            long ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int a = l[i];
                    int b = l[j];
                    int right = binarySearchLeft(l, a + b);
                    int left = binarySearchRight(l, Math.max(a - b, b - a));
                    long tmp = Math.max(0, (long)right - left);
                    if (left <= i && right > i) {
                        tmp--;
                    }
                    if (left <= j && right > j) {
                        tmp--;
                    }
                    ans += tmp;
                }
            }
            System.out.println(ans / 3);
        }
    }

    public static int binarySearchLeft(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int binarySearchRight(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}