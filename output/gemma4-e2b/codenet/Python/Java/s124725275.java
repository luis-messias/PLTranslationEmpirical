import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class s124725275 {

    // Helper function to read a line and split it into integers
    private static List<Integer> readInts(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null) return new ArrayList<>();
        return Arrays.stream(line.split("\\s+"))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    // Helper function to read a single line of space-separated integers
    private static List<Integer> readIntsFromLine(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null) return new ArrayList<>();
        return Arrays.stream(line.split("\\s+"))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    // Helper function to read a line and return a list of integers (used for map reading)
    private static List<Integer> readLineAsInts(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null) return new ArrayList<>();
        return Arrays.stream(line.split("\\s+"))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    // Reads H rows of space-separated integers and returns a tuple of columns (transposed)
    private static int[][] readCol(BufferedReader br, int H) throws IOException {
        int[][] ret = new int[H][];
        for (int i = 0; i < H; i++) {
            List<Integer> row = readIntsFromLine(br);
            ret[i] = row.stream().mapToInt(Integer::intValue).toArray();
        }

        // Transpose the matrix
        int W = ret[0].length;
        int[][] transposed = new int[W][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                transposed[j][i] = ret[i][j];
            }
        }
        return transposed;
    }

    // Reads the map, performs replacements, and handles padding
    private static int[][] readMapAs(BufferedReader br, int H, String replace, String pad, int W) throws IOException {
        int[][] ret = new int[H][W];

        for (int i = 0; i < H; i++) {
            List<Integer> line = readLineAsInts(br);
            if (line.size() != W) {
                // Handle potential mismatch if input format is strict
                // For this problem context, we assume input matches W
            }
            for (int j = 0; j < W; j++) {
                char c = (j < line.size()) ? line.get(j).toString().charAt(0) : ' ';
                if (c == '#') {
                    ret[i][j] = 1;
                } else if (c == '.') {
                    ret[i][j] = 0;
                } else {
                    // If the input contains characters other than # or ., we assume they are part of the padding logic
                    // Based on the Python code, it seems to read the string and map it.
                    // Since the input reading is complex in Java, we rely on the structure implied by the Python logic.
                    // If the input is strictly digits (0/1), we use those.
                    // Assuming the input