import java.util.ArrayList;
import java.util.Scanner;

public class codeforces_474_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Read and discard the first input line (Python: input())
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        // 2. Process the counts (Python: for k in input().split())
        ArrayList<Integer> L = new ArrayList<>();
        int r = 1;
        
        if (scanner.hasNextLine()) {
            String line2 = scanner.nextLine();
            // Split by one or more whitespace characters
            String[] counts = line2.trim().split("\\s+");
            
            for (String k : counts) {
                if (!k.isEmpty()) {
                    int count = Integer.parseInt(k);
                    // Append r, 'count' times
                    for (int i = 0; i < count; i++) {
                        L.add(r);
                    }
                    r++;
                }
            }
        }

        // 3. Read and discard the third input line (Python: input())
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        // 4. Process the indices (Python: for j in input().split())
        if (scanner.hasNextLine()) {
            String line4 = scanner.nextLine();
            String[] indices = line4.trim().split("\\s+");
            
            for (String j : indices) {
                if (!j.isEmpty()) {
                    int index = Integer.parseInt(j);
                    // Print L[index - 1] because indices are 1-based
                    if (index > 0 && index <= L.size()) {
                        System.out.println(L.get(index - 1));
                    }
                }
            }
        }
        
        scanner.close();
    }
}