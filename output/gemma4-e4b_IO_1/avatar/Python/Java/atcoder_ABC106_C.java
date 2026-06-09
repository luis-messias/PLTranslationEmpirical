import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class atcoder_ABC106_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Equivalent to s = S()
        String s = br.readLine();

        // Equivalent to k = I()
        String kLine = br.readLine();
        if (kLine == null) {
            return;
        }
        int k = Integer.parseInt(kLine);

        // Calculate l
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '1') {
                break;
            }
            l++;
        }

        // Determine the return value and print it
        if (l >= k) {
            // Python returns 1 (integer)
            System.out.println(1);
        } else {
            // Python returns s[l] (character)
            // We print the character at index l.
            System.out.println(s.charAt(l));
        }
    }
}
