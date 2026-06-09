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
        if (kLine == null) return;
        int k = Integer.parseInt(kLine.trim());

        int l = 0;
        // Calculate l: count of leading '1's
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '1') {
                break;
            }
            l++;
        }

        // Python logic:
        // if l >= k : return 1
        // return s[l]

        if (l >= k) {
            System.out.println(1);
        } else {
            // If l < k, return s[l]. We must ensure l is a valid index.
            // Since l is the count of leading '1's, and we broke when s.charAt(l) != '1',
            // l is the index of the first non-'1' character, or l = s.length() if all are '1'.
            
            // If l == s.length(), it means all characters are '1'. If l < k, we attempt s[l], which is out of bounds.
            // Based on the Python code structure, we assume the input guarantees s[l] is valid if l < k.
            // If l == s.length(), and l < k, the Python code would crash. 
            // We must handle the case where l == s.length() explicitly if we want to avoid IndexOutOfBoundsException.
            
            if (l < s.length()) {
                // l is the index of the first non-'1' character
                System.out.println(s.charAt(l));
            } else {
                // All characters are '1'. If l < k, the Python code would attempt s[
