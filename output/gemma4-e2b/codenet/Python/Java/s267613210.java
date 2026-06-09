import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class s267613210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read K and N from the first line
        String line1 = br.readLine();
        if (line1 == null) return;
        StringTokenizer st1 = new StringTokenizer(line1);
        
        // K and N are read, but N is unused in the logic derived from the Python code structure
        // K = Integer.parseInt(st1.nextToken());
        // int N = Integer.parseInt(st1.nextToken());

        // Read A from the second line
        String line2 = br.readLine();
        if (line2 == null) return;
        StringTokenizer st2 = new StringTokenizer(line2);
        
        List<Integer> A = new ArrayList<>();
        while (st2.hasMoreTokens()) {
            A.add(Integer.parseInt(st2.nextToken()));
        }

        if (A.size() < 2) {
            // Handle case where A is too short, though constraints usually prevent this
            return;
        }

        // K is implicitly needed. Since the Python code reads K, N first, and then A, 
        // we must assume K is available somehow. 
        // Based on the structure, K must be the first number read, and N the second.
        // Since we read K and N from line1, we need to re-parse line1 to get K.
        
        // Re-reading K and N based on the Python structure:
        // K, N = input_nums()
        // A = input_nums()
        
        // Let's assume the input is structured such that K and N are on the first line, and A on the second.
        // If the input is provided as two separate lines:
        
        // Rereading input based on the assumption that the first line