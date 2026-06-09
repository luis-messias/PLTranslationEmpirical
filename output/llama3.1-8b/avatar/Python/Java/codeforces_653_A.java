import java.util.Arrays;
import java.util.Scanner;

public class codeforces_653_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] l = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            l[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(l);
        for (int i : l) {
            if (Arrays.asList(l).contains(i + 1) && Arrays.asList(l).contains(i + 2)) {
                System.out.println("YES");
                break;
            }
        } else {
            System.out.println("NO");
        }
    }
}