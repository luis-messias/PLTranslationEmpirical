import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class codeforces_459_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line

        // Read the list l1
        if (!scanner.hasNextLine()) return;
        String line = scanner.nextLine();
        
        String[] parts = line.split(" ");
        
        List<Integer> l1 = new ArrayList<>();
        for (String part : parts) {
            if (!part.isEmpty()) {
                l1.add(Integer.parseInt(part));
            }
        }

        // Sort l1
        Collections.sort(l1);

        // a is the last element (max)
        int a = l1.get(l1.size() - 1);
        // b is the first element (min)
        int b = l1.get(0);

        if (a == b) {
            // print ( a - b , ( n ) * ( n - 1 ) // 2 )
            long result2 = (long)n * (n - 1) / 2;
            System.out.println(a - b + " " + result2);
        } else {
            // ac = l1.count ( a )
            long ac = l1.stream().filter(x -> x == a).count();
            // bc = l1.count ( b )
            long bc = l1.stream().filter(x -> x == b).count();
            
            // print ( a - b , ac * bc )
            System.out.println(a - b + " " + (ac * bc));
        }
        
        scanner.close();
    }
}
