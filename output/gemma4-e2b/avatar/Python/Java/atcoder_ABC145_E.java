import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class atcoder_ABC145_E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and T
        String line = br.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // time_value stores pairs (TIME, VAL)
        // We need N+1 entries, the first one is a placeholder.
        // Since the Python code reads N lines of data after N, T, we read them here.
        
        // time_value will store the actual data for N items.
        // We use an array of arrays/objects to store (TIME, VAL)
        int[][] timeValue = new int[N][2];

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            if (line == null) break;
            StringTokenizer stItem = new StringTokenizer(line);
            timeValue[i][0] = Integer.parseInt(stItem.nextToken()); // TIME
            timeValue[i][1] = Integer.parseInt(stItem.nextToken()); // VAL
        }

        // The Python code seems to handle the input reading slightly differently, 
        // reading N, T, and then N subsequent lines of data.
        // Let's re-examine the Python input reading structure based on the provided snippet:
        /*
        N , T = [ int ( a ) for a in input ( ).split ( ) ]
        time_value = [ ( -1 , -1 ) ] + [ None ] * ( N )
        for i in range ( 1 , N + 1 ) :
            time_value [ i ] = tuple ( int ( a ) for a in input ( ).split ( ) )
        */
        // This implies the first line is N T, and the next N lines are the data.
        // The Python code uses input() which reads the next line.

        // Let's re-read the input assuming the standard competitive programming format where N, T are on the first line, and N subsequent lines contain the data.
        // If the provided Python code snippet is exactly what needs to be translated, we must assume the input stream provides N, T, and then N lines of data.

        // Re-reading input based on the structure implied by the Python code:
        // The Python code reads N, T from the first line.
        // Then it reads N subsequent lines for the actual data.
        
        // Let's adjust the reading to match the structure implied by the Python code's flow, assuming the input stream is sequential.
        
        // Since we already read N and T, we need to read the N data lines.
        
        // time_value array setup (N items)
        // We will store the data in a structure that allows sorting by VAL.
        
        // Create an array of objects/arrays to hold the items (Time, Value)
        class Item {
            int time;
            int val;
            Item(int t, int v) { this.time = t; this.val = v; }
        }

        Item[] items = new Item[N];
        for (int i = 0; i < N; i++) {
            // We need