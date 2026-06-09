import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class codeforces_474_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // First input (counts)
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine();
        String[] tokens1 = line1.split(" ");

        List<Integer> L = new ArrayList<>();
        int r = 1;

        // Process the first input line
        for (String kStr : tokens1) {
            if (!kStr.isEmpty()) {
                int k = Integer.parseInt(kStr);
                for (int i = 0; i < k; i++) {
                    L.add(r);
                }
                r++;
            }
        }

        // Second input (indices)
        if (!scanner.hasNextLine()) return;
        String line2 = scanner.nextLine();
        String[] tokens2 = line2.split(" ");

        // Process the second input line
        for (String jStr : tokens2) {
            if (!jStr.isEmpty()) {
                int j = Integer.parseInt(jStr);
                // print(L[int(j) - 1])
                if (j > 0 && j <= L.size()) {
                    System.out.println(L.get(j - 1));
                }
            }
        }
        
        scanner.close();
    }
}