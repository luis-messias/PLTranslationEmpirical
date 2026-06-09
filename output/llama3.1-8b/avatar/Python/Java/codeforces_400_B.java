import java.util.Scanner;
import java.util.Set;

public class codeforces_400_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        Set<Integer> c = new java.util.HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            int indexS = s.indexOf("S");
            int indexG = s.indexOf("G");
            if (indexS != -1 && indexG != -1) {
                c.add(indexS - indexG);
            }
        }

        System.out.println(c.isEmpty() ? 0 : -1);
    }
}