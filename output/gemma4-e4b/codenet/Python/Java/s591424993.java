import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;

public class s591424993 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read D and G
        long dLong = scanner.nextLong();
        long g = scanner.nextLong();
        int d = (int) dLong;

        // Read pc array
        long[][] pc = new long[d][2];
        for (int i = 0; i < d; i++) {
            pc[i][0] = scanner.nextLong();
            pc[i][1] = scanner.nextLong();
        }
        
        scanner.close();

        long ans = Long.MAX_VALUE;

        // Iterate through all 2^d subsets
        for (int bit = 0; bit < (1 << d); bit++) {
            long count = 0;
            long sum = 0;
            Set<Integer> nokori = new HashSet<>();
            for (int i = 1; i <= d; i++) {
                nokori.add(i);
            }