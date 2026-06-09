import java.util.Scanner;

public class s242961129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        int ans = Math.abs(A[N - 1]);
        int[] diff = new int[N];
        A = addPadding(A);
        for (int i = 1; i <= N; i++) {
            int dif = absDiff(A[i], A[i-1]) + absDiff(A[i], A[i+1]) - absDiff(A[i-1], A[i+1]);
            ans += Math.abs(A[i] - A[i-1]);
            diff[i - 1] = dif;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(ans - diff[i]);
        }
    }

    private static int[] addPadding(int[] arr) {
        int[] newArr = new int[arr.length + 2];
        System.arraycopy(arr, 0, newArr, 1, arr.length);
        return newArr;
    }

    private static int absDiff(int a, int b) {
        return Math.abs(a - b);
    }
}
