import java.util.*;

public class atcoder_ABC132_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        Map<Character, Integer> c = new HashMap<>();
        for (char ch : S.toCharArray()) {
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }
        Set<Character> Sa = new HashSet<>(Arrays.asList(S.toCharArray()));
        if (Sa.size() != 2) {
            System.out.println("No");
            return;
        }
        for (char i : Sa) {
            if (c.get(i) != 2) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
