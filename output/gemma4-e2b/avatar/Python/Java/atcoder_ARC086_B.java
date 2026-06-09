import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class atcoder_ARC086_B {

    // Helper function to read a line and tokenize it
    private static List<Integer> readInts(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null) return new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line);
        List<Integer> result = new ArrayList<>();
        while (st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }

    // Helper function to read a single integer (mimicking I())
    private static int readInt(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null) return 0; // Handle EOF if necessary, though context implies input exists
        return Integer.parseInt(line.trim());
    }

    // Helper function to read space-separated integers (mimicking II() and III())
    private static List<Integer> readIntList(BufferedReader br) throws IOException {
        // This function is complex in Python, let's assume we read the next line for the array a
        return readInts(br);
    }

    // my_sign(x) implementation
    private static int mySign(int x) {
        if (x > 0) return 1;
        if (x < 0) return -1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // I() reads N
        int N = readInt(br);

        // III() reads the array a
        List<Integer> a = readIntList(br);

        if (a.size() != N) {
            // Handle case where input size mismatch if necessary, though usually assumed correct in CP context
            // For robustness, we proceed with what we read.
        }

        long maxVal = 0;
        int maxSign = 0;
        int maxIndex = -1;

        for (int i = 0; i < N; i++) {
            int a0 = a.get(i);
            if (Math.abs(a0) > maxVal) {
                maxVal = Math.abs(a0);
                maxSign = mySign(a0);
                maxIndex = i;
            }
        }

        if (maxSign == 0) {
            System.out.println(0);
        } else if (maxSign == 1) {
            System.out.println(2 * N - 1);
            // Print max_index + 1, i + 1 for i = 0 to N-1
            for (int i = 0; i < N; i++) {
                System.out.println(maxIndex + 1 + " " + (i + 1));
            }
            // Print i + 1, i + 2 for i = 0 to N-2
            for (int i = 0; i < N - 1; i++) {
                System.out.println(i + 1 + " " + (i + 2));
            }