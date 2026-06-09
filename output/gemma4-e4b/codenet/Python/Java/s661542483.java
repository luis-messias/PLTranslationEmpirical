import java.util.Scanner;

public class s661542483 {
    public static int dfs(int h) {
        if (h == 1) {
            return 1;
        }
        // Integer division in Java
        return dfs(h / 2) * 2 + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read H
        int H = scanner.nextInt();
        
        // Calculate and print the result
        System.out.println(dfs(H));
        
        scanner.close();
    }
}