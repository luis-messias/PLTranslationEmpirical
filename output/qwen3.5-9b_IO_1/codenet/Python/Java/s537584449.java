import java.util.Scanner;

public class s537584449 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        
        int[] digits = new int[10];
        int temp = a;
        int index = 0;
        
        while (temp != 0) {
            digits[index++] = temp % 10;
            temp = temp / 10;
        }
        
        int result = 0;
        for (int digit : digits) {
            result += digit;
        }
        
        if (result == 1) {
            System.out.println("10");
        } else {
            System.out.println(result);
        }
    }
}
