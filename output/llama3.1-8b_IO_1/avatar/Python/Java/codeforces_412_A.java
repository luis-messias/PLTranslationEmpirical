import java.util.Scanner;

public class codeforces_412_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        String v = scanner.nextLine();
        boolean f = k - 1 < n - k;
        int m = Math.min(k - 1, n - k);
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (!f) {
                a.append("LEFT\n");
            } else {
                a.append("RIGHT\n");
            }
        }
        String reversedV = new StringBuilder(v).reverse().toString();
        int start = f ? 1 : 0;
        for (int i = start; i < v.length(); i += 2) {
            if (!f) {
                a.append("PRINT ").append(reversedV.charAt(i)).append("\n");
                a.append("LEFT\n");
            } else {
                a.append("PRINT ").append(reversedV.charAt(i)).append("\n");
                a.append("RIGHT\n");
            }
        }
        System.out.println(a.toString());
    }
}
