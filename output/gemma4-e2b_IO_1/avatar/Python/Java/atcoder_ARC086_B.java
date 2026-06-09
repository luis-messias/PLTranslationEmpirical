import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class atcoder_ARC086_B {

    // Helper function to read a line and tokenize it
    private static List<Integer> readIntList(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null) return new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line);
        List<Integer> result = new ArrayList<>();
        while (st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }

    // my_sign(x) implementation: returns 1 if x>0, -1 if x<0, 0 if x=0
    private static int mySign(int x) {
        if (x > 0) return 1;
        if (x < 0) return -1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // I() reads N
        // We assume N is read from the first line
        int N;
        try {
            N = Integer.parseInt(br.readLine().trim());
        } catch (Exception e) {
            // Handle case where N reading fails (e.g., empty input)
            return;
        }

        // III() reads the array a. Based on the Python structure, this reads the next line.
        // Since the Python code structure is highly ambiguous regarding how N lines of N numbers are read,
        // we assume the input structure is N, followed by N lines of N numbers, as is typical.
        // However, the Python code only calls III() once after reading N.
        // Let's assume the input structure is: N, followed by N lines of N numbers.
        
        // The Python code structure suggests reading N, then reading the data structure 'a'.
        // If 'a' is supposed to be the matrix, we need N lines of input.
        
        // Let's read the matrix A (N rows, N columns)
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> row = readIntList(br);
            a.add(row);
        }


        long maxVal = 0;
        int maxSign = 0;
