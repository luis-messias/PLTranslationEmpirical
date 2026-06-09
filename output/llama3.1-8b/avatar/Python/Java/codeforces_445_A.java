import java.util.Scanner;
import java.util.ArrayList;

public class codeforces_445_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ArrayList<String[]> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            char[] arr = s.toCharArray();

            for (int j = 0; j < m; j++) {
                if (arr[j] == '.') {
                    if ((i + j) % 2 != 0) {
                        arr[j] = 'W';
                    } else {
                        arr[j] = 'B';
                    }
                }
            }

            l.add(arr);
        }

        for (String[] c : l) {
            System.out.println(new String(c));
        }
    }
}