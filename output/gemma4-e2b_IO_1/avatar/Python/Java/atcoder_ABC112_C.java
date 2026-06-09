import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class atcoder_ABC112_C {

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

    static class InputData {
        int n;
        List<List<Integer>> ls_xyh;

        InputData(int n, List<List<Integer>> ls_xyh) {
            this.n = n;
            this.ls_xyh = ls_xyh;
        }
    }

    static String solve(int n, List<List<Integer>> ls_xyh) {
        int x0 = -1;
        int y0 = -1;
        int h0 = -1;

        // Step 1: Find x0, y0, h0
        for (int i = 0; i < n; i++) {
            // Check if ls_xyh[i] exists and the height (index 2) is positive
            if (ls_xyh.get(i).size() > 2 && ls_xyh.get(i).get(2) > 0) {
                x0 = ls_xyh.get(i).get(0);
                y0 = ls_xyh.get(i).get(1);
                h0 = ls_xyh.get(i).get(2);
                break;
            }
        }

        // If no suitable point is found, we cannot proceed based on the Python logic structure.
        // Assuming a valid point is always found based on problem constraints.
