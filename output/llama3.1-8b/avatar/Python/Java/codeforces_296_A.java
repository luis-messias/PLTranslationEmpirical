import java.util.*;

public class codeforces_296_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] m = scanner.nextLine().split(" ");
        
        Set<String> uniqueElements = new HashSet<>(Arrays.asList(m));
        boolean possible = true;
        
        for (String element : uniqueElements) {
            if (Collections.frequency(Arrays.asList(m), element) >= n / 2 + 1) {
                possible = false;
                break;
            }
        }
        
        System.out.println(possible ? "YES" : "NO");
    }
}