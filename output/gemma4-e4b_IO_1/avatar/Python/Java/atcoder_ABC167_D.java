import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class atcoder_ABC167_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // Read L
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) return;
            L.add(scanner.nextInt());
        }
        scanner.close();

        // L.insert(0, -1)
        L.add(0, -1);

        // Initialization
        List<Integer> path = new ArrayList<>();
        path.add(1); // path starts with 1
        
        // ind tracks the index in the path (0-based)
        int ind = 0; 
        
        // x is the current node
        int x = 1;
        
        // t stores the starting index of the loop
        int t = -1;
        
        // flag indicates if a
