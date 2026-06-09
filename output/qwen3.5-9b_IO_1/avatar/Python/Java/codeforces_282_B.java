import java.util.Scanner;
import java.util.ArrayList;

public class codeforces_282_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstline = scanner.nextInt();
        int total = 0;
        ArrayList<String> memory = new ArrayList<>();
        
        for (int i = 0; i < firstline; i++) {
            int A = scanner.nextInt();
            int G = scanner.nextInt();
            
            if (total + A <= 500) {
                total += A;
                memory.add("A");
            } else {
                total -= G;
                memory.add("G");
            }
        }
        
        System.out.println(String.join("", memory));
    }
}
