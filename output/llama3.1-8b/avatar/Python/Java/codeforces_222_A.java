import java.util.Arrays;
import java.util.Scanner;

public class codeforces_222_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        String[] elemsStr = scanner.nextLine().split(" ");
        int[] elems = new int[n];
        for (int i = 0; i < n; i++) {
            elems[i] = Integer.parseInt(elemsStr[i]);
        }

        boolean allSame = Arrays.stream(elems).allMatch(x -> x == elems[0]);

        if (allSame) {
            System.out.println(0);
            return;
        }
        if (k == 1) {
            System.out.println(-1);
            return;
        }
        if (!Arrays.stream(Arrays.copyOfRange(elems, k - 1, elems.length)).allMatch(x -> x == elems[elems.length - 1])) {
            System.out.println(-1);
            return;
        }

        int target = elems[elems.length - 1];
        int[] toDelete = Arrays.copyOfRange(elems, 0, k - 1);

        while (toDelete.length > 0 && toDelete[toDelete.length - 1] == target) {
            toDelete = Arrays.copyOfRange(toDelete, 0, toDelete.length - 1);
        }
        System.out.println(toDelete.length);
    }
}