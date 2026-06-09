import java.util.Scanner;

public class s043174379 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int ans = H * W - (h * W + W * h - h * w);
        System.out.println(ans);
    }
}