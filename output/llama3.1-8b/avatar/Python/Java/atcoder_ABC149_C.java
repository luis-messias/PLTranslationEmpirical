import java.util.Scanner;

public class atcoder_ABC149_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = Integer.parseInt(scanner.nextLine());
        boolean[] prime = new boolean[100010];
        for (int i = 0; i < prime.length; i++) {
            prime[i] = true;
        }
        prime[0] = false;
        prime[1] = false;
        for (int i = 4; i < prime.length; i += 2) {
            prime[i] = false;
        }
        int i = 3;
        while (i * i <= 100008) {
            if (prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
            i += 2;
        }
        for (i = X; i < prime.length; i++) {
            if (prime[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}