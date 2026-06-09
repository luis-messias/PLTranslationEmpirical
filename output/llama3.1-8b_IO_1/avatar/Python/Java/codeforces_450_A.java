import java.util.Scanner;

public class codeforces_450_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] numbersStr = scanner.nextLine().split(" ");
        int[] l = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            l[i] = Integer.parseInt(numbersStr[i]);
        }

        int[] l2 = new int[l.length];
        for (int i = 0; i < l.length; i++) {
            if (l[i] % m == 0) {
                l2[i] = l[i] / m;
            } else {
                l2[i] = l[i] / m + 1;
            }
        }

        int mx = Integer.MIN_VALUE;
        int ind = -1;
        for (int i = 0; i < l.length; i++) {
            if (l2[i] > mx) {
                mx = l2[i];
                ind = i;
            }
        }
        System.out.println(ind + 1);
    }
}
