import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class codeforces_459_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read the list l1
        // Read the next line containing the space-separated integers
        if (!scanner.hasNextLine()) return;
        String line = scanner.nextLine();
        
        // Handle potential empty line or ensure we read the list correctly
        // If the input stream is structured such that n is on one line and the list is on the next, 
        // we need to handle the transition carefully.
        
        // Re-reading the input based on the Python structure where input() is called twice:
        // Python: n = int(input())
        // Python: l1 = list(map(int, input().split()))
        
        // Let's reset the scanner approach to handle the input as if it were provided sequentially.
        // Since the provided snippet is a script, we assume standard input reading behavior.
        
        // If we assume the input is provided line by line:
        
        // Read n (already done above)
        
        // Read the list l1 from the next line
        String listLine = scanner.nextLine();
        String[] parts = listLine.split(" ");
        
        if (parts.length == 0) return;

        List<Integer> l1 = Arrays.stream(parts)
                               .mapToInt(Integer::parseInt)
                               .boxed()
                               .toList();

        // Sort l1
        l1.sort(null);

        // a is the last element (max)
        int a = l1.get(l1.size() - 1);
        // b is the first element (min)
        int b = l1.get(0);

        if (a == b) {
            // print ( a - b , ( n ) * ( n - 1 ) // 2 )
            System.out.println(a - b + " " + (n * (n - 1) / 2));
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