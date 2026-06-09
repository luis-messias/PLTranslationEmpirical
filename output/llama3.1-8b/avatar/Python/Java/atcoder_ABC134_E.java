import java.util.Scanner;
import java.util.ArrayList;

public class atcoder_ABC134_E {
    public static int binarySearch(int[] arr, int key) {
        int bad = -1, good = arr.length;
        while (good - bad > 1) {
            int mid = (bad + good) / 2;
            if (arr[mid][0] < key) {
                good = mid;
            } else {
                bad = mid;
            }
        }
        return good;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(scanner.nextLine());
            int idx = binarySearch(ans, A);
            if (idx == ans.size()) {
                ans.add(new ArrayList<>(java.util.Arrays.asList(A)));
            } else {
                ans.get(idx).add(A);
            }
        }
        System.out.println(ans.size());
    }
}