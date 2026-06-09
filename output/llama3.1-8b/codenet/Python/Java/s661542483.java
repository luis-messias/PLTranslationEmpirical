import java.util.Scanner;

public class s661542483 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = Integer.parseInt(scanner.nextLine());

        int count = 0;

        int dfs(int h) {
            if (h == 1)
                return 1;
            return dfs(h / 2) * 2 + 1;
        }

        System.out.println(dfs(H));
    }
}