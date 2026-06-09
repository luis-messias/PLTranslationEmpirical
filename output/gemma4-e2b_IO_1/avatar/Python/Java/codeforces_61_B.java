import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            if (line == null) return;
            l.add(line);
        }

        // 2. Generate all permutations of l
        List<List<String>> permutations = generatePermutations(l);

        // 3. Read inp()
        String inpLine = br.readLine();
        if (inpLine == null) return;
        int inp = Integer.parseInt(inpLine.trim());

        // 4. Process inp() instructions
        for (int i = 0; i < inp; i++) {
            String instr = br.readLine();
            if (instr == null) break;
            
            String processedInstr = f(instr);
            
            boolean found = false;
            for (List<String> p : permutations) {
                // The Python code checks if f(instr) is in l (which was redefined as the concatenated permutations)
                // The Python logic: if f(instr) in l: print('ACC')
                // l here holds the concatenated strings from permutations.
                if (p.stream().collect(Collectors.joining(""))).contains(processedInstr) {
                    // Wait, the Python code checks if f(instr) in l.
