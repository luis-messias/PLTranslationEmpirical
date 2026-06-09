import java.util.Scanner;

public class s537584449 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        func(a);
    }

    public static void func(int a) {
        StringBuilder digits = new StringBuilder();
        while (a != 0) {
            digits.append(a % 10);
            a /= 10;
        }
        int result = 0;
        for (char c : digits.toString().toCharArray()) {
            result += Character.getNumericValue(c);
        }
        if (result == 1) {
            System.out.println("10");
        } else {
            System.out.println(result);
        }
    }
}
