import java.util.*;

public class codeforces_96_B {
    static List<Integer> l = new ArrayList<>();
    static int limit = 10000000000;

    public static void gen(int number, int four, int seven) {
        if (number > limit) return;
        if (number > 0 && four == seven) l.add(number);
        gen(number * 10 + 4, four + 1, seven);
        gen(number * 10 + 7, four, seven + 1);
    }

    public static void main(String[] args) {
        gen(0, 0, 0);
        Collections.sort(l);
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int ans = 0;
        for (int val : l) {
            if (val >= n) {
                ans = val;
                break;
            }
        }
        System.out.println(ans);
    }
}