import java.util.Scanner;

public class s704354119 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        String[] l = new String[n];
        for (int i = 0; i < n; i++) {
            l[i] = scanner.next();
        }
        
        long sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int currentNum = Integer.parseInt(l[i]);
            sum += currentNum;
            if (max < currentNum) {
                max = currentNum;
            }
            if (min > currentNum) {
                min = currentNum;
            }
        }
        
        System.out.println(min + " " + max + " " + sum);
    }
}