import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC123_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> menu = new ArrayList<>();

        // Read 5 inputs
        for (int i = 0; i < 5; i++) {
            // Read the input line as a string
            String m = scanner.nextLine();
            
            // Extract the integer value (m[0] in Python context)
            int m_val = Integer.parseInt(m);
            
            // Extract the last character/digit (m[-1] in Python context)
            // Since m is a string, m.length() - 1 gives the index of the last character.
            int e = Character.getNumericValue(m.charAt(m.length() - 1));
            
            // Apply the conditional logic
            if (e == 0) {
                e = 10;
            }
            
            // Append [int(m), e] to menu
            menu.add(new int[]{m_val, e});
        }
        
        // Sort menu based on the second element (index 1)
        Collections.sort(menu, (a, b) -> Integer.compare(a[1], b[1]));
        
        long ans = 0;
        
        // Iterate over menu[1:]
        for (int i = 1; i < menu.size(); i++) {
            int m_val = menu.get(i)[0];
            
            // Calculate math.ceil(m[0] / 10) * 10
            // Since m_val is an integer, we use Math.ceil for floating point division
            long term = (long) Math.ceil((double) m_val / 10.0) * 10;
            ans += term;
        }
        
        // Add menu[0][0] to the result
        ans += menu.get(0)[0];
        
        System.out.println(ans);
        
        scanner.close();
    }
}