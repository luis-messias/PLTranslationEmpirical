import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class codeforces_379_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int candeleIntere = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int s = 0;
        int restoSciolte = 0;

        while (candeleIntere > 0 || restoSciolte >= b) {
            candeleIntere += restoSciolte / b;
            restoSciolte %= b;
            s += candeleIntere;
            restoSciolte += candeleIntere % b;
            candeleIntere /= b;
        }

        System.out.println(s);
    }
}