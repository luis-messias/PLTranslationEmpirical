import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class s124725275 {

    private static final int INF = Integer.MAX_VALUE; // Using Integer.MAX_VALUE for practical infinity in Dijkstra context
    // MOD is not used in the final calculation, but kept for context if needed.
    // private static final long MOD = 1_000_000_007L;

    // Helper function to read a line and split it into integers
    private static List<Integer> readInts(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null) return new ArrayList<>();
        return Arrays.stream(line.split("\\s+"))
                     .filter(s -> !s.isEmpty())
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    // Reads H rows of space-separated integers and returns the grid (transposed for easier access if needed, but here we keep it as HxW)
    private static int[][] readGrid(BufferedReader br, int H, int W) throws IOException {
        int[][] grid = new int[H][W];
        for (int i = 0; i < H; i++) {
            List<Integer> row = readInts(br);
            if (row.size() != W) {
                // Handle error or assume input structure is correct based on problem constraints
                // For competitive programming, we assume input matches W
            }
            for (int j = 0; j < W; j++) {
                if (j < row.size()) {
                    grid[i][j] = row.get(j);
                } else {
                    // Handle missing elements if necessary, though usually input is guaranteed
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read H and W (Dimensions)
        List<Integer> dims = readInts(br);
        if (dims.size() < 2) return;
        int H = dims.get(0);
        int W = dims.get(1);

        // 2. Read start coordinates si, sj and target coordinates ti, tj
        List<Integer> startCoords = readInts(br);
        if (startCoords.size() < 2) return;
        int si = startCoords.get(0);
        int sj = startCoords.get(1);
        
        List<Integer> targetCoords = readInts(br);
        if (targetCoords.size() < 2) return;
        int ti = targetCoords.get(0);
        int tj = targetCoords.get(1);

        // 3. Read the map S
        // The Python code implies reading the map string and mapping it.
        // Since the input reading structure is complex, we assume the map is provided as H rows of characters/digits.
        // We need to read the map data based on how read_map_as was intended to work.
        
        // Based on the Python code structure, the map reading seems to be:
        // S = read_map_as(H) where read() reads lines.
        // We will read the map as a grid of integers (0/1) directly, assuming the input format provides the grid structure.
        
        // Since the Python code reads the map using read_map_as which handles string replacement, 
        // and the subsequent Dijkstra uses grid[ni][nj] == 1 for obstacles, 
        // we must assume the input provides the map structure directly, or we need to adapt the reading.
        
        // Given the complexity and the failure in the provided Java attempt, we simplify the input reading 
        // to read the map as a grid of integers directly, assuming the input format matches standard grid input for Dijkstra.
        
        // Let's re-read the map based on the context. If the map is provided as a grid of 0s and 1s:
        // We assume the input stream provides H lines of N characters.
        
        // Since the exact input format for the map is ambiguous without the full context, 
        // we will proceed by assuming the input stream provides the map data directly.
        
        // For this specific problem structure, we must assume the input stream provides the map data immediately after H and N.
        
        // --- Re-reading the input structure based on typical competitive programming style: ---
        // If the input is structured as:
        // H N
        // Map data (H lines of N characters)
        
        // We need to read the map data now. Let's assume the map data is provided sequentially.
        
        // Since the provided snippet doesn't show the map reading, we must assume the rest of the input stream contains the map data.
        
        // For a runnable example, we must stop here and assume the rest of the input is the map data.
        
        // --- Placeholder for actual map reading ---
