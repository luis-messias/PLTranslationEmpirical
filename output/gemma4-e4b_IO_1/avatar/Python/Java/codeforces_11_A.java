import java.util.Scanner;

public class codeforces_11_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and D (assuming they are the first two integers)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        int d = scanner.nextInt();

        // Read the array X (reading all remaining integers)
        java.util.ArrayList<Integer> xList = new java.util.ArrayList<>();
        while (scanner.hasNextInt()) {
            xList.add(scanner.nextInt());
        }
        
        int[] x = new int[xList.size()];
        for (int i = 0; i < xList.size(); i++) {
            x[i] = xList.get(i);
        }

        long m = 0;
        int q = 0;

        // Iterate through the array up to the second to last element
        for (int a = 0; a < x.length - 1; a++) {
            if (x[a] >= x[a + 1]) {
                // Calculate q: q = (x[a] - x[a+1]) / d + 1
                // Since all values are integers, standard integer division is used.
                q = (x[a] - x[a + 1]) / d + 1;
                
                // Update m
                m = m + q;
                
                // Update x[a+1]
                x[a + 1] = x[a + 1] + q * d;
            }
        }

        System.out.println(m);
        
        scanner.close();
    }
}
