import java.util.Scanner;

public class s146553386 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] a = new int[2][];
        
        for (int i = 0; i < 2; i++) {
            String[] input = scanner.nextLine().split(" ");
            a[i] = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                a[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        reverseArray(a[1]);
        
        long[] res_0 = cumsum(a[0]);
        long[] res_1 = cumsum(a[1]);
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long check = res_0[i] + res_1[n-1-i];
            ans = Math.max(ans, check);
        }
        
        System.out.println(ans);
    }
    
    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
    
    public static long[] cumsum(int[] array) {
        long[] result = new long[array.length];
        result[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            result[i] = result[i-1] + array[i];
        }
        return result;
    }
}
