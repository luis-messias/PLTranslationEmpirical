import java.util.Scanner;
public class s621701371 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int q = Integer.parseInt(scanner.nextLine());
        String[][] qs = new String[q][];
        boolean n = false;
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] operation = scanner.nextLine().split(" ");
            if (operation[0].equals("1")) {
                n = !n;
            }
            if (operation.length > 1 && operation[0].equals("2")) {
                int f = Integer.parseInt(operation[1]);
                if (n) {
                    f = f == 1 ? 2 : 1;
                }
                if (f == 1) {
                    left.append(operation[2]).insert(0, left);
                } else if (f == 2) {
                    right.append(operation[2]);
                }
            }
        }
        String result = n ? new StringBuilder(s).reverse().toString() : s + left.toString() + right.toString();
        System.out.println(result);
    }
}
