import java.util.*;
import java.io.*;

public class atcoder_ABC143_D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] l = new int[n];
            for (int i = 0; i < n; i++) {
                l[i] = sc.nextInt();
            }
            Arrays.sort(l);
            
            long ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int a = l[i];
                    int b = l[j];
                    int right = upperBound(l, a + b);
                    int left = lowerBound(l, Math.max(a - b, b - a));
                    int tmp = Math.max(0, right - left);
                    if (left <= i && i < right) {
                        tmp--;
                    }
                    if (left <= j && j < right) {
                        tmp--;
                    }
                    ans += tmp;
                }
            }
            System.out.println(ans / 3);
        }
    }
    
    // bisect_left equivalent - first index >= value
    static int lowerBound(int[] arr, int value) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    // bisect_right equivalent - first index > value
    static int upperBound(int[] arr, int value) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
