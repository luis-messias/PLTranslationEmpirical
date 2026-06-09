import java.util.Scanner;

public class s167793578 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);

        long a = (long) N * (N - 1) / 2;
        long b = (long) M * (M - 1) / 2;

        System.out.println(a + b);
    }
}