import java.util.Scanner;

public class atcoder_ABC174_E {

    private static boolean check(int[] lis, int k, int mid) {
        int currentK = k;
        
        for (int i : lis) {
            if (i % mid == 0) {
                currentK += 1;
            }
            currentK -= (i / mid);
        }
        return currentK >= 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // Read LIS elements and find max
        int[] lis = new int[n];
        int maxLis = 0;
        for (int i = 0; i < n; i++) {
            lis[i] = scanner.nextInt();
            if (lis[i] > maxLis) {
                maxLis = lis[i];
            }
        }
        
        scanner.close();

        // Binary Search setup
        int a = 1;
        int b = maxLis;
        int ans = b; 

        while (a <= b) {
            int mid = a + (b - a) / 2;
            
            if (check(lis, k, mid)) {
                ans = mid;
                b = mid - 1; // Try smaller
            } else {
                a = mid + 1; // Need larger
            }
        }

        System.out.println(ans);
    }
}