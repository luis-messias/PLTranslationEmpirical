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
        
        // Input helper methods (equivalent to Python lambdas)
        // num_inp = lambda : int(input())
        int num = sc.nextInt();
        
        // arr_inp = lambda : list(map(int, input().split()))
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // sp_inp = lambda : map(int, input().split())
        IntStream sp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt);
        
        // str_inp = lambda : input()
        String str = sc.nextLine();
    }
    
    // Helper methods equivalent to Python lambdas
    public static int num_inp() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    public static int[] arr_inp() {
        Scanner sc = new Scanner(System.in);
        return Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
    public static IntStream sp_inp() {
        Scanner sc = new Scanner(System.in);
        return Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt);
    }
    
    public static String str_inp() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}