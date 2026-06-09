import java.util.Scanner;

public class s661542483 {
    public static int dfs(int h) {
        if (h == 1) {
            return 1;
        }
        // h // 2 in Python corresponds to h / 2 in Java for integer division
        return dfs(h / 2) * 2 + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int H = scanner.nextInt();
            System.out.println(dfs(H));
        }
        scanner.close();
    }
}