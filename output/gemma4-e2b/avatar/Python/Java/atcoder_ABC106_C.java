import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class atcoder_ABC106_C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // S = S() (Reads the first line, the string s)
        String s = br.readLine();

        // k = I() (Reads the second line, the integer k)
        String kLine = br.readLine();
        if (kLine == null) return; // Handle EOF if necessary
        int k = Integer.parseInt(kLine.trim());

        int l = 0;
        // Iterate through s to find the first non-'1' character
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '1') {
                break;
            }
            l++;
        }

        // The Python code logic:
        // if l >= k : return 1
        // return s[l]

        if (l >= k) {
            System.out.println(1);
        } else {
            // If l is the index of the first non-'1' character, 
            // the Python code returns s[l].
            // Note: If the loop breaks at index i, then l = i.
            // If s = "1110", l=3. s[3] = '0'.
            // If s = "1111", l=4. Loop finishes. l=4. If k=5, l<k, returns s[4] (IndexOutOfBounds if s.length()=4).
            
            // Let's re-examine the Python loop:
            /*
            l = 0
            for c in s :
                if c != '1' :
                    break
                l += 1
            */
            // If s = "1110", 
            // c='1', l=1
            // c='1', l=2
            // c='1', l=3
            // c='0', break. l=3.
            // If l=3, and k=5, l < k. Returns s[3] ('0').
            
            // If s = "1111", 
            // l=4. Loop finishes.
            // If k=5, l < k. Returns s[4]. This would cause an IndexOutOfBoundsException if s.length()=4.
            
            // The Python code implies that if the loop finishes without breaking, l is the length of the string (all '1's).
            // If l is the count of leading '1's, and we are looking for s[l], this implies l must be a valid index.
            
            // If s = "1111" (length 4), l=4. If k=5, l < k. s[4] is out of bounds.
            // This suggests that if the loop finishes, the result should be based on the length of s, or the logic implies that the index l must be within bounds.
            
            // Given the structure, if l is the count of '1's, and we are looking for the character *after* the '1's, the index should be l.
            
            // If l == s.length(), it means all characters are '1'. The Python code returns s[l], which is an error if l == s.length().
            // Let's assume the intent is to return the character at index l, which is the first non-'1' character, OR