import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC155_E {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input string s
        if (!scanner.hasNextLine()) {
            // Handle case where no input is provided
            return;
        }
        String s = scanner.nextLine();
        
        // The core logic is contained in the Python function main()
        
        // pmin = 1000, mmin = 0
        int pmin = 1000;
        int mmin = 0;
        
        // s = '0' + s
        String sPadded = "0" + s;
        
        // Iterate over sPadded backwards (equivalent to Python's s[::-1])
        // The loop runs from the last character (index sPadded.length() - 1) down to 0.
        for (int i = sPadded.length() - 1; i >= 0; i--) {
            char c = sPadded.charAt(i);
            // v = int(c)
            int v = Character.getNumericValue(c);
            
            // npmin = min(pmin + 10 - (v + 1), mmin + 10 - v)
            int npmin = Math.min(pmin + 10 - (v + 1), mmin + 10 - v);
            
            // nmmin = min(pmin + v + 1, mmin + v)
            int nmmin = Math.min(pmin + v + 1, mmin + v);
            
            // Update pmin and mmin
            pmin = npmin;
            mmin = nmmin;
        }
        
        // return min(pmin, mmin)
        int result = Math.min(pmin, mmin);
        
        System.out.println(result);
        
        scanner.close();
    }
}