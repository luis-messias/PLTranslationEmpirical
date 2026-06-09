import java.util.Scanner;

public class codeforces_25_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline after nextInt()
        
        String[] input = scanner.nextLine().split(" ");
        int[] list = new int[n];
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(input[i]) % 2;
            sum += list[i];
        }
        
        if (sum == 1) {
            for (int i = 0; i < n; i++) {
                if (list[i] == 1) {
                    System.out.println(i + 1);
                    break;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (list[i] == 0) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}