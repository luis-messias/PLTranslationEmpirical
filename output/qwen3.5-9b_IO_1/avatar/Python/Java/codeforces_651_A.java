import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class codeforces_651_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read x and y
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        // Calculate and print result
        int result = Math.max(x + y - 3 + ((y - x) % 3 > 0 ? 1 : 0), 0);
        System.out.println(result);
    }
    
    // Input helper methods equivalent to Python lambdas
    public static int num_inp(Scanner sc) {
        return sc.nextInt();
    }
    
    public static int[] arr_inp(Scanner sc) {
        String line = sc.nextLine();
        return Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
    public static IntStream sp_inp(Scanner sc) {
        String line = sc.nextLine();
        return Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt);
    }
    
    public static String str_inp(Scanner sc) {
        return sc.nextLine();
    }
}
