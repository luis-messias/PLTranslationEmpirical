import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class codeforces_61_B {

    // Helper function f(s): filters string s, keeping only lowercase alphanumeric characters.
    private static String f(String s) {
        StringBuilder r = new StringBuilder();
        for (char i : s.toCharArray()) {
            if (i != '-' && i != ';' && i != '_') {
                r.append(Character.toLowerCase(i));
            }
        }
        return r.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read the initial 3 strings (l)
        List<String> l = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            if (line == null) return; // Handle EOF
            l.add(line);
        }

        // 2. Generate all permutations of l
        List<List<String>> permutations = generatePermutations(l);

        // 3. Read inp()
        String inpLine = br.readLine();
        if (inpLine == null) return;
        int inp = Integer.parseInt(inpLine.trim());

        // 4. Process inp() instructions
        for (int i = 0; i < inp