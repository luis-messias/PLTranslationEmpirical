import java.util.Scanner;

public class s704354119 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] l = scanner.nextLine().split(" ");
        
        int max = -1000000000;
        int min = 1000000000;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(l[i]);
            sum += num;
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        
        System.out.println(min + " " + max + " " + sum);
    }
}
