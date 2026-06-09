import java.util.Scanner;

public class s031917494 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int absValue = Math.abs(n - 25);
        StringBuilder sb = new StringBuilder();
        sb.append("Christmas");
        for (int i = 0; i < absValue; i++) {
            sb.append(" Eve");
        }
        System.out.println(sb.toString());
    }
}