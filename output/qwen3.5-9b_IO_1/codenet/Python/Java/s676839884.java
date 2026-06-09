import java.util.Scanner;

public class s676839884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        
        if (t.substring(0, t.length() - 1).equals(s)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
