import java.util.*;

public class atcoder_ABC110_C {
    public static String run(String s, String t) {
        List<Integer> ss = new ArrayList<>(Collections.frequency(s, '*'));
        Collections.sort(ss);
        List<Integer> tt = new ArrayList<>(Collections.frequency(t, '*'));
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