import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC123_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int z = Integer.parseInt(input[2]);
        int k = Integer.parseInt(input[3]);

        int[][] a = new int[x][y];
        for (int i = 0; i < x; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < y; j++) {
                a[i][j] = Integer.parseInt(row[j]);
            }
        }

        int[][] b = new int[x][y];
        for (int i = 0; i < x; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < y; j++) {
                b[i][j] = Integer.parseInt(row[j]);
            }
        }

        int[][] c = new int[z][x * y];
        for (int i = 0; i < z; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < x * y; j++) {
                c[i][j] = Integer.parseInt(row[j]);
            }
        }

        int[] ab = new int[x * y];
        int index = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                ab[index++] = a[i][j] + b[i][j];
            }
        }

        Arrays.sort(ab);
        reverseArray(ab);

        int[] abc = new int[k];
        index = 0;
        for (int i = 0; i < Math.min(k, x * y); i++) {
            for (int j = 0; j < z; j++) {
                abc[index++] = ab[i] + c[j][i];
            }
        }

        Arrays.sort(abc);
        reverseArray(abc);

        for (int i = 0; i < k; i++) {
            System.out.println(abc[i]);
        }
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
}
