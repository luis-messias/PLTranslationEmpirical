import java.util.Scanner;

public class codeforces_25_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int countOdd = 0;
        for (String s : input) {
            if (Integer.parseInt(s) % 2 != 0) {
                countOdd++;
            }
        }
        System.out.println(countOdd == 1 ? countOdd : n - countOdd + 1);
    }
}
