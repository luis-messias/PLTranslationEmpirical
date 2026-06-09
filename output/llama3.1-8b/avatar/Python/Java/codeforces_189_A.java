import java.util.Arrays;
import java.util.Scanner;

public class codeforces_189_A {
    public static void cutRibbon() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int length = Integer.parseInt(input[0]);
        int[] arr = Arrays.stream(Arrays.copyOfRange(input, 1, 4))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        
        if (length % arr[0] == 0) {
            System.out.println(length / arr[0]);
            return;
        }
        
        int ans = 0;
        if (arr[0] == arr[1]) {
            for (int i = 0; i <= length / arr[2]; i++) {
                int check = length - i * arr[2];
                if (check >= 0 && check % arr[0] == 0) {
                    ans = Math.max(ans, i + check / arr[0]);
                }
            }
        } else {
            for (int i = 0; i <= length / arr[2]; i++) {
                for (int j = 0; j <= length / arr[1]; j++) {
                    int check = length - i * arr[2] - j * arr[1];
                    if (check >= 0 && check % arr[0] == 0) {
                        ans = Math.max(ans, i + j + check / arr[0]);
                    }
                }
            }
        }
        
        System.out.println(ans);
    }

    public static void main(String[] args) {
        cutRibbon();
    }
}