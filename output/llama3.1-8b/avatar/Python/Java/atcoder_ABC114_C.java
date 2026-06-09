import java.util.*;

public class atcoder_ABC114_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        System.out.println(aaa("0"));
    }

    public static int aaa(String n) {
        if (Integer.parseInt(n) > N) return 0;
        Set<Character> set = new HashSet<>();
        for (char c : n.toCharArray()) set.add(c);
        boolean ans = set.equals(new HashSet<>(Arrays.asList('7', '5', '3')));
        if (!ans) return 0;
        int result = 1;
        for (char i : "753".toCharArray()) {
            result += aaa(String.valueOf(Integer.parseInt(n) + i));
        }
        return result;
    }
}