import java.util.Scanner;

public class s893778513 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] l = new int[n];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            l[i] = scanner.nextInt();
            if (l[i] > max) {
                max = l[i];
            }
            sum += l[i];
        }
        
        if (max < sum - max) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
}