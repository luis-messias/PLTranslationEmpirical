import java.util.Scanner;

public class s000375264 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int t = sc.nextInt();
        
        int answer;
        if (X > t) {
            answer = X - t;
        } else {
            answer = 0;
        }
        
        System.out.println(answer);
    }
}