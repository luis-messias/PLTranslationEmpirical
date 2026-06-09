import java.util.Scanner;

public class codeforces_678_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the two space-separated integers
        int vamshi = scanner.nextInt();
        int z = scanner.nextInt();
        
        scanner.close();
        
        // Calculate (vamshi // z + 1) * z
        // In Java, integer division (/) performs the floor operation for positive numbers, 
        // matching Python's // operator in this context.
        int result = (vamshi / z + 1) * z;
        
        System.out.println(result);
    }
}