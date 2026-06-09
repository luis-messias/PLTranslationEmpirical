import java.util.Scanner;

public class atcoder_ABC042_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ABC = new int[3];
        for (int i = 0; i < 3; i++) {
            ABC[i] = sc.nextInt();
        }
        
        int count5 = 0;
        int sum = 0;
        for (int num : ABC) {
            if (num == 5) {
                count5++;
            }
            sum += num;
        }
        
        if (count5 == 2) {
            if (sum == 17) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }
    }
}
