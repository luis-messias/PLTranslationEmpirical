import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s804484425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and K
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);

        // Read info: List of [t, d] pairs
        List<List<Integer>> info = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            List<Integer> row = new ArrayList<>();
            row.add(Integer.parseInt(line[0])); // t
            row.add(Integer.parseInt(line[1])); // d
            info.add(row);
        }

        // Sort info based on the second element (d) in descending order
        // info = sorted(info, key = itemgetter(1), reverse = True)
        Collections.sort(info, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                // Sort by the second element (index 1) in descending order
                return b.get(1).compareTo(a.get(1));
            }
        });

        // Select the
