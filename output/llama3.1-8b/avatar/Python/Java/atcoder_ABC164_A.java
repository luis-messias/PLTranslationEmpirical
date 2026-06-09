import java.util.Scanner;

public class atcoder_ABC164_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        int W = scanner.nextInt();
        System.out.println("unsafe");
        if (S > W) {
            System.out.println("safe");
        }
        scanner.close();
    }
}