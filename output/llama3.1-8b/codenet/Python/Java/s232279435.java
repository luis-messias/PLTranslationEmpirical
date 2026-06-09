import java.util.Scanner;
import java.util.Set;

public class s232279435 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            Set<Character> x = s.substring(0, i + 1).chars().distinct().collect(java.util.stream.Collectors.toSet());
            Set<Character> y = s.substring(i + 1).chars().distinct().collect(java.util.stream.Collectors.toSet());

            int z = 0;
            for (char w : x) {
                if (y.contains(w)) {
                    z++;
                }
            }
            ans = Math.max(ans, z);
        }
        System.out.println(ans);
    }
}