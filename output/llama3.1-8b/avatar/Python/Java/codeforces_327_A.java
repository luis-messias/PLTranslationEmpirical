import java.util.*;

public class codeforces_327_A {
    public static List<Integer> find(String s, char ch) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine().replace("", "");
        if (!s.contains("0")) {
            System.out.println(n - 1);
        } else {
            List<Integer> indices = find(s, '0');
            if (indices.size() == 1) {
                System.out.println(n);
            } else {
                int maximum = 0;
                Set<List<Integer>> combs = new HashSet<>();
                for (int i = 0; i < indices.size(); i++) {
                    for (int j = i + 1; j < indices.size(); j++) {
                        List<Integer> pair = Arrays.asList(indices.get(i), indices.get(j));
                        Collections.sort(pair);
                        combs.add(pair);
                    }
                }
                for (List<Integer> pair : combs) {
                    maximum = Math.max(maximum, 2 + 2 * (Math.abs(pair.get(0) - pair.get(1)) - 1) - (Math.abs(indices.indexOf(pair.get(0)) - indices.indexOf(pair.get(1))) - 1));
                }
                System.out.println(s.length() - s.replace("1", "").length() + maximum);
            }
        }
    }
}