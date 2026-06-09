import java.util.Scanner;

public class s251858505 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        
        int count = 0;
        int len = Math.min(s1.length(), s2.length());
        
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}