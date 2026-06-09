import java.util.*;
import java.io.*;

public class s591424993 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read d and g
        String[] line1 = br.readLine().split(" ");
        int d = Integer.parseInt(line1[0]);
        long g = Long.parseLong(line1[1]);

        // Read pc matrix
        // pc[i][0] and pc[i][1]
        long[][] pc = new long[d][2];
        for (int i = 0; i < d; i++) {
            String[] line = br.readLine().split(" ");
            pc[i][0] = Long.parseLong(line[0]);
            pc[i][1] = Long.parseLong(line[1]);
        }

        double ans = Double.POSITIVE_INFINITY;

        // Iterate through all 2^d subsets
        for (int bit = 0; bit < (1 << d); bit++) {
            long count = 0;
            long sum = 0;
            Set<Integer> nokori = new HashSet<>();
            for (int i
