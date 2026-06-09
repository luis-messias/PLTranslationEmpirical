import java.util.Scanner;
import java.util.Arrays;

public class codeforces_231_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int c = 0;
        for (int i = 0; i < n; i++) {
            String inputStr = scanner.nextLine();
            int[] l1 = Arrays.stream(inputStr.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (java.util.Arrays.stream(l1).sum() > 1) {
                c++;
            }
        }
        System.out.println(c);
    }
}