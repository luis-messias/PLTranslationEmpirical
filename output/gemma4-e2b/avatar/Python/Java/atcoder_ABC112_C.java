import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class atcoder_ABC112_C {

    // Helper class or structure to hold the result of reading input
    static class InputData {
        int n;
        List<List<Integer>> ls_xyh;

        InputData(int n, List<List<Integer>> ls_xyh) {
            this.n = n;
            this.ls_xyh = ls_xyh;
        }
    }

    static class Candidate {
        int x;
        int y;
        int h;

        Candidate(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    static String solve(int n, List<List<Integer>> ls_xyh) {
        int x0 = -1;
        int y0 = -1;
        int h0 = -1;

        // Step 1: Find x0, y0, h0
        for (int i = 0; i < n; i++) {
            // Assuming ls_xyh[i] has at least 3 elements based on Python indexing [2]
            if (ls_xyh.get(i).size() > 2 && ls_xyh.get(i).get(2) > 0) {
                x0 = ls_xyh.get(i).get(0);
                y0 = ls_xyh.get(i).get(1);
                h0 = ls_xyh.get(i).get(2);
                break;
            }
        }

        // Step 2: Generate cands
        List<Candidate> cands = new ArrayList<>();
        for (int cx = 0; cx <= 100; cx++) {
            for (int cy = 0; cy <= 100; cy++) {
                int h = h0 + Math.abs(cx - x0) + Math.abs(cy - y0);
                cands.add(new Candidate(cx, cy, h));
            }
        }

        // Step 3: Filtering cands
        for (List<Integer> xyh : ls_xyh) {
            int x = xyh.get(0);
            int y = xyh.get(1