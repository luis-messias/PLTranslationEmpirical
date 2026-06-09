import java.util.*;

public class codeforces_296_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String m = scanner.nextLine();
        
        Set<Character> uniqueElements = new HashSet<>();
        for (char c : m.toCharArray()) {
            uniqueElements.add(c);
        }
        
        boolean possible = true;
        for (Character element : uniqueElements) {
            if ((m.length() - m.replace(String.valueOf(element), "").length()) >= n / 2 + 1) {
                possible = false;
                break;
            }
        }
        
        System.out.println(possible ? "YES" : "NO");
    }
}
