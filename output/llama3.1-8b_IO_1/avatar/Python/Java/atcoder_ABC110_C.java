import java.util.*;

public class atcoder_ABC110_C {
    public static String run(String s, String t) {
        Map<String, Integer> counterS = new HashMap<>();
        for (char c : s.toCharArray()) {
            counterS.put(String.valueOf(c), counterS.getOrDefault(String.valueOf(c), 0) + 1);
        }
        
        Map<String, Integer> counterT = new HashMap<>();
        for (char c : t.toCharArray()) {
            counterT.put(String.valueOf(c), counterT.getOrDefault(String.valueOf(c), 0) + 1);
        }

        List<Integer> ss = new ArrayList<>(counterS.values());
        Collections.sort(ss);
        
        List<Integer> tt = new ArrayList<>(counterT.values());
        Collections.sort(tt);

        if (ss.equals(tt)) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(run(s, t));
    }
}
