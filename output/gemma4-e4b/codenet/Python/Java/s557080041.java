import java.util.Scanner;

public class s557080041 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();
        
        if (N.equals("0")) {
            System.out.println("Yes");
        } else {
            int sum = 0;
            for (char c : N.toCharArray()) {
                sum += Character.getNumericValue(c);
            }
            
            if (sum % 9 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        scanner.close();
    }
}