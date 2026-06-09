import java.util.Scanner;
import java.util.Set;

public class s131946120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueInputs = new java.util.HashSet<>();
        
        for (int i = 0; i < n; i++) {
            uniqueInputs.add(scanner.nextLine());
        }
        
        System.out.println(uniqueInputs.size());
    }
}