import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class codeforces_369_B {

    /**
     * Translates the Python function get_nums(num, t).
     * Returns a list of 'num' integers.
     */
    private static List<Integer> getNums(int num, int t) {
        List<Integer> result = new ArrayList<>();
        
        if (num == 0) {
            return result;
        }
        
        // t // num is integer division
        int baseValue = t / num;
        
        // t % num is the remainder
        int countPlusOne = t % num;

        for (int i = 0; i < num; i++) {
            // Python logic: if i in range(t % num) else
            if (i < countPlusOne) {
                result.add(baseValue + 1);
            } else {
                result.add(baseValue);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n, k, l, r, sa, sk
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int sa = scanner.nextInt();
        int sk = scanner.nextInt();
        
        scanner.close();

        // ans = get_nums(k, sk) + get_nums(n - k, sa - sk)
        List<Integer> ans1 = getNums(k, sk);
        List<Integer> ans2 = getNums(n - k, sa - sk);
        
        // Concatenate the two lists
        ans1.addAll(ans2);

        // Print the result space-separated
        String result = ans1.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        
        System.out.println(result);
    }
}
