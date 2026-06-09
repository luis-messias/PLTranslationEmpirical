import java.util.Scanner;

public class s557080041 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();
        if (N.equals("0")) {
            System.out.println("Yes");
        } else {
            StringBuilder sb = new StringBuilder(N);
            int[] L = new int[N.length()];
            for (int i = 0; i < N.length(); i++) {
                L[i] = Character.getNumericValue(sb.charAt(i));
            }
            int X = 0;
            for (int num : L) {
                X += num;
            }
            if (X % 9 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}