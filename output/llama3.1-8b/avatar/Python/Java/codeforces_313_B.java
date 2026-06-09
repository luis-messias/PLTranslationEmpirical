import java.util.Scanner;

public class codeforces_313_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String soz = scanner.nextLine();
        int[] a = new int[soz.length() + 1];
        for (int i = 1; i < soz.length(); i++) {
            a[i] = a[i - 1];
            if (soz.charAt(i - 1) == soz.charAt(i)) {
                a[i]++;
            }
        }
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            sb.append(a[Integer.parseInt(input[1]) - 1] - a[Integer.parseInt(input[0]) - 1]).append("\n");
        }
        System.out.print(sb.toString());
    }
}