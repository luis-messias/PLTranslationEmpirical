import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class s131946120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<String> uniqueStrings = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueStrings.add(scanner.next());
        }
        System.out.println(uniqueStrings.size());
    }
}