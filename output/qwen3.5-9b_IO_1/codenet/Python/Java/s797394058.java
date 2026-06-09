import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class s797394058 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        List<Integer> N_list = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            N_list.add(x + 1);
        }
        
        // Calculate the number of combinations (product with repeat=3)
        // This is N^3
        int m = (int) Math.pow(N_list.size(), 3);
        
        System.out.println(m);
    }
}
