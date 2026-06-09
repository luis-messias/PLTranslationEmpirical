import java.util.Scanner;

public class s661542483 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        System.out.println(dfs(H));
    }

    public static int dfs(int h) {
        if (h == 1) {
            return 1;
        }
        return dfs(h / 2) * 2 + 1;
    }
}
