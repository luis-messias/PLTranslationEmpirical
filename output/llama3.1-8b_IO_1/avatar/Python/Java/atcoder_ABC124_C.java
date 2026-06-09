import java.util.Scanner;

public class atcoder_ABC124_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int evenCount = 0, oddCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    evenCount++;
                } else {
                    oddCount++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
        }
        int min = Math.min(s.length() - evenCount, s.length() - oddCount);
        System.out.println(min);
    }
}
