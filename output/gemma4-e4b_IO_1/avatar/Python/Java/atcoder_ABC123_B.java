import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class atcoder_ABC123_B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // menu stores pairs: [number (int), e (int)]
        ArrayList<int[]> menu = new ArrayList<>();
        
        // Read 5 inputs
        for (int i = 0; i < 5; i++) {
            if (!scanner.hasNext()) {
                break; // Handle case where input might terminate early
            }
            String m = scanner.next();
            
            // Get the last digit e
            char lastChar = m.charAt(m.length() - 1);
            int e = Character.getNumericValue(lastChar);
            
            // Apply the rule: if e == 0, set e = 10
            if (e == 0) {
                e = 10;
            }
            
            // Store [int(m), e]
            int[] pair = new int[2];
            pair[0] = Integer.parseInt(m);
            pair[1] = e;
            menu.add(pair);
        }
        
        scanner.close();

        // Sort menu based on the second element (index 1)
        Collections.sort(menu, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        long ans = 0;
        
        // Iterate over menu[1:] (all elements except the first one)
        for (int i = 1; i < menu.size(); i++) {
            int[] m = menu.get(i);
            int m0 = m[0];
            
            // Calculate math.ceil(m[0] / 10) *
