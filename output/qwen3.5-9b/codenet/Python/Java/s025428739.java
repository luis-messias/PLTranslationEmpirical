import java.util.Scanner;

public class s025428739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        int max = Math.max(A + B, Math.max(A - B, A * B));
        
        System.out.println(max);
    }
}