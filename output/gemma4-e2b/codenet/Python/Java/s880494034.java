import java.util.Scanner;

public class s880494034 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (line 1, ignored)
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        scanner.nextLine();

        // Read XS (line 2)
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String line = scanner.nextLine();
        String[] parts = line.split("\\s+");
        
        // Parse XS
        int[] XS = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            XS[i] = Integer.parseInt(parts[i]);
        }

        // m initialization, matching Python's large initial value
        long m = 9999999999L; 

        // Loop i from 1 to 100
        for (int i = 1; i <= 100; i++) {
            long c = 0;
            // Calculate c = sum([(x - i) ** 2 for x in XS])
            for (int x : XS) {
                long diff = (long)x - i;
                c += diff * diff;
            }
            
            if (m > c) {
                m = c;
            }
        }

        System.out.println(m);
        
        scanner.close();
    }
}