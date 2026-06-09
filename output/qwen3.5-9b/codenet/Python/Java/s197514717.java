import java.util.Scanner;

public class s197514717 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ABC = new int[3];
        ABC[0] = sc.nextInt();
        ABC[1] = sc.nextInt();
        ABC[2] = sc.nextInt();
        
        int A = ABC[0];
        int B = ABC[1];
        int C = ABC[2];
        
        int num1 = 10 * A + B + C;
        int num2 = 10 * B + C + A;
        int num3 = 10 * C + A + B;
        
        System.out.println(Math.max(Math.max(num1, num2), num3));
    }
}