import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class s735480710 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N (and discard it)
        String lineN = reader.readLine();
        if (lineN == null) return;
        
        // Read the list A
        String lineA = reader.readLine();
        if (lineA == null) return;

        String[] parts = lineA.split(" ");
        List<String> a = Arrays.asList(parts);
        int L = a.size();

        // 1. Extract odd elements (a[1::2])
        List<String> oddElements = new ArrayList<>();
        for (int i = 1; i < L; i += 2) {
            oddElements.add(a.get(i));
        }
        
        // 2. Extract even elements (a[::2])
        List<String> evenElements = new ArrayList<>();
        for (int i = 0; i < L; i += 2) {
            evenElements.add(a.get(i));
        }

        // 3. Reverse odd elements (a[1::2][::-1])
        Collections.reverse(oddElements);
        
        // 4. Concatenate: b = reversed_odd + even
        List<String> b = new ArrayList<>();
        b.addAll(oddElements);
        b.addAll(evenElements);

        // 5. Determine final output based on length L
        List<String> result;
        if (L % 2 == 0) {
            // Even length: print b
            result = b;
        } else {
            // Odd length: print b reversed (b[::-1])
            result = new ArrayList<>(b);
            Collections.reverse(result);
        }

        // 6. Print the result joined by spaces
        System.out.println(String.join(" ", result));
    }
}
